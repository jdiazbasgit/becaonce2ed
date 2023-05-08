import { TestBed } from '@angular/core/testing';

import { AwardFineService } from './award-fine.service';

describe('AwardFineService', () => {
  let service: AwardFineService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AwardFineService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
