package com.softserve.edu8api;

public class ToDoListItems {
    private int id;
    private String text;
    private String status;

    public ToDoListItems(int id, String text, String status) {
        this.id = id;
        this.text = text;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "\n\t\t\tToDoListItems{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", status='" + status + '\'' +
                "}\n";
    }
}
