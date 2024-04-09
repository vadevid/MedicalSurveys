import {Component, Inject, Input, OnInit} from '@angular/core';
import {DoctorCard} from "../../../model/doctor-card";
import {Router, RouterLink} from "@angular/router";
import {MatPaginator, PageEvent} from "@angular/material/paginator";
import axios from "axios";
import {AnswerCard} from "../../../model/answer-card";
import {MatGridList, MatGridTile} from "@angular/material/grid-list";
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {NgForOf, NgIf} from "@angular/common";
import {MatAnchor} from "@angular/material/button";

@Component({
  selector: 'app-doctor-contacting-info',
  templateUrl: './doctor-contacting-info.component.html',
  styleUrls: ['./doctor-contacting-info.component.css'],
  standalone: true,
  imports: [
    MatGridList,
    MatCardContent,
    MatCardTitle,
    MatPaginator,
    MatCardHeader,
    MatGridTile,
    MatCard,
    NgForOf,
    NgIf,
    MatAnchor,
    MatAnchor,
    RouterLink
  ]
})
export class DoctorContactingInfoComponent implements OnInit {

  cards: AnswerCard[] = [];
  @Input()
  userid: number | undefined;
  @Input()
  token: string | undefined | null;
  pagedList: AnswerCard[] = [];
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
    await axios.post("http://localhost:8080/doctor/getallmessage", {
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
