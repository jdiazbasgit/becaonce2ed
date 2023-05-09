import { TestBed } from '@angular/core/testing';

import { AwardsFinesTypeService } from './awards-fines-type.service';

describe('AwardsFinesTypeService', () => {
  let service: AwardsFinesTypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AwardsFinesTypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
