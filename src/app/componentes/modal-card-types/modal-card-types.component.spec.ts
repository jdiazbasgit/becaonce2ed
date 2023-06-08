import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalCardTypesComponent } from './modal-card-types.component';

describe('ModalCardTypesComponent', () => {
  let component: ModalCardTypesComponent;
  let fixture: ComponentFixture<ModalCardTypesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModalCardTypesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalCardTypesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
