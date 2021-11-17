import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportsByTechnicalComponent } from './reports-by-technical.component';

describe('ReportsByTechnicalComponent', () => {
  let component: ReportsByTechnicalComponent;
  let fixture: ComponentFixture<ReportsByTechnicalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReportsByTechnicalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportsByTechnicalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
