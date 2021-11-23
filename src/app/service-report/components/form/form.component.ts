import { ValidationService } from './../../../shared/service/validation.service';

import { ReportService } from './../../services/report.service';
import { Component, OnInit } from '@angular/core';
import { Technical } from 'src/app/shared/models/TechniciansModel';
import { Report } from 'src/app/shared/models/ReportModel';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {

  constructor(private service: ReportService, private notification:ValidationService) { }

  ngOnInit(): void {
  }

  get technical() {
    return this.service.technical;
  }
  get report() {
    return this.service.report
  }
  submit(): void {
    let msn = this.validate();
    if (msn == ''){
      this.service.create(this.service.report).subscribe()
      this.notification.notification(
        'Sussess',
         msn,
        'NOTIFICATION_SUCCESS.jpg'
        )
        this.service.technical = new Technical()
        this.service.report = new Report()
    }else{
       this.notification.notification(
       'Error',
        msn,
       'NOTIFICATION_ERROR.png'
       )
    }
  }
  clean():void{
    this.service.technical = new Technical()
    this.service.report = new Report()
  }
  validate():string{
    let msn = '';
    msn += this.service.technical.name == '' ? 'Debe especificar el nombre de técnico,': '',
    msn += this.service.technical.name == '' ? ' Debe especificar la cédula del técnico,' : '',
    msn += this.service.report.date == '' ? ' Debe especificar la fecha, ' : '',
    msn += this.service.report.order == '' ? ' Debe especificar el número de la orden,' : '',
    msn += this.service.report.order == '' ? ' Debe especificar la hora de inicio,' : '',
    msn += this.service.report.order == '' ? ' Debe especificar la hora de cierre' : ''
    
    return msn
  }
}
