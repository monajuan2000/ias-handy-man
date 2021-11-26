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
     return this.http.get<Array<Technical>>(`${environment.apiUrl}${this.path}/find-all`)
   }
   update(dto: Technical) {
    return this.http.put<Technical>(`${environment.apiUrl}${this.path}/update`, dto);
  }
  delete(id:any) {
    return this.http.delete<Technical>(`${environment.apiUrl}${this.path}/delete/${id}`);
  }
}
