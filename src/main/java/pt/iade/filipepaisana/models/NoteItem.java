package pt.iade.filipepaisana.models;


import java.util.Calendar;

public class NoteItem {
    int id;
    static int nextId = 1;
    String title;
    String content;
    Calendar creationDate;
    Calendar modifiedDate;

    public NoteItem(int id,String title, String content, Calendar creationDate, Calendar modifiedDate)
    {
        this.id = nextId;
        nextId++;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.modifiedDate = modifiedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public Calendar getModifiedDate() {
        return modifiedDate;
    }
    public String getModifiedDateAsString() {
        return modifiedDate.get(Calendar.YEAR)+ "-" + modifiedDate.get(Calendar.MONTH) + "-" + modifiedDate.get(Calendar.DAY_OF_MONTH);
    }
    public String getCreationDateAsString() {
        return creationDate.get(Calendar.YEAR)+ "-" + creationDate.get(Calendar.MONTH) + "-" + creationDate.get(Calendar.DAY_OF_MONTH);
    }
    public void setModifiedDate(Calendar modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


}
