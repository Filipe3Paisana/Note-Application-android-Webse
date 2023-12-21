package pt.iade.filipepaisana.controllers;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iade.filipepaisana.models.NoteItem;
import pt.iade.filipepaisana.models.repositories.NoteItemRepository;
import pt.iade.filipepaisana.models.*;
import pt.iade.filipepaisana.models.exceptions.NotFoundException;
import pt.iade.filipepaisana.models.repositories.NoteItemRepository;
import pt.iade.filipepaisana.models.responses.Response;
import static pt.iade.filipepaisana.models.repositories.NoteItemRepository.notes;


@RestController
@RequestMapping(path = "/api/notes")

public class NoteItemController {
    private Logger logger = LoggerFactory.getLogger(NoteItemController.class);

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteItem> getNotes() {
        logger.info("Sending all notes");
        return NoteItemRepository.getNoteItem();
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteItem getNoteItem(@PathVariable("id") int id)
            throws NotFoundException {
        logger.info("Sending notes with id " + id);
        NoteItem note = NoteItemRepository.getNoteItem(id);
        if (note != null)
            return note;
        else
            throw new NotFoundException("" + id, "Note", "number");
    }

    @DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteNoteItem(@PathVariable("id") int id) {
        logger.info("Deleting note with id " + id);
        if (NoteItemRepository.deleteNoteItem(id))
            return new Response("Note " +id + " was deleted.", null);
        else
            return new Response("Note " + id + " not found.", null);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteItem addNoteItem(@RequestBody NoteItem note) {
        logger.info("Including new note " + note);
        NoteItemRepository.addNoteItem(note);
        return note;
    }

}