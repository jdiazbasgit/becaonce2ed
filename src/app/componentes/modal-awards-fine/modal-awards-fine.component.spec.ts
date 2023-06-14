import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalAwardsFineComponent } from './modal-awards-fine.component';

describe('ModalAwardsFineComponent', () => {
  let component: ModalAwardsFineComponent;
  let fixture: ComponentFixture<ModalAwardsFineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModalAwardsFineComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalAwardsFineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
