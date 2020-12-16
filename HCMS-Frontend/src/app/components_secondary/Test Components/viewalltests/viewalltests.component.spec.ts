import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewalltestsComponent } from './viewalltests.component';

describe('ViewalltestsComponent', () => {
  let component: ViewalltestsComponent;
  let fixture: ComponentFixture<ViewalltestsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewalltestsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewalltestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
