package todo.tareas;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import todo.tareas.presentation.SystemTodoFX;

@SpringBootApplication
public class TodoApplication {
	public static void main(String[] args) {
		Application.launch(SystemTodoFX.class, args);
		//SpringApplication.run(TareasApplication.class, args);
	}

}
