import { CreateService } from './../../services/create.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create-technical',
  templateUrl: './create-technical.component.html',
  styleUrls: ['./create-technical.component.scss']
})
export class CreateTechnicalComponent implements OnInit {

  constructor(private service:CreateService) { }

  ngOnInit(): void {
  }

  

}
