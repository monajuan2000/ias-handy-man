import { ListComponent } from './../service-report/components/list/list.component';
import { ServiceReportModule } from './../service-report/service-report.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { TechnicalComponent } from './views/technical/technical.component';


import { MatCardModule } from '@angular/material/card';
import {MatInputModule} from '@angular/material/input';
import { FlexLayoutModule } from '@angular/flex-layout';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatTableModule} from '@angular/material/table';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CreateTechnicalComponent } from './components/create-technical/create-technical.component';
import { ListTechnicalComponent } from './components/list-technical/list-technical.component';
@NgModule({
  declarations: [
    AdminComponent,
    TechnicalComponent,
    CreateTechnicalComponent,
    ListTechnicalComponent,

  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    MatCardModule,
    MatInputModule,
    FlexLayoutModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatIconModule,
    MatButtonModule,
    MatTableModule,
    FormsModule,
    HttpClientModule,
  ]
})
export class AdminModule { }
