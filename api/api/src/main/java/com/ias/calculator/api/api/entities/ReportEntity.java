package com.ias.calculator.api.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reports")
public class ReportEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_technical")
    private Long idTechnical;
    @Column(name = "order_report")
    private String order;
    @Column(name = "date_report")
    private String date;
    @Column(name = "start_hour")
    private String startHour;
    @Column(name = "final_hour")
    private String finalHour;
    
    public ReportEntity(Long id, Long idTechnical, String order, String date, String startHour, String finalHour) {
        this.id = id;
        this.idTechnical = idTechnical;
        this.order = order;
        this.date = date;
        this.startHour = startHour;
        this.finalHour = finalHour;
    }
    public ReportEntity() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getIdTechnical() {
        return idTechnical;
    }
    public void setIdTechnical(Long idTechnical) {
        this.idTechnical = idTechnical;
    }
    public String getOrder() {
        return order;
    }
    public void setOrder(String order) {
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

    


    
}
