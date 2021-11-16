package com.ias.calculator.api.api.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "technicians")
public class TechnicalEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cc;
    private String name;
    // @ManyToMany
    // @JoinTable(name = "technical_reports"
    //             ,joinColumns=@JoinColumn(name="technical_id")
    //             ,inverseJoinColumns =@JoinColumn(name="report_id"))
    // private Set<ReportEntity> reportEntity;

    public TechnicalEntity(){

    }

    @Override
    public String toString() {
        return "TechnicalEntity [cc=" + cc + ", id=" + id + ", name=" + name + "]";
    }


    public TechnicalEntity(Long id, String cc, String name){
        this.id = id;
        this.cc = cc;
        this.name = name;
    }
    public TechnicalEntity(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public TechnicalEntity(String cc, String name){
        this.cc = cc;
        this.name = name;
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
}
