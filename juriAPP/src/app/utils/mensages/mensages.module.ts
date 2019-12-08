import { NgModule } from '@angular/core';
import { MensagesComponent } from './mensages.component';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations:[MensagesComponent],
  exports:[MensagesComponent],
  imports:[
    CommonModule,
    ReactiveFormsModule
  ]
})
export class MensagesModule{}
