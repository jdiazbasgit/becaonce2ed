import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeeComponent } from './fee.component';

describe('FeeComponent', () => {
  let component: FeeComponent;
  let fixture: ComponentFixture<FeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FeeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
