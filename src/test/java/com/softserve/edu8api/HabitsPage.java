package com.softserve.edu8api;

import java.util.List;

public class HabitsPage {
    private List<OneHabit> page;
    private int totalElements;
    private int currentPage;
    private int totalPages;

    public HabitsPage(List<OneHabit> page, int totalElements, int currentPage, int totalPages) {
        this.page = page;
        this.totalElements = totalElements;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
    }

    public List<OneHabit> getPage() {
        return page;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    @Override
    public String toString() {
        return "HabitsPage{" +
                "page=" + page +
                ", totalElements=" + totalElements +
                ", currentPage=" + currentPage +
                ", totalPages=" + totalPages +
                "}\n";
    }
}
