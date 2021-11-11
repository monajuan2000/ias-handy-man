
import { ReportService } from './../../services/report.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {

  constructor(private service: ReportService) { }

  ngOnInit(): void {
  }

  get technical(){
      return this.service.technical;
  }
  get report(){
    return this.service.report
}
}
