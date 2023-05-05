import { TestBed } from '@angular/core/testing';

import { AwardsFinesConfigurationsService } from './awards-fines-configurations.service';

describe('AwardsFinesConfigurationsService', () => {
  let service: AwardsFinesConfigurationsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AwardsFinesConfigurationsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
