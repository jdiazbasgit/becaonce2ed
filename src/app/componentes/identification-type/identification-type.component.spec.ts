import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IdentificationTypeComponent } from './identification-type.component';

describe('IdentificationTypeComponent', () => {
  let component: IdentificationTypeComponent;
  let fixture: ComponentFixture<IdentificationTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IdentificationTypeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IdentificationTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
