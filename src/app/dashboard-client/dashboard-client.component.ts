import {Component, Inject, Input, OnInit} from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import {PageEvent} from "@angular/material/paginator";
import {Router} from "@angular/router";
import {Card} from "../model/card";
import axios from "axios";

@Component({
  selector: 'app-dashboard-client',
  templateUrl: './dashboard-client.component.html',
  styleUrls: ['./dashboard-client.component.css']
})
export class DashboardClientComponent implements OnInit{

  cards: Card[] = [];
  @Input()
  userid: number;
  pagedList: Card[] = [];
  cardLength: number;
  pageSize = 6;
  router: Router;

  ngOnInit() {
    this.LoadCards(this.userid);
  }

  async LoadCards(userid: number) {
    await axios.post("http://localhost:8080/card/getall", {
      "id": userid
    }).then((response) => {
      this.cards = response.data;
      this.cardLength = this.cards.length;
      this.pagedList = this.cards.slice(0, 6)
      console.log(this.cards);
      }
    )
  }

  onPageChange(event: PageEvent) {
    let startIndex = event.pageIndex * event.pageSize;
    let endIndex = startIndex  + event.pageSize;
    if(endIndex < startIndex) {
      endIndex = this.cardLength;
    }
    this.pagedList = this.cards.slice(startIndex, endIndex)
  }

  constructor(@Inject(Router) router: Router) {
    this.router = router;
  }
}
