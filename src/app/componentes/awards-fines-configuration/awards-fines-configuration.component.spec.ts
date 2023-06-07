import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AwardsFinesConfigurationComponent } from './awards-fines-configuration.component';

describe('AwardsFinesConfigurationComponent', () => {
  let component: AwardsFinesConfigurationComponent;
  let fixture: ComponentFixture<AwardsFinesConfigurationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AwardsFinesConfigurationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AwardsFinesConfigurationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
