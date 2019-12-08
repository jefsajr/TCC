import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs/operators';
import { TokenService } from '../token/token.service';
import { Jogador } from '../entities/jogador';

const API = "http://localhost:8080"

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  
  constructor(
    private http: HttpClient,
    private tokenService: TokenService,
  ) { }

  authenticate(usuario: string, senha: string ){
    return this.http.post<Jogador>(API + '/jogador/login',
          {usuario, senha},
          { observe: 'response'}
        ).pipe(tap(jogador => {
          const auth = jogador.body;
          this.tokenService.setUsername(auth.nome);
          this.tokenService.setToken(auth.id);
          this.tokenService.setPontos(auth.totalPontos);
        }))
  }

  logout(){
    this.tokenService.removeToken();
  }
}
