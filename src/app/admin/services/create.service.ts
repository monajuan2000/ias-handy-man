import { Technical } from './../../shared/models/TechniciansModel';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CreateService {
  path = '/technical'
  technical:Technical
  state = false

 constructor(public http: HttpClient) {
   this.technical = new Technical();
  }

  create(dto:Technical){
    return this.http.post<Technical>(`${environment.apiUrl}${this.path}/save`, dto)
   }
   list(){
     return this.http.post<Array<Technical>>(`${environment.apiUrl}${this.path}/find-all`,{message:"hello"})
   }
   findById(id:any){
    return this.http.post<Technical>(`${environment.apiUrl}${this.path}`, id)
   }
   update(dto: Technical) {
    return this.http.post<Technical>(`${environment.apiUrl}${this.path}/update`, dto);
  }
  delete(id:any) {
    return this.http.delete<Technical>(`${environment.apiUrl}${this.path}/delete/${id}`);
  }
}
