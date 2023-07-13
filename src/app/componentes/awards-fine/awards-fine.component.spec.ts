import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AwardsFineComponent } from './awards-fine.component';

describe('AwardsFineComponent', () => {
  let component: AwardsFineComponent;
  let fixture: ComponentFixture<AwardsFineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AwardsFineComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AwardsFineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
