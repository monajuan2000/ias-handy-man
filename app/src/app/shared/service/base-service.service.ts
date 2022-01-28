import { environment } from './../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BaseServiceService<T>{
  protected path: string;

  constructor(protected http: HttpClient) {
    this.path = ''
   }
   create(dto:any){
    return this.http.post<T>(`${environment.apiUrl}${this.path}`, dto)
   }
   list(dto:any){
     return this.http.post<any>(`${environment.apiUrl}${this.path}`, dto)
   }
   findById(dto:any){
    return this.http.post<any>(`${environment.apiUrl}${this.path}`, dto)
   }
   update(dto: any) {
    return this.http.put<any>(`${environment.apiUrl}${this.path}`, dto);
  }
}
