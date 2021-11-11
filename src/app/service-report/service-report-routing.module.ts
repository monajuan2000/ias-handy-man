import { TechniciansComponent } from './views/technicians/technicians.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ServiceReportComponent } from './service-report.component';

const routes: Routes = [{ path: 'report', component: TechniciansComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ServiceReportRoutingModule { }
