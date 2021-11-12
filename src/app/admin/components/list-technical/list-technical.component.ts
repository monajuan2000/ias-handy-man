import { CreateService } from './../../services/create.service';
import { ReportService } from './../../../service-report/services/report.service';
import { Component, OnInit } from '@angular/core';



@Component({
  selector: 'app-list-technical',
  templateUrl: './list-technical.component.html',
  styleUrls: ['./list-technical.component.scss']
})
export class ListTechnicalComponent implements OnInit {
  displayedColumns: string[] = ['CC', 'name', 'actions'];
  public dataSource:any;
  public elemento:any;

  constructor(private service: CreateService) { }

  ngOnInit(): void {
    this.service.list().subscribe(data =>{
      this.dataSource = data
    })
  }
  requestService(name: string,cc: string){
    this.service.technical.name = name
    this.service.technical.cc = cc
  }
}
