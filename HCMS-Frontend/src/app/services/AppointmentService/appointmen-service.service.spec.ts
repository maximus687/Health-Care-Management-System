import { TestBed } from '@angular/core/testing';

import { AppointmenServiceService } from './appointmen-service.service';

describe('AppointmenServiceService', () => {
  let service: AppointmenServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AppointmenServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
