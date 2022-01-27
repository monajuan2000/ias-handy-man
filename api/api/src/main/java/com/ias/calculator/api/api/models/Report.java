package com.ias.calculator.api.api.models;


public class Report {
    private Long id;
    private int order;
    private String date;
    private String startHour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", order=" + order +
                ", date='" + date + '\'' +
                ", startHour='" + startHour + '\'' +
                ", finalHour='" + finalHour + '\'' +
                '}';
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getFinalHour() {
        return finalHour;
    }

    public void setFinalHour(String finalHour) {
        this.finalHour = finalHour;
    }

    private String finalHour;
}
