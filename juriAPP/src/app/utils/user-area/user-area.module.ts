import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserAreaComponent } from './user-area.component';

@NgModule({
  declarations: [
    UserAreaComponent
  ],
  exports:[
    UserAreaComponent
  ],
  imports: [
    CommonModule
  ]
})
export class UserAreaModule { }
