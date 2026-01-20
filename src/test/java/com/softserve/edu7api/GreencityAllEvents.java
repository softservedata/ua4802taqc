package com.softserve.edu7api;

import java.util.List;

class GreencityAllEvents {
    private List<EventInner> page;
    private int totalElements;
    private int currentPage;
    private int totalPages;
    private int number;
    private boolean hasPrevious;
    private boolean hasNext;
    private boolean first;
    private boolean last;

    public GreencityAllEvents(List<EventInner> page, int totalElements, int currentPage,
                              int totalPages, int number, boolean hasPrevious,
                              boolean hasNext, boolean first, boolean last) {
        this.page = page;
        this.totalElements = totalElements;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.number = number;
        this.hasPrevious = hasPrevious;
        this.hasNext = hasNext;
        this.first = first;
        this.last = last;
    }

    @Override
    public String toString() {
        return "GreencityAllEvents{" +
                "page=" + page +
                "\ntotalElements=" + totalElements +
                ", currentPage=" + currentPage +
                ", totalPages=" + totalPages +
                ", number=" + number +
                ", hasPrevious=" + hasPrevious +
                ", hasNext=" + hasNext +
                ", first=" + first +
                ", last=" + last +
                '}';
    }
}  