import { TestBed } from '@angular/core/testing';

import { PalavraChaveService } from './palavra-chave.service';

describe('PalavraChaveService', () => {
  let service: PalavraChaveService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PalavraChaveService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
