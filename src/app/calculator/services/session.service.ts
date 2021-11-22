import { Technical } from './../../shared/models/TechniciansModel';
import { environment } from './../../../environments/environment';
import { Report } from './../../shared/models/ReportModel';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SessionService {
  pathR = '/reports'
  pathT = '/technical'
  report:Report
  technical:Technical
  listT: any

  session = {id:0,cc:'',name:'', week:'',state:true, expansion:false}
  listHours:any;

  constructor(private http:HttpClient) { 
    this.report = new Report();
    this.technical = new Technical()
    this.listHours = new Array();
  }
  list(id:any){
    return this.http.get<Array<Report>>(`${environment.apiUrl}${this.pathR}/findByTechnical/${id}`)
  }
  findByCC(){
    return this.http.get<Technical>(`${environment.apiUrl}${this.pathT}/findByCC/${this.session.cc}`)
  }
  calculator(){
    return this.http.get<any>(`${environment.apiUrl}${this.pathR}/hours/${this.session.id}/${this.session.week}`)
  }
}
