import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaprendasComponent } from './paginaprendas.component';

describe('PaginaprendasComponent', () => {
  let component: PaginaprendasComponent;
  let fixture: ComponentFixture<PaginaprendasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaginaprendasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PaginaprendasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
