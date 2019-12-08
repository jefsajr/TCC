import { Component, OnInit, Input } from '@angular/core';
import { TokenService } from '../../token/token.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-area',
  templateUrl: './user-area.component.html',
  styleUrls: ['./user-area.component.css']
})
export class UserAreaComponent implements OnInit {

  @Input() username: string;
  @Input() pontos: string;

  constructor(
    private tokenService: TokenService,
    private router: Router
  ) { }

  ngOnInit() {
    this.username = this.tokenService.getUsername();
    this.pontos = this.tokenService.getPontos();
  }

  logout(){
    this.tokenService.removeToken();
    this.router.navigate([""]);
  }

}
