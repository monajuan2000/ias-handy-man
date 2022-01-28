import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginTechiciansComponent } from './login-techicians.component';

describe('LoginTechiciansComponent', () => {
  let component: LoginTechiciansComponent;
  let fixture: ComponentFixture<LoginTechiciansComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginTechiciansComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginTechiciansComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
