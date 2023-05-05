import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PipeFronteraComponent } from './pipe-frontera.component';

describe('PipeFronteraComponent', () => {
  let component: PipeFronteraComponent;
  let fixture: ComponentFixture<PipeFronteraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PipeFronteraComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PipeFronteraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
