import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TresComponent } from './tres.component';

describe('TresComponent', () => {
  let component: TresComponent;
  let fixture: ComponentFixture<TresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TresComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
