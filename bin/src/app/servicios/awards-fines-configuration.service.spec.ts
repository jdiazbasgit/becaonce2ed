import { TestBed } from '@angular/core/testing';

import { AwardsFinesConfigurationService } from './awards-fines-configuration.service';

describe('AwardsFinesConfigurationService', () => {
  let service: AwardsFinesConfigurationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AwardsFinesConfigurationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
