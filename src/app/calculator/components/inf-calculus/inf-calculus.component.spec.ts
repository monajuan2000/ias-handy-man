import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfCalculusComponent } from './inf-calculus.component';

describe('InfCalculusComponent', () => {
  let component: InfCalculusComponent;
  let fixture: ComponentFixture<InfCalculusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfCalculusComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InfCalculusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
