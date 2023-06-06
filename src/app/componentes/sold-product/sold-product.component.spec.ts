import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SoldProductComponent } from './sold-product.component';

describe('SoldProductComponent', () => {
  let component: SoldProductComponent;
  let fixture: ComponentFixture<SoldProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SoldProductComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SoldProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
