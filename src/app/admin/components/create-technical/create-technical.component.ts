import { Technical } from './../../../shared/models/TechniciansModel';
import { CreateService } from './../../services/create.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create-technical',
  templateUrl: './create-technical.component.html',
  styleUrls: ['./create-technical.component.scss']
})
export class CreateTechnicalComponent implements OnInit {


  constructor(private service:CreateService) { 
  }
  ngOnInit(): void {
  }
  get technical(){
    return this.service.technical;
  }
  get state(){
    return this.service.state
  }
  clean():void{
     window.location.reload()
  }
  submit():void{
    this.service.create(this.service.technical).subscribe(data => console.log("save"))
    window.location.reload()
  }
  update(){
    this.service.create(this.service.technical).subscribe(data => console.log("save"))
    window.location.reload()
  }
}
