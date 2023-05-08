import { TestBed } from '@angular/core/testing';

import { ExistingproductService } from './existingproduct.service';

describe('ExistingproductService', () => {
  let service: ExistingproductService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExistingproductService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
