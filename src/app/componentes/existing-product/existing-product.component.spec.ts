import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExistingProductComponent } from './existing-product.component';

describe('ExistingProductComponent', () => {
  let component: ExistingProductComponent;
  let fixture: ComponentFixture<ExistingProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExistingProductComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExistingProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
