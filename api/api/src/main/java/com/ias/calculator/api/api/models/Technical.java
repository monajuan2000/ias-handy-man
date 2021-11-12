package com.ias.calculator.api.api.models;

import lombok.Data;

@Data
public class Technical {
    private Long id;
    private String cc;

    public Long getId() {
        return id;
    }

    public Technical() {
    }

    @Override
    public String toString() {
        return "Technical{" +
                "id=" + id +
                ", cc='" + cc + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
