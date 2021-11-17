import { SessionService } from './../../services/session.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

   route = '../reports'

  constructor(private service: SessionService) { 

  }

  ngOnInit(): void {
  }
  get session(){
    return this.service.session
  }

}
