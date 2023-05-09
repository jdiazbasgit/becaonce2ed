import { TestBed } from '@angular/core/testing';

import { AwardsFinesService } from './awards-fines.service';

describe('AwardsFinesService', () => {
  let service: AwardsFinesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AwardsFinesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
