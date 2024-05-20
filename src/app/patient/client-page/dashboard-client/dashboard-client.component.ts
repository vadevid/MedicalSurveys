import {Component, Inject, Input, OnInit} from '@angular/core';
import {MatPaginator, PageEvent} from "@angular/material/paginator";
import {Router, RouterLink} from "@angular/router";
import {Card} from "../../../model/card";
import axios from "axios";
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {MatGridList, MatGridTile} from "@angular/material/grid-list";
import {NgForOf, NgIf} from "@angular/common";
import {MatAnchor} from "@angular/material/button";

@Component({
  selector: 'app-dashboard-client',
  templateUrl: './dashboard-client.component.html',
  styleUrls: ['./dashboard-client.component.css'],
  standalone: true,
  imports: [
    MatCardHeader,
    MatGridList,
    MatCardContent,
    MatCard,
    MatGridTile,
    MatCardTitle,
    MatPaginator,
    NgForOf,
    NgIf,
    RouterLink,
    MatAnchor,
    MatAnchor
  ]
})
export class DashboardClientComponent implements OnInit{

  cards: Card[] = [];

  @Input()
  data: any;

  pagedList: Card[] = [];
  cardLength: number | undefined;
  pageSize = 6;
  router: Router;

  ngOnInit() {
    this.LoadCards(this.data?.userId);
  }

  async LoadCards(userid: number | undefined) {
    await axios.post("http://localhost:8080/api/patient/getAllCard", {
      "id": userid
    }, {
      headers: {
        'Authorization': `Bearer ${this.data?.token}`
      }
    }).then((response) => {
      this.cards = response.data;
      this.cardLength = this.cards.length;
      this.pagedList = this.cards.slice(0, this.pageSize)
      }
    )
  }

  onPageChange(event: PageEvent) {
    let startIndex = event.pageIndex * event.pageSize;
    let endIndex = startIndex  + event.pageSize;
    if(endIndex < startIndex) {
      endIndex = this.cardLength!;
    }
    this.pagedList = this.cards.slice(startIndex, endIndex)
  }

  constructor(@Inject(Router) router: Router) {
    this.router = router;
  }
}
