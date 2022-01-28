import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateTechnicalComponent } from './create-technical.component';

describe('CreateTechnicalComponent', () => {
  let component: CreateTechnicalComponent;
  let fixture: ComponentFixture<CreateTechnicalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateTechnicalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateTechnicalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
