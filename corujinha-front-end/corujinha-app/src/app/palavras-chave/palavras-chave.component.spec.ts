import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PalavrasChaveComponent } from './palavras-chave.component';

describe('PalavrasChaveComponent', () => {
  let component: PalavrasChaveComponent;
  let fixture: ComponentFixture<PalavrasChaveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PalavrasChaveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PalavrasChaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
