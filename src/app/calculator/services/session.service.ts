import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  session = {cc:'',name:''}

  constructor(private httpClient:HttpClient) { }
}
