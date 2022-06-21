import {Component, Input, OnInit} from '@angular/core';
import {CardInfo} from "../../model/card-info";
import axios from "axios";

@Component({
  selector: 'app-card-page-info',
  templateUrl: './card-page-info.component.html',
  styleUrls: ['./card-page-info.component.css']
})
export class CardPageInfoComponent implements OnInit {
  @Input()
  cardid: number;
  show: boolean;
  cardInfo: CardInfo;
  constructor() { }

  ngOnInit(): void {
    this.LoadCardInfo(this.cardid);
  }

  async LoadCardInfo(id: number) {
    await axios.post("http://localhost:8080/card/getcard", {
      id: id
    }).then((response) => {      this.cardInfo = response.data

    })
    if (this.cardInfo.cardType == "NumberField") {
      this.show = true;
    } else this.show = false;
  }
}
