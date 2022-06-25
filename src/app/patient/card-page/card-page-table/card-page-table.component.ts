import {Component, Input, OnInit} from '@angular/core';
import {CardValues} from "../../../model/card-values";
import axios from "axios";

@Component({
  selector: 'app-card-page-table',
  templateUrl: './card-page-table.component.html',
  styleUrls: ['./card-page-table.component.css']
})
export class CardPageTableComponent implements OnInit {
  @Input()
  cardid: number;
  @Input()
  token: string;

  dataSource : CardValues[] = [];
  displayedColumns: string[] = ['answer', 'answerDate']
  constructor() { }

  ngOnInit(): void {
    this.GetData();
  }

  async GetData() {
    await axios.post("http://localhost:8080/card/getallanswer", {
      id: this.cardid
    }, {
      headers: {
        'Authorization': `Bearer ${this.token}`
      }
    }).then((response) => {
        this.dataSource = response.data;
      }
    )
  }

}
