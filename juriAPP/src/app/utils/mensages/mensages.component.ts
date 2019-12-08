import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-mensages',
  templateUrl: './mensages.component.html',
  styleUrls: ['./mensages.component.css']
})
export class MensagesComponent implements OnInit {

  @Input() text: string;

  constructor() { }

  ngOnInit() {
  }

}
