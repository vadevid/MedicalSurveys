import {Component, Inject, Input, OnInit} from '@angular/core';
import {DoctorCard} from "../../../model/doctor-card";
import {Router} from "@angular/router";
import {PageEvent} from "@angular/material/paginator";
import axios from "axios";
import {AnswerCard} from "../../../model/answer-card";

@Component({
  selector: 'app-doctor-contacting-info',
  templateUrl: './doctor-contacting-info.component.html',
  styleUrls: ['./doctor-contacting-info.component.css']
})
export class DoctorContactingInfoComponent implements OnInit {

  cards: AnswerCard[] = [];
  @Input()
  userid: number;
  @Input()
  token: string;
  pagedList: AnswerCard[] = [];
  cardLength: number;
  pageSize = 6;
  router: Router;
  constructor(@Inject(Router) router: Router) {
    this.router = router;
  }
  onPageChange(event: PageEvent) {
    let startIndex = event.pageIndex * event.pageSize;
    let endIndex = startIndex  + event.pageSize;
    if(endIndex < startIndex) {
      endIndex = this.cardLength;
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
