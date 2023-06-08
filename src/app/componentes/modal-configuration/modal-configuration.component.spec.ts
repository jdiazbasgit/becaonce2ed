import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalConfigurationComponent } from './modal-configuration.component';

describe('ModalConfigurationComponent', () => {
  let component: ModalConfigurationComponent;
  let fixture: ComponentFixture<ModalConfigurationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModalConfigurationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalConfigurationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
