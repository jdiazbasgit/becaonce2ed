import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PruebasPipesComponent } from './pruebas-pipes.component';

describe('PruebasPipesComponent', () => {
  let component: PruebasPipesComponent;
  let fixture: ComponentFixture<PruebasPipesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PruebasPipesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PruebasPipesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
