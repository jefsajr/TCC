import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Audiencia } from '../../entities/audiencia';
import { AudienciaResposta } from '../../entities/audienciaResposta';

const API = "http://localhost:8080/audiencia";

@Injectable({providedIn: 'root'})
export class AudienciaCoreService{
    
    constructor(private http: HttpClient){}
    
    createAudiencia(){
        return this.http.get<Audiencia>(API + "/create")
    }

    finalizaAudiencia(idAudiencia){
        return this.http.get(API + "/finalizar/" + idAudiencia,{
            headers: new HttpHeaders({
                'Content-Type':  'application/json',
                'Access-Control-Allow-Origin': '*'
            }),
            observe: 'response'}).subscribe(resp =>{
            console.log(resp.body);
            console.log(resp.status);
        })
    }

}