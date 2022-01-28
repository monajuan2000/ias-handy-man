import { Technical } from './../../../shared/models/TechniciansModel';
import { CreateService } from './../../services/create.service';
import { Component, OnInit } from '@angular/core';
import { ValidationService } from 'src/app/shared/service/validation.service';

@Component({
  selector: 'app-create-technical',
  templateUrl: './create-technical.component.html',
  styleUrls: ['./create-technical.component.scss']
})
export class CreateTechnicalComponent implements OnInit {


  constructor(private service: CreateService, private notification:ValidationService) {
  }
  ngOnInit(): void {
  }
  get technical() {
    return this.service.technical;
  }
  get state() {
    return this.service.state
  }
  clean(): void {
    this.service.technical = new Technical();
    this.service.state = false
  }
  submit(): void {
    let msn = this.validate();
    if (msn == '') {
      this.service.create(this.service.technical).subscribe()
      this.notification.notification(
        'Success',
         msn,
        'NOTIFICATION_SUCCESS.jpg'
      )
      this.service.technical = new Technical();
      setTimeout("window.location.reload()",2000)
    }else{
         this.notification.notification(
           'Error',
            msn,
           'NOTIFICATION_ERROR.png'
         )
    }
  }
  update() {
    let msn = this.validate();
    if (msn == '') {
      this.service.update(this.service.technical).subscribe()
      this.notification.notification(
        'Success',
         msn,
        'NOTIFICATION_SUCCESS.jpg'
      )
      console.log(this.service.technical)
      this.service.technical = new Technical();
    }else{
         this.notification.notification(
           'Error',
            msn,
           'NOTIFICATION_ERROR.png'
         )
    }
      
  }
  validate(): string {
    let msn = '';
    msn += this.service.technical.name == '' ? 'Debe especificar el nombre,' : '';
    msn += this.service.technical.cc == '' ? ' Debe especificar la cédula' : '';
    msn += this.service.technical.cc == null ? ' Debe especificar la cédula' : '';
    return msn;
  }
}
