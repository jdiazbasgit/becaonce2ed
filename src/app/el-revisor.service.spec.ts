import { TestBed } from '@angular/core/testing';

import { ElRevisorService } from './el-revisor.service';

describe('ElRevisorService', () => {
  let service: ElRevisorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ElRevisorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
