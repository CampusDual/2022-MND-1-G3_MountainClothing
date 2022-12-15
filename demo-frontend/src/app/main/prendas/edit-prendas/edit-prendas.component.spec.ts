import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPrendasComponent } from './edit-prendas.component';

describe('EditPrendasComponent', () => {
  let component: EditPrendasComponent;
  let fixture: ComponentFixture<EditPrendasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditPrendasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditPrendasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
