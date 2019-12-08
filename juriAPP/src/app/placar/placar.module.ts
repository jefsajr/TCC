import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PlacarComponent } from './placar.component';
import { UserAreaModule } from '../utils/user-area/user-area.module';

@NgModule({
  declarations: [
    PlacarComponent
  ],
  imports: [
    HttpClientModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    UserAreaModule
  ]
})
export class PlacarModule { }
