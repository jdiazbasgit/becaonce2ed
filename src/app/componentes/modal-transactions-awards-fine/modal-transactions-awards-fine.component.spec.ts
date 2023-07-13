import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalTransactionsAwardsFineComponent } from './modal-transactions-awards-fine.component';

describe('ModalTransactionsAwardsFineComponent', () => {
  let component: ModalTransactionsAwardsFineComponent;
  let fixture: ComponentFixture<ModalTransactionsAwardsFineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModalTransactionsAwardsFineComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalTransactionsAwardsFineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
