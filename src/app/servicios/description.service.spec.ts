import { TestBed } from '@angular/core/testing';

import { DescriptionService } from './description.service';

describe('DescriptionService', () => {
  let service: DescriptionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DescriptionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
