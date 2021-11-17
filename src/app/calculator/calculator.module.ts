import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CalculatorRoutingModule } from './calculator-routing.module';
import { CalculatorComponent } from './calculator.component';
import { LoginTechiciansComponent } from './views/login-techicians/login-techicians.component';
import {MatCardModule} from '@angular/material/card';
import { FlexLayoutModule } from '@angular/flex-layout';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {MatInputModule} from '@angular/material/input';
import { LoginComponent } from './components/login/login.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ReportsByTechnicalComponent } from './components/reports-by-technical/reports-by-technical.component';
import { ReportsComponent } from './views/reports/reports.component';
@NgModule({
  declarations: [
    CalculatorComponent,
    LoginTechiciansComponent,
    LoginComponent,
    ReportsByTechnicalComponent,
    ReportsComponent
  ],
  imports: [
    CommonModule,
    CalculatorRoutingModule,
    MatCardModule,
    FlexLayoutModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule,
    FormsModule,
    HttpClientModule
  ]
})
export class CalculatorModule { }
