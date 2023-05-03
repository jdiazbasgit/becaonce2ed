import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NombreFronteraComponent } from './nombre-frontera.component';

describe('NombreFronteraComponent', () => {
  let component: NombreFronteraComponent;
  let fixture: ComponentFixture<NombreFronteraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NombreFronteraComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NombreFronteraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
