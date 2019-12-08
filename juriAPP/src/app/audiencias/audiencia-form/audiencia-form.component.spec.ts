import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AudienciaFormComponent } from './audiencia-form.component';

describe('AudienciaFormComponent', () => {
  let component: AudienciaFormComponent;
  let fixture: ComponentFixture<AudienciaFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AudienciaFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AudienciaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
