import { TestBed } from '@angular/core/testing';

import { TransactionAwardFineService } from './transaction-award-fine.service';

describe('TransactionAwardFineService', () => {
  let service: TransactionAwardFineService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TransactionAwardFineService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
