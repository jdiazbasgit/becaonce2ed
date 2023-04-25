import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrimerComponenteComponent } from './primer-componente.component';

describe('PrimerComponenteComponent', () => {
  let component: PrimerComponenteComponent;
  let fixture: ComponentFixture<PrimerComponenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrimerComponenteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrimerComponenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
