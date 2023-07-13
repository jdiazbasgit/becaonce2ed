import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AwardsFinesTypeComponent } from './awards-fines-type.component';

describe('AwardsFinesTypeComponent', () => {
  let component: AwardsFinesTypeComponent;
  let fixture: ComponentFixture<AwardsFinesTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AwardsFinesTypeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AwardsFinesTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
