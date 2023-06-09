import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalDocumentTypesComponent } from './modal-document-types.component';

describe('ModalDocumentTypesComponent', () => {
  let component: ModalDocumentTypesComponent;
  let fixture: ComponentFixture<ModalDocumentTypesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModalDocumentTypesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalDocumentTypesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
