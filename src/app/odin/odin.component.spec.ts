import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OdinComponent } from './odin.component';

describe('OdinComponent', () => {
  let component: OdinComponent;
  let fixture: ComponentFixture<OdinComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OdinComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OdinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
