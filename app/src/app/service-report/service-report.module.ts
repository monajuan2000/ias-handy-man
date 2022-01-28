import { FormComponent } from './components/form/form.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ServiceReportRoutingModule } from './service-report-routing.module';
import { ServiceReportComponent } from './service-report.component';
import { MatCardModule } from '@angular/material/card';
import {MatInputModule} from '@angular/material/input';
import { FlexLayoutModule } from '@angular/flex-layout';
import { TechniciansComponent } from './views/technicians/technicians.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import { ListComponent } from './components/list/list.component';
import {MatButtonModule} from '@angular/material/button';
import {MatTableModule} from '@angular/material/table';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    ServiceReportComponent,
    TechniciansComponent,
    FormComponent,
    ListComponent,
  ],
  imports: [
    CommonModule,
    ServiceReportRoutingModule,
    MatCardModule,
    MatInputModule,
    FlexLayoutModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatIconModule,
    MatButtonModule,
    MatTableModule,
    FormsModule,
    HttpClientModule
  ]
})
export class ServiceReportModule { }
