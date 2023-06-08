import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalRolComponent } from './modal-rol.component';

describe('ModalRolComponent', () => {
  let component: ModalRolComponent;
  let fixture: ComponentFixture<ModalRolComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModalRolComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalRolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
