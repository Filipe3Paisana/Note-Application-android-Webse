package pt.iade.filipepaisana.models.repositories;

import pt.iade.filipepaisana.models.NoteItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
public class NoteItemRepository {
    public static ArrayList<NoteItem> notes = new ArrayList<NoteItem>();

    public static void populate() {
        NoteItem s; // auxiliary variable
        notes.add(new NoteItem(1, "Note 1", "Content 1", new GregorianCalendar(), new GregorianCalendar()));
        notes.add(new NoteItem(2, "Note 2", "Content 2", new GregorianCalendar(), new GregorianCalendar()));
        notes.add(new NoteItem(3, "Note 3", "Content 3", new GregorianCalendar(), new GregorianCalendar()));
    }
    public static List<NoteItem> getNoteItem() {
        return notes;
    }

    public static NoteItem getNoteItem(int id) {
        for (NoteItem note : notes)
            if (note.getId() == id)
                return note;
        return null;
    }

    public static boolean deleteNoteItem(int id) {
        return notes.removeIf(
                (note) -> note.getId() == id);
    }

    public static NoteItem addNoteItem(NoteItem note) {
        notes.add(note);
        return note;
    }
}
