import { SessionService } from './../../services/session.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculus',
  templateUrl: './calculus.component.html',
  styleUrls: ['./calculus.component.scss']
})
export class CalculusComponent implements OnInit {

  constructor(private service: SessionService) { }

  ngOnInit(): void {
  }
  get session() {
    return this.service.session
  }
  expansion() {
    this.service.session.expansion = this.service.session.expansion == false ? true : false
  }
  calculate() {
    this.service.calculator().subscribe(data => {
      this.service.listHours = data
      console.log(data)
    })
  }
  get hours() {
    return this.service.listHours;
  }

}
