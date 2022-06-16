import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-card-page-graph',
  templateUrl: './card-page-graph.component.html',
  styleUrls: ['./card-page-graph.component.css']
})
export class CardPageGraphComponent implements OnInit {
  @Input()
  id: number;

  constructor() { }

  ngOnInit(): void {
  }

}
