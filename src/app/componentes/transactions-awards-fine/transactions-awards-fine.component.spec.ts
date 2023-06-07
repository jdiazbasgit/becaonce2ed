import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransactionsAwardsFineComponent } from './transactions-awards-fine.component';

describe('TransactionsAwardsFineComponent', () => {
  let component: TransactionsAwardsFineComponent;
  let fixture: ComponentFixture<TransactionsAwardsFineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransactionsAwardsFineComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransactionsAwardsFineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
