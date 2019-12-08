import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

import { AudienciaComponent } from './audiencia/audiencia.component';
import { AudienciaListComponent } from './audiencia-list/audiencia-list.component';
import { AudienciaFormComponent } from './audiencia-form/audiencia-form.component';
import { AudienciasComponent } from './audiencia-list/audiencias/audiencias.component';
import { FilterByName } from './audiencia-list/filter-by-name.pipe';
import { LoadButtonComponent } from './audiencia-list/load-button/load-button.component';
import { SearchComponent } from '../search/search.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserAreaModule } from '../utils/user-area/user-area.module';


@NgModule({
    declarations:[
        AudienciaComponent, 
        AudienciaListComponent, 
        AudienciaFormComponent, 
        AudienciasComponent,
        FilterByName,
        LoadButtonComponent,
        SearchComponent
    ],
    exports:[AudienciaComponent],
    imports:[
        HttpClientModule,
        CommonModule,
        FormsModule,
        ReactiveFormsModule,
        UserAreaModule
    ]
})
export class AudienciasModule{}