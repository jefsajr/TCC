import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
 
import { AudienciasModule } from './audiencias/audiencias.module';
import { ErrorsModule } from './errors/errors.module';
import { HomeModule } from './home/home.module';
import { MensagesModule } from './utils/mensages/mensages.module';
import { PlacarModule } from './placar/placar.module';
import { UserAreaModule } from './utils/user-area/user-area.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AudienciasModule,
    ErrorsModule,
    HomeModule,
    MensagesModule,
    PlacarModule,
    UserAreaModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
