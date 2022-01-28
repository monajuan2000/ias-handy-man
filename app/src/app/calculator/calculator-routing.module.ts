import { ReportsComponent } from './views/reports/reports.component';
import { LoginTechiciansComponent } from './views/login-techicians/login-techicians.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [{ path: 'login-technicians', component: LoginTechiciansComponent },
{ path: 'reports', component: ReportsComponent },];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CalculatorRoutingModule { }
