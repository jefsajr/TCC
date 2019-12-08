import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserService } from '../core/providers/user.service';
import { Placar } from '../entities/placar';

@Component({
  selector: 'app-placar',
  templateUrl: './placar.component.html',
  styleUrls: ['./placar.component.css']
})
export class PlacarComponent implements OnInit {

  constructor(
    private userService: UserService
  ) { }

  @Input() placar: Placar[] = [];

  ngOnInit() {
    this.userService.getPlacar().subscribe(placar=>{
      this.placar = placar;
      console.log(placar);
    }); 
  }

}
