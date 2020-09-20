import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaSitesComponent } from './lista-sites.component';

describe('ListaSitesComponent', () => {
  let component: ListaSitesComponent;
  let fixture: ComponentFixture<ListaSitesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaSitesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaSitesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
