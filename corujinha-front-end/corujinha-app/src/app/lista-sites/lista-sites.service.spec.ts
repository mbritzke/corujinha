import { TestBed } from '@angular/core/testing';

import { ListaSitesService } from './lista-sites.service';

describe('ListaSitesService', () => {
  let service: ListaSitesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListaSitesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
