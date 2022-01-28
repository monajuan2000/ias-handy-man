import { SessionService } from './../../services/session.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-inf-calculus',
  templateUrl: './inf-calculus.component.html',
  styleUrls: ['./inf-calculus.component.scss']
})
export class InfCalculusComponent implements OnInit {

  constructor(private service:SessionService) { }

  ngOnInit(): void {
  }
  get session(){
    return this.service.session;
  }
  expansion(){
   this.service.session.expansion = this.service.session.expansion ==false ? true : false
  }
}
