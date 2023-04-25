import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DosComponent } from './dos.component';

describe('DosComponent', () => {
  let component: DosComponent;
  let fixture: ComponentFixture<DosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
