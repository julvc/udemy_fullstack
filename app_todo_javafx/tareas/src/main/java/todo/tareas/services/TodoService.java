package todo.tareas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.tareas.models.Todo;
import todo.tareas.repository.TodoRepository;

@Service
public class TodoService implements ITodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> listAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo searchTodoById(Integer id) {
        Todo todo = todoRepository.findById(id).orElse(null);
        return todo;
    }

    @Override
    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Todo todo) {
        todoRepository.delete(todo);
    }

}
