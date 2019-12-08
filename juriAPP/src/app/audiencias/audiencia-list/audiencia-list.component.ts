import { Component, OnInit, Input, OnChanges, SimpleChanges, OnDestroy } from '@angular/core';
import { AudienciaService } from '../audiencia/audiencia.service';
import { TokenService } from '../../token/token.service';
import { Audiencia } from '../../entities/audiencia';
import { AudienciaCoreService } from '../../core/providers/audiencia.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'tc-audiencia',
  templateUrl: './audiencia-list.component.html',
  styleUrls: ['./audiencia-list.component.css']
})
export class AudienciaListComponent implements OnInit, OnChanges{

  @Input() audiencias: Audiencia[] = [];
  hasMore: boolean = true;
  currentPage: number = 1;
    
  constructor(
    private audienciaService: AudienciaService,
    private audienciaCoreService: AudienciaCoreService,
    private router: Router
  ){}

  ngOnChanges(changes:SimpleChanges):void{
    this.listAudiencias(0);
  }
  
  ngOnInit(): void {
    this.listAudiencias(0);
  }

  listAudiencias(page: number){
    if(page == null){
      this.audienciaService.listAudiencias("/audiencia/list").subscribe(audiencias =>{
        this.audiencias = this.audiencias.concat(audiencias);          
      })
    }else{
      this.audienciaService.listAudienciasPaginated("/audiencia/list", page).subscribe(audiencias => {
        this.audiencias = this.audiencias.concat(audiencias);
      })
    }
  }

  load(){
    this.listAudiencias(this.currentPage);
    this.currentPage = ++this.currentPage;
  }

  createAudiencia(){
    console.log("criando uma nova audiencia!");
    let audienciaObservale: Observable<Audiencia> = this.audienciaCoreService.createAudiencia();
    audienciaObservale.subscribe(audienciaResponse =>{
      this.router.navigate(['audiencia',audienciaResponse.id,'form'])
    })
    
  }

  listPlacar(){
    this.router.navigate(['placar']);
  }
}
