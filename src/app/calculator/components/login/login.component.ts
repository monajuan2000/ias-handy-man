import { ReportsComponent } from './../../views/reports/reports.component';
import { ValidationService } from './../../../shared/service/validation.service';
import { SessionService } from './../../services/session.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  route = '../login-technicians'
  constructor(private service: SessionService, private notification: ValidationService, public router: Router) {

  }

  ngOnInit(): void {
  }
  get session() {
    return this.service.session
  }
  validate(): string {
    let msn = '';
    msn += this.service.session.cc == '' ? 'Debe ingresar cédula,' : '',
      msn += this.service.session.semana == '' ? ' Debe ingresar la semana del año' : ''
    return msn;
  }
  loggear(): void {
    let msn = this.validate()
    if (msn != '') {
      this.notification.notification(
        'Error',
        msn,
        'NOTIFICATION_ERROR.png'
      )

    } else {
      this.service.findByCC().subscribe(data => {
        this.service.session.id = data.id
        this.service.session.name = data.name
        if (this.service.session.cc == data.cc) {
          this.service.session.state = false
        }
        this.service.listT = this.service.list(this.session.id).subscribe(data => {
          this.service.listT = data
          console.log(this.service.listT)
        })
        this.notification.notification(
          'success',
          'login nuevamente',
          'NOTIFICATION_SUCCESS.jpg'
        )
      }, error => {
        this.notification.notification(
          'Error',
          'El registro de esta cédula no existe',
          'NOTIFICATION_ERROR.png'
        )
      })
    }
  }
  get state() {
    return this.service.session.state
  }
  cont() {
    this.service.session.cc = ''
    this.service.session.state = true
    this.router.navigate(['/calculator/reports'])
  }
}