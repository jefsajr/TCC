import { Component, OnInit, Input, Output } from '@angular/core';
import { PerguntaCoreService } from '../../core/providers/pergunta.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Pergunta } from '../../entities/pergunta';
import { Observable } from 'rxjs';
import { NgForm, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AudienciaResposta } from '../../entities/audienciaResposta';
import { TokenService } from '../../token/token.service';
import { AudienciaCoreService } from '../../core/providers/audiencia.service';
import { delay } from 'rxjs/operators';

@Component({
  selector: 'app-audiencia-form',
  templateUrl: './audiencia-form.component.html',
  styleUrls: ['./audiencia-form.component.css']
})
export class AudienciaFormComponent implements OnInit {
  
  constructor(
    private perguntaCoreService: PerguntaCoreService,
    private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private tokenService: TokenService,
    private audienciaCoreService: AudienciaCoreService
  ) { }

  respostaForm: FormGroup;
  idAudiencia: number;
  idPergunta: number;
  @Input('pergunta') pergunta: Pergunta = new Pergunta();
  
    
  ngOnInit() {
    this.loadPage()
  }

  public sendResposta(){
    const idResposta =  this.respostaForm.get('idResposta').value;
    const audienciaResposta: AudienciaResposta = new AudienciaResposta();
    audienciaResposta.idAudiencia = Number(this.idAudiencia);
    audienciaResposta.idResposta = Number(idResposta);
    audienciaResposta.idJogador = Number(this.tokenService.getToken());

    this.perguntaCoreService.sendResposta(audienciaResposta);
    this.loadPage();
    
  }
  
  loadPage(){
    this.idAudiencia = this.route.snapshot.params.id;
    let perguntaObsevable: Observable<Pergunta> = this.perguntaCoreService.getPergunta(this.idAudiencia);
    perguntaObsevable.subscribe(perguntaResponse => {
      if(perguntaResponse != null){
        this.pergunta = perguntaResponse;
        this.idPergunta = this.pergunta.id;
      }else{
        console.log("sem mais parguntas");
        this.audienciaCoreService.finalizaAudiencia(this.idAudiencia);        
        this.router.navigate(['audiencia/list'])        
      }
    });
    
    this.respostaForm = this.formBuilder.group({
      idResposta:['']
    });
  }

}
