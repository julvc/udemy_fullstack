package todo.tareas.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import todo.tareas.models.Todo;

public interface TodoRepository extends JpaRepository<Todo,Integer>{

}
