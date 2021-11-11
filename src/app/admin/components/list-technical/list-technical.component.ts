import { ReportService } from './../../../service-report/services/report.service';
import { Component, OnInit } from '@angular/core';
export interface PeriodicElement {
  name: string;
  CC: number;
  icon: any;
}

const ELEMENT_DATA: PeriodicElement[] = [
  { CC: 17644789, name: 'Juan Esteban Moná', icon:{delete:'delete',edit:'edit'} },
  { CC: 17644789, name: 'Juan Esteban Moná', icon:{delete:'delete',edit:'edit'} },
  { CC: 17644789, name: 'Juan Esteban Moná', icon:{delete:'delete',edit:'edit'} },
  { CC: 17644789, name: 'Juan Esteban Moná', icon:{delete:'delete',edit:'edit'} },
  { CC: 17644789, name: 'Juan Esteban Moná', icon:{delete:'delete',edit:'edit'} },
  { CC: 17644789, name: 'Juan Esteban Moná', icon:{delete:'delete',edit:'edit'} },
  { CC: 17644789, name: 'Juan Esteban Moná', icon:{delete:'delete',edit:'edit'} },
  { CC: 17644789, name: 'Juan Esteban Moná', icon:{delete:'delete',edit:'edit'} },
  { CC: 17644789, name: 'Juan Esteban Moná', icon:{delete:'delete',edit:'edit'} },
  { CC: 17644789, name: 'Juan Esteban Moná', icon:{delete:'delete',edit:'edit'} },
  { CC: 17644789, name: 'Juan Esteban Moná', icon:{delete:'delete',edit:'edit'} },
  { CC: 17644789, name: 'Juan Esteban Moná', icon:{delete:'delete',edit:'edit'} },
  { CC: 17644789, name: 'Juan Esteban Moná', icon:{delete:'delete',edit:'edit'} },
  { CC: 17644789, name: 'Juan Esteban Moná', icon:{delete:'delete',edit:'edit'} },
  { CC: 17644789, name: 'Juan Esteban Moná', icon:{delete:'delete',edit:'edit'} },
  { CC: 17644789, name: 'Juan Esteban Moná', icon:{delete:'delete',edit:'edit'} },
  { CC: 17644789, name: 'Juan Esteban Moná', icon:{delete:'delete',edit:'edit'} },
  { CC: 17644789, name: 'Juan Esteban Moná', icon:{delete:'delete',edit:'edit'} },
  
  

];
@Component({
  selector: 'app-list-technical',
  templateUrl: './list-technical.component.html',
  styleUrls: ['./list-technical.component.scss']
})
export class ListTechnicalComponent implements OnInit {
  displayedColumns: string[] = ['CC', 'name', 'delete'];
  dataSource = ELEMENT_DATA;

  constructor(private service: ReportService) { }

  ngOnInit(): void {

  }
  requestService(name: string,cc: number){
    this.service.technical.name = name
    this.service.technical.cc = cc
  }
}
