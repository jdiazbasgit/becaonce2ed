import { TestBed } from '@angular/core/testing';

import { AwardsFinesTypesService } from './awards-fines-types.service';

describe('AwardsFinesTypesService', () => {
  let service: AwardsFinesTypesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AwardsFinesTypesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
