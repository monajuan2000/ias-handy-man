import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalculusComponent } from './calculus.component';

describe('CalculusComponent', () => {
  let component: CalculusComponent;
  let fixture: ComponentFixture<CalculusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CalculusComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CalculusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
