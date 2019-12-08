import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AudienciaListComponent } from './audiencia-list.component';

describe('AudienciaListComponent', () => {
  let component: AudienciaListComponent;
  let fixture: ComponentFixture<AudienciaListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AudienciaListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AudienciaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
