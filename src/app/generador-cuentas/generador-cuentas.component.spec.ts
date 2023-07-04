import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GeneradorCuentasComponent } from './generador-cuentas.component';

describe('GeneradorCuentasComponent', () => {
  let component: GeneradorCuentasComponent;
  let fixture: ComponentFixture<GeneradorCuentasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GeneradorCuentasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GeneradorCuentasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
