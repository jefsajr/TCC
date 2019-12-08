import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Pergunta } from '../../entities/pergunta';
import { AudienciaResposta } from '../../entities/audienciaResposta';

const API = "http://localhost:8080/pergunta";
@Injectable({providedIn: 'root'})
export class PerguntaCoreService{
    
    constructor(private http: HttpClient){}
    httpOptions = {
        headers: new HttpHeaders({
            'Content-Type':'application/json',
            'conection':'keep-alive'
        })
    };

    getPergunta(idAudiencia){
        return this.http.get<Pergunta>(API + "/random/" + idAudiencia);
    }
    
    public sendResposta(resposta){
        console.log(resposta);
        return this.http.post(API + "/resposta", resposta, {
            headers: new HttpHeaders({
                'Content-Type':  'application/json',
                'Access-Control-Allow-Origin': '*'
            }),
            observe: 'response'
        }).subscribe(response=>{
            console.log(response.status);
            console.log(response.status);
        });
    }
    
}