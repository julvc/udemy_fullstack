package todo.tareas.presentation;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import todo.tareas.TodoApplication;

public class SystemTodoFX extends Application {

    //public static void main(String[] args) {
    //    launch(args);
    //}

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init(){
        this.applicationContext = new SpringApplicationBuilder(TodoApplication.class).run();
    }
    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader =
                new FXMLLoader(TodoApplication.class.getResource("/templates/index.fxml"));
        loader.setControllerFactory(applicationContext::getBean);
        Scene escena = new Scene(loader.load());
        stage.setScene(escena);
        stage.show();
    }

    @Override
    public void stop(){
        applicationContext.close();
        Platform.exit();
    }
}
