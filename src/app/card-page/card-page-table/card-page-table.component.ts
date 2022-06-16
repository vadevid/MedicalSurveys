import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-card-page-table',
  templateUrl: './card-page-table.component.html',
  styleUrls: ['./card-page-table.component.css']
})
export class CardPageTableComponent implements OnInit {
  @Input()
  id: number;

  constructor() { }

  ngOnInit(): void {
  }

}
