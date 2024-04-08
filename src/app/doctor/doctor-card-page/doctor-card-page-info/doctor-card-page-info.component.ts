import {Component, Input, OnInit} from '@angular/core';
import {CardInfo} from "../../../model/card-info";
import axios from "axios";

@Component({
  selector: 'app-doctor-card-page-info',
  templateUrl: './doctor-card-page-info.component.html',
  styleUrls: ['./doctor-card-page-info.component.css']
})
export class DoctorCardPageInfoComponent implements OnInit {
  @Input()
  cardid: number;
  @Input()
  userId: number;
  @Input()
  token: String;
  show: boolean;
  cardInfo: CardInfo;
  constructor() { }

  ngOnInit(): void {
    this.LoadCardInfo(this.cardid);
  }
  async LoadCardInfo(id: number) {
    await axios.post("http://localhost:8080/card/getcard", {
      id: id
    }, {
      headers: {
        'Authorization': `Bearer ${this.token}`
      }
    }).then((response) => {
      this.cardInfo = response.data
    })
    if (this.cardInfo.cardType == "NumberField") {
      this.show = true;
    } else this.show = false;
  }

}
