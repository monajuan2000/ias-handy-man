import { Report } from './../../shared/models/ReportModel';
import { Technical } from './../../shared/models/TechniciansModel';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ReportService{
   path = '/reports'
   technical:Technical
   report:Report

  constructor(public http: HttpClient) {
    this.technical = new Technical();
    this.report = new Report();
   }
   create(dto:any){
    return this.http.post<Report>(`${environment.apiUrl}${this.path}/save`, dto)
   }
   list(){
     return this.http.get<Array<Technical>>(`${environment.apiUrl}/technical/find-all`)
   }
   listReports(){
    return this.http.get<Array<Report>>(`${environment.apiUrl}${this.path}/find-all`)
  }
   findById(dto:any){
    return this.http.post<Report>(`${environment.apiUrl}${this.path}`, dto)
   }
   update(dto: any) {
    return this.http.put<Report>(`${environment.apiUrl}${this.path}`, dto);
  }
}
