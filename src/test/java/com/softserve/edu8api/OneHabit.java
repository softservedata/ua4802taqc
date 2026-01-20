package com.softserve.edu8api;

import java.util.List;

public class OneHabit {
    private int id;
    private int complexity;
    private List<ToDoListItems> toDoListItems;
    private boolean isCustomHabit;
    private String habitAssignStatus;

    public OneHabit(int id, int complexity, List<ToDoListItems> toDoListItems, boolean isCustomHabit, String habitAssignStatus) {
        this.id = id;
        this.complexity = complexity;
        this.toDoListItems = toDoListItems;
        this.isCustomHabit = isCustomHabit;
        this.habitAssignStatus = habitAssignStatus;
    }

    public int getId() {
        return id;
    }

    public int getComplexity() {
        return complexity;
    }

    public List<ToDoListItems> getToDoListItems() {
        return toDoListItems;
    }

    public boolean isCustomHabit() {
        return isCustomHabit;
    }

    public String getHabitAssignStatus() {
        return habitAssignStatus;
    }

    @Override
    public String toString() {
        return "\n\t\tOneHabit{" +
                "id=" + id +
                ", complexity=" + complexity +
                ", toDoListItems=" + toDoListItems +
                ", isCustomHabit=" + isCustomHabit +
                ", habitAssignStatus='" + habitAssignStatus + '\'' +
                "}\n";
    }
}
