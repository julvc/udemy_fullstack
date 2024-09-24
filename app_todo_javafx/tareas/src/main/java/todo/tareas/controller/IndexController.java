package todo.tareas.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import todo.tareas.models.Todo;
import todo.tareas.services.TodoService;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class IndexController implements Initializable {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private TodoService todoService;

    @FXML
    private TableView<Todo> todoTable;

    @FXML
    private TableColumn<Todo,Integer> idColumn;

    @FXML
    private TableColumn<Todo,String> nameTodoColumn;

    @FXML
    private TableColumn<Todo,String> responsableColumn;

    @FXML
    private TableColumn<Todo,String> statusColumn;

    private final ObservableList<Todo> todoObservableList = FXCollections.observableArrayList();
    @FXML
    private TextField txtlblTodo;

    @FXML
    private TextField txtlblResponsable;

    @FXML
    private TextField txtlblStatus;

    private Integer idTemp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        todoTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        configurationColumns();
        listTodo();
    }

    private void configurationColumns() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTodoColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        responsableColumn.setCellValueFactory(new PropertyValueFactory<>("responsable"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

    }

    private void listTodo() {
        logger.info("Ejecutando listado de tareas");
        todoObservableList.clear();
        todoObservableList.addAll(todoService.listAll());
        todoTable.setItems(todoObservableList);

    }

    public void addTodo() {
        if (txtlblTodo.getText().isEmpty()) {
            showMessage("Error de validación", "Debe proporcionar una tarea primero");
            txtlblTodo.requestFocus();
            return;
        }else{
            var todo = new Todo();
            collectDataFromForm(todo);
            todo.setId(null);
            todoService.saveTodo(todo);
            clearForm();
            listTodo();
        }
    }

    private void collectDataFromForm(Todo todo) {
        if(idTemp != null){
            todo.setId(idTemp);
        }
        todo.setName(txtlblTodo.getText());
        todo.setResponsable(txtlblResponsable.getText());
        todo.setStatus(txtlblStatus.getText());
    }

    private void showMessage(String title, String msge) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msge);
        alert.showAndWait();
    }

    public void clearForm() {
        idTemp = null;
        txtlblTodo.clear();
        txtlblResponsable.clear();
        txtlblStatus.clear();
    }

    public void loadTodoForm() {
        var todo = todoTable.getSelectionModel().getSelectedItem();
        if(todo != null){
            idTemp = todo.getId();
            txtlblTodo.setText(todo.getName());
            txtlblResponsable.setText(todo.getResponsable());
            txtlblStatus.setText(todo.getStatus());
        }
    }

    public void modifyTodo() {
        if(idTemp == null){
            showMessage("Informacion", "Debe seleccionar primero un registro de tareas");
            return;
        }

        if(txtlblTodo.getText().isEmpty()){
            showMessage("Error de validacion", "Debe proporcionar una tarea");
            txtlblTodo.requestFocus();
            return;
        }

        var todo = new Todo();
        collectDataFromForm(todo);
        todoService.saveTodo(todo);
        showMessage("Informacion","Tarea modificada");
        clearForm();
        listTodo();
    }

    public void deleteTodo() {
        var todo = todoTable.getSelectionModel().getSelectedItem();
        if(todo != null){
            logger.info("Registro a eliminar " + todo.toString());
            todoService.deleteTodo(todo);
            showMessage("Informacion", "Tarea eliminada: " + todo.getId());
            clearForm();
            listTodo();
        }else{
            showMessage("Error de validacion", "No se ha seleccionado ninguna Tarea");
        }
    }
}
