import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FronterasComponent } from './fronteras.component';

describe('FronterasComponent', () => {
  let component: FronterasComponent;
  let fixture: ComponentFixture<FronterasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FronterasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FronterasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
