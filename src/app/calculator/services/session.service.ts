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
  

  constructor(private http:HttpClient) { 
    this.report = new Report();
    this.technical = new Technical()
  }
  list(id:any){
    return this.http.post<Array<Report>>(`${environment.apiUrl}${this.pathR}/findByTechnical/${id}`,{message:'hellow'})
  }
  findByCC(){
    return this.http.get<Technical>(`${environment.apiUrl}${this.pathT}/findByCC/${this.session.cc}`)
  }
}
