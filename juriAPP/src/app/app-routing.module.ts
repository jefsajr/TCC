import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AudienciaListComponent } from './audiencias/audiencia-list/audiencia-list.component';
import { AudienciaFormComponent } from './audiencias/audiencia-form/audiencia-form.component';
import { NotFoundComponent } from './errors/not-found/not-found.component';
import { LoginComponent } from './home/login/login.component';
import { PlacarComponent } from './placar/placar.component';


const routes: Routes = [
  {
    path: 'audiencia/list', 
    component: AudienciaListComponent
  },
  {
    path: 'audiencia/:id/form',
    component: AudienciaFormComponent
  },
  {
    path: 'placar',
    component: PlacarComponent
  },
  {
    path: '', 
    component: LoginComponent
  },
  {
    path: '**',
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
