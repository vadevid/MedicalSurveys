import {Component, Inject, Input, OnInit} from '@angular/core';
import {CardInfo} from "../../../model/card-info";
import axios from "axios";
import {Router} from "@angular/router";
import {CardValues} from "../../../model/card-values";
import {Row} from "angular-google-charts";

@Component({
  selector: 'app-card-page-info',
  templateUrl: './card-page-info.component.html',
  styleUrls: ['./card-page-info.component.css']
})
export class CardPageInfoComponent implements OnInit {
  @Input()
  cardid: number;
  @Input()
  userId: number;
  @Input()
  token: String;
  show: boolean;
  cardInfo: CardInfo;
  newNumberValue: String;
  newTextValue: String;
  router: Router;
  constructor(@Inject(Router) router: Router) {
    this.router = router;
  }

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

  async SendNewValue() {
    await axios.post("http://localhost:8080/card/newvalue", {
      cardId: this.cardid,
      value: this.show ? this.newNumberValue : this.newTextValue,
    }, {
      headers: {
        'Authorization': `Bearer ${this.token}`
      }
    }).then((response) => {
        if (response.data)
          window.location.reload();
          else alert("Отправка не удалась")
      }
    )
  }
}
