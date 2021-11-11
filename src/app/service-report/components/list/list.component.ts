import { ReportService } from './../../services/report.service';
import { Component, OnInit, ViewChild } from '@angular/core';

export interface PeriodicElement {
  name: string;
  CC: number;
  icon: any;
}

const ELEMENT_DATA: PeriodicElement[] = [
  { CC: 17644789, name: 'Juan Esteban Moná', icon: 'miscellaneous_services' },
  { CC: 17644789, name: 'Juan Esteban Moná', icon: 'miscellaneous_services' },
  { CC: 17644789, name: 'Juan Esteban Moná', icon: 'miscellaneous_services' },
  { CC: 17644789, name: 'Juan Esteban Moná', icon: 'miscellaneous_services' },
  { CC: 17644789, name: 'Juan Esteban Moná', icon: 'miscellaneous_services' },
  { CC: 17644789, name: 'Juan Esteban Moná', icon: 'miscellaneous_services' },
  { CC: 17644789, name: 'Juan Esteban Moná', icon: 'miscellaneous_services' },
  { CC: 17644789, name: 'Juan Esteban Moná', icon: 'miscellaneous_services' },
  { CC: 17644789, name: 'Juan Esteban Moná', icon: 'miscellaneous_services' },
  { CC: 17644789, name: 'Juan Esteban Moná', icon: 'miscellaneous_services' },
  { CC: 17644789, name: 'Juan Esteban Moná', icon: 'miscellaneous_services' },
  { CC: 17644789, name: 'Juan Esteban Moná', icon: 'miscellaneous_services' },
  { CC: 17644789, name: 'Juan Esteban Moná', icon: 'miscellaneous_services' },
  { CC: 17644789, name: 'Juan Esteban Moná', icon: 'miscellaneous_services' },
  { CC: 17644789, name: 'Juan Esteban Moná', icon: 'miscellaneous_services' },
  { CC: 17644789, name: 'Juan Esteban Moná', icon: 'miscellaneous_services' },
  { CC: 17644789, name: 'Juan Esteban Moná', icon: 'miscellaneous_services' },

];
@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {
  displayedColumns: string[] = ['CC', 'name', 'icon'];
  dataSource = ELEMENT_DATA;

  constructor(private service: ReportService) { }

  ngOnInit(): void {

  }
  requestService(name: string,cc: number){
    this.service.technical.name = name
    this.service.technical.cc = cc
  }

}