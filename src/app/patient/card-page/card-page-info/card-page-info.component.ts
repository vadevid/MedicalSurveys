import {Component, Inject, Input, OnInit} from '@angular/core';
import {CardInfo} from "../../../model/card-info";
import axios from "axios";
import {Router} from "@angular/router";
import {CardValues} from "../../../model/card-values";
import {CardPageGraphComponent} from "../card-page-graph/card-page-graph.component";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {CardPageTableComponent} from "../card-page-table/card-page-table.component";
import {MatTab, MatTabGroup} from "@angular/material/tabs";
import {NgIf} from "@angular/common";
import {MatInput} from "@angular/material/input";
import {MatButton} from "@angular/material/button";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-card-page-info',
  templateUrl: './card-page-info.component.html',
  styleUrls: ['./card-page-info.component.css'],
  standalone: true,
  imports: [
    CardPageGraphComponent,
    MatFormField,
    CardPageTableComponent,
    MatTab,
    MatTabGroup,
    MatTabGroup,
    MatLabel,
    MatFormField,
    CardPageTableComponent,
    NgIf,
    MatInput,
    MatInput,
    MatInput,
    MatButton,
    MatButton,
    MatButton,
    MatButton,
    FormsModule
  ]
})
export class CardPageInfoComponent implements OnInit {
  @Input()
  cardid: number | undefined;
  @Input()
  userId: number | undefined;
  @Input()
  token: string | undefined | null;
  show: boolean | undefined;
  cardInfo: CardInfo | undefined;
  newNumberValue: string | undefined;
  newTextValue: string | undefined;
  router: Router;
  constructor(@Inject(Router) router: Router) {
    this.router = router;
  }

  ngOnInit(): void {
    this.LoadCardInfo(this.cardid!);
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
    if (this.cardInfo!.cardType == "NumberField") {
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
