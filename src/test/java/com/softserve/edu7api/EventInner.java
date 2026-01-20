package com.softserve.edu7api;

public class EventInner {
    private int id;
    private String title;
    private OrganizerInner organizer;
    private String creationDate;
    private String description;

    public EventInner(int id, String title, OrganizerInner organizer, String creationDate, String description) {
        this.id = id;
        this.title = title;
        this.organizer = organizer;
        this.creationDate = creationDate;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public OrganizerInner getOrganizer() {
        return organizer;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "\n{" +
                "\tid=" + id +
                ", \ttitle='" + title + '\'' +
                ", \torganizer=" + organizer +
                ", \tcreationDate='" + creationDate + '\'' +
                ", \tdescription='" + description + '\'' +
                "\t}";
    }
}