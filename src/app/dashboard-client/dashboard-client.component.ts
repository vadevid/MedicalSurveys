import {Component, Inject, Input, OnInit} from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import {PageEvent} from "@angular/material/paginator";
import {CardTile} from "../model/card-tile";
import {Router} from "@angular/router";

@Component({
  selector: 'app-dashboard-client',
  templateUrl: './dashboard-client.component.html',
  styleUrls: ['./dashboard-client.component.css']
})
export class DashboardClientComponent implements OnInit{

  cards: CardTile[] = [
    { id: 1, name: 'Давление', doctor: "Долбаёбус Долбаёб Долбаёбович", type: "Value", cols: 1, rows: 1 },
    { id: 2, name: 'Пульс', doctor: "Долбаёбус Долбаёб Долбаёбович", type: "TextField", cols: 1, rows: 1 },
    { id: 3, name: 'Кислород в крови', doctor: "Долбаёбус Долбаёб Долбаёбович", type: "TextField", cols: 1, rows: 1 },
    { id: 4, name: 'Общее самочувствие', doctor: "Долбаёбус Долбаёб Долбаёбович", type: "TextField", cols: 1, rows: 1 },
    { id: 5, name: 'Состояние кожи на пальцах', doctor: "Долбаёбус Долбаёб Долбаёбович", type: "TextField", cols: 1, rows: 1 },
    { id: 6, name: 'Частота дыхательных движений', doctor: "Долбаёбус Долбаёб Долбаёбович", type: "TextField", cols: 1, rows: 1 },
    { id: 7, name: 'Соси', doctor: "Долбаёбус Долбаёб Долбаёбович", type: "TextField", cols: 1, rows: 1 },
    { id: 8, name: 'Card 8', doctor: "Долбаёбус Долбаёб Долбаёбович", type: "TextField", cols: 1, rows: 1 },
    { id: 9, name: 'Card 9', doctor: "Долбаёбус Долбаёб Долбаёбович", type: "TextField", cols: 1, rows: 1 },
    { id: 10, name: 'Card 10', doctor: "Долбаёбус Долбаёб Долбаёбович", type: "TextField", cols: 1, rows: 1 },
  ];
  @Input()
  userid: number;
  pagedList: CardTile[] = [];
  cardLength = this.cards.length;
  pageSize = 6;
  router: Router;

  ngOnInit() {
    this.pagedList = this.cards.slice(0, 6)
  }

  onPageChange(event: PageEvent) {
    let startIndex = event.pageIndex * this.pageSize;
    let endIndex = startIndex  + this.pageSize;
    if(endIndex < startIndex) {
      endIndex = this.cardLength;
    }
    this.pagedList = this.cards.slice(startIndex, endIndex)
  }

  constructor(@Inject(Router) router: Router) {
    this.router = router;
  }
}
