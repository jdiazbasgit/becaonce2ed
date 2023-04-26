import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GeograficosComponent } from './geograficos.component';

describe('GeograficosComponent', () => {
  let component: GeograficosComponent;
  let fixture: ComponentFixture<GeograficosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GeograficosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GeograficosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
