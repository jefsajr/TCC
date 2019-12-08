import { AudienciaService } from '../audiencia/audiencia.service';
import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { Audiencia } from '../../entities/audiencia';

@Injectable({providedIn: 'root'})
export class AudienciaListResolver implements Resolve<Observable<Audiencia[]>> {
    constructor(private service : AudienciaService){}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
        const username = route.params.userName;
        return this.service.listAudiencias(username);
    }
}