import { SessionService } from './../../services/session.service';
import { Component, OnInit } from '@angular/core';
import { DataSource } from '@angular/cdk/collections';

@Component({
  selector: 'app-reports-by-technical',
  templateUrl: './reports-by-technical.component.html',
  styleUrls: ['./reports-by-technical.component.scss']
})
export class ReportsByTechnicalComponent implements OnInit {
  displayedColumns: string[] = ['order', 'date', 'hourS','hourF'];

  dataSource: any;

  constructor(private service: SessionService) {
    this.dataSource = this.service.listT
  }

  ngOnInit(): void {
    this.dataSource = this.service.listT
  }
  get session() {
    return this.service.session;
  }
}
