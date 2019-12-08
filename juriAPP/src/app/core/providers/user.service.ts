import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Jogador } from '../../entities/jogador';
import { Placar } from '../../entities/placar';

const API = "http://localhost:8080";

@Injectable({providedIn: 'root'})
export class UserService{
    
    constructor(private http: HttpClient){

    }

    getJogador(id){
        if(id != null){
            return this.http.get<Jogador>(API + "/jogador/" + id);
        }
        return null;
    }

    getPlacar(){
        return this.http.get<Placar[]>(API + "/jogador/placar")
    }
}