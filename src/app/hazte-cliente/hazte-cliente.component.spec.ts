import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HazteClienteComponent } from './hazte-cliente.component';

describe('HazteClienteComponent', () => {
  let component: HazteClienteComponent;
  let fixture: ComponentFixture<HazteClienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HazteClienteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HazteClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
