import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPaginaprendasComponent } from './edit-paginaprendas.component';

describe('EditPaginaprendasComponent', () => {
  let component: EditPaginaprendasComponent;
  let fixture: ComponentFixture<EditPaginaprendasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditPaginaprendasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditPaginaprendasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
