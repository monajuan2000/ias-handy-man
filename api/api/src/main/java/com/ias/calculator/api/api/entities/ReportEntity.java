// package com.ias.calculator.api.api.entities;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;

// @Entity
// @Table(name = "reports")
// public class ReportEntity {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private int order;
//     private String date;
//     @Column(name = "start_hour")
//     private String startHour;
//     @Column(name = "final_hour")
//     private String finalHour;
//     // @ManyToOne
//     // @JoinColumn(name = "technical_id")
//     // private TechnicalEntity technicalEntity;
    
//     public ReportEntity() {
//     }

//     public Long getId() {
//         return id;
//     }

    

//     public void setId(Long id) {
//         this.id = id;
//     }

    
//     @Override
//     public String toString() {
//         return "ReportEntity [date=" + date + ", finalHour=" + finalHour + ", id=" + id + ", order=" + order
//                 + ", startHour=" + startHour + "]";
//     }

//     public int getOrder() {
//         return order;
//     }

//     public void setOrder(int order) {
//         this.order = order;
//     }

//     public String getDate() {
//         return date;
//     }

//     public void setDate(String date) {
//         this.date = date;
//     }

//     public String getStartHour() {
//         return startHour;
//     }

//     public void setStartHour(String startHour) {
//         this.startHour = startHour;
//     }

//     public String getFinalHour() {
//         return finalHour;
//     }

//     public void setFinalHour(String finalHour) {
//         this.finalHour = finalHour;
//     }

    

    
// }
