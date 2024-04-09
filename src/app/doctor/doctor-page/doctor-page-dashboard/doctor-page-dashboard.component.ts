import {Component, Inject, Input, OnInit} from '@angular/core';
import {Router, RouterLink} from "@angular/router";
import {MatPaginator, PageEvent} from "@angular/material/paginator";
import {Card} from "../../../model/card";
import axios from "axios";
import {DoctorCard} from "../../../model/doctor-card";
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {MatGridList, MatGridTile} from "@angular/material/grid-list";
import {NgForOf, NgIf} from "@angular/common";
import {MatAnchor} from "@angular/material/button";

@Component({
  selector: 'app-doctor-page-dashboard',
  templateUrl: './doctor-page-dashboard.component.html',
  styleUrls: ['./doctor-page-dashboard.component.css'],
  standalone: true,
  imports: [
    MatCardTitle,
    MatPaginator,
    MatCardContent,
    MatCardHeader,
    MatCard,
    MatGridList,
    MatGridTile,
    NgForOf,
    NgIf,
    MatAnchor,
    MatAnchor,
    RouterLink
  ]
})
export class DoctorPageDashboardComponent implements OnInit {
  cards: DoctorCard[] = [];
  @Input()
  userid: number | undefined;
  @Input()
  token: string | undefined | null;
  pagedList: DoctorCard[] = [];
  cardLength: number | undefined;
  pageSize = 6;
  router: Router;
  constructor(@Inject(Router) router: Router) {
    this.router = router;
  }
  onPageChange(event: PageEvent) {
    let startIndex = event.pageIndex * event.pageSize;
    let endIndex = startIndex  + event.pageSize;
    if(endIndex < startIndex) {
      endIndex = this.cardLength!;
    }
    this.pagedList = this.cards.slice(startIndex, endIndex)
  }

  async LoadCards() {
    await axios.post("http://localhost:8080/card/getdoctorall", {
      "id": this.userid
    },{
      headers: {
        'Authorization': `Bearer ${this.token}`
      }
    }).then((response) => {
        this.cards = response.data;
        this.cardLength = this.cards.length;
        this.pagedList = this.cards.slice(0, 6)
      }
    )
  }

  ngOnInit(): void {
    this.LoadCards();
  }

}
