import { TestBed } from '@angular/core/testing';

import { TypeAccountService } from './type-account.service';

describe('TypeAccountService', () => {
  let service: TypeAccountService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TypeAccountService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
