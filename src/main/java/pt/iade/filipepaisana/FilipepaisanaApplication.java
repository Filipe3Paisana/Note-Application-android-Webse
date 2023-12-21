package pt.iade.filipepaisana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pt.iade.filipepaisana.models.NoteItem;
import pt.iade.filipepaisana.models.repositories.NoteItemRepository;
import pt.iade.filipepaisana.controllers.NoteItemController;

@SpringBootApplication
public class FilipepaisanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilipepaisanaApplication.class, args);
		NoteItemRepository.populate();
	}
}
