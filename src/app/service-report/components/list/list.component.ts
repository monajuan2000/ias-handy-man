import { Technical } from './../../../shared/models/TechniciansModel';
import { ReportService } from './../../services/report.service';
import { Component, OnInit, ViewChild } from '@angular/core';


@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {
  displayedColumns: string[] = ['CC', 'name','service'];
  dataSource:any;

  constructor(private service: ReportService) { }

  ngOnInit(): void {
    this.listRequest();
   
  }
  listRequest(){
    this.service.list().subscribe(data =>{
     this.dataSource = data
   })
 }
  update():void{
    
  }
  requestService(technical:Technical){
    this.service.technical.name = technical.name
    this.service.technical.cc = technical.cc
    this.service.report.idTechnical = technical.id
  }
}