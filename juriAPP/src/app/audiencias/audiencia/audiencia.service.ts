import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Audiencia } from '../../entities/audiencia';

const API = "http://localhost:8080"

@Injectable({providedIn : "root"})
export class AudienciaService{

    constructor(private http:HttpClient){}

    listAudiencias(nameSpace : string){
        return this.http.get<Audiencia[]>(API + nameSpace);
    }

    listAudienciasPaginated(nameSpace : string, page: number){
        const params = new HttpParams().append('page', page.toString())
        return this.http.get<Audiencia[]>(API + nameSpace, {params});
    }
}