package com.softserve.edu7api;

public class OrganizerInner {
    private int id;
    private String name;

    public OrganizerInner(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\t\torganizer{" +
                "\t\tid=" + id +
                ", \t\tname='" + name + '\'' +
                "\t\t}";
    }
}