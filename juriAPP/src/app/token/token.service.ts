import { Injectable } from '@angular/core'

const KEY = 'userId';
const USERNAME = 'username';
const PONTOS = 'qtdPontos';

@Injectable({ providedIn: 'root'})
export class TokenService{

    hasToken(){
        return !!this.getToken();
    }

    hasUsername(){
        return !!this.getUsername();
    }

    setToken(token){
        window.localStorage.setItem(KEY, token);
    }

    setUsername(username){
        window.localStorage.setItem(USERNAME, username);
    }

    setPontos(qtdPontos){
        window.localStorage.setItem(PONTOS, qtdPontos);
    }
    
    removeToken(){
        window.localStorage.removeItem(KEY);
        window.localStorage.removeItem(USERNAME);
        window.localStorage.removeItem(PONTOS);
    }

    getToken(){
        return window.localStorage.getItem(KEY);
    }

    getUsername(){
        return window.localStorage.getItem(USERNAME);
    }

    getPontos(){
        return window.localStorage.getItem(PONTOS);
    }

}