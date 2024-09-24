package todo.tareas.services;

import java.util.List;

import todo.tareas.models.Todo;

public interface ITodoService {

    public List<Todo> listAll();
    public Todo searchTodoById(Integer id);
    public void saveTodo(Todo todo);
    public void deleteTodo(Todo todo);
}
