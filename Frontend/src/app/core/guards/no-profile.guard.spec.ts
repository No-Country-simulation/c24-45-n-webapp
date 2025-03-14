import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { noProfileGuard } from './no-profile.guard';

describe('noProfileGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => noProfileGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
