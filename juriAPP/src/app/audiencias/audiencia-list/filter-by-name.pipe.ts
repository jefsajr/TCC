import { Pipe, PipeTransform } from "@angular/core";
import { Audiencia } from '../../entities/audiencia';

@Pipe({name: "filterByName"})
export class FilterByName implements PipeTransform{
    transform(audiencias: Audiencia[],nameQuery:string) {
        if(nameQuery){
            nameQuery.trim().toLocaleLowerCase();
            return audiencias.filter(audiencia => audiencia.nomeJuiz.toLocaleLowerCase().includes(nameQuery));
        }else{
            return audiencias;
        }
    }

}