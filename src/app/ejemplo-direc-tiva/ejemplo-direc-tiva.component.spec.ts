import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EjemploDirecTIVAComponent } from './ejemplo-direc-tiva.component';

describe('EjemploDirecTIVAComponent', () => {
  let component: EjemploDirecTIVAComponent;
  let fixture: ComponentFixture<EjemploDirecTIVAComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EjemploDirecTIVAComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EjemploDirecTIVAComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
