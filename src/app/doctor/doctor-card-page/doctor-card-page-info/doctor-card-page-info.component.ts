import {Component, Input, OnInit} from '@angular/core';
import {CardInfo} from "../../../model/card-info";
import axios from "axios";
import {MatTab, MatTabGroup} from "@angular/material/tabs";
import {NgIf} from "@angular/common";
import {CardPageTableComponent} from "../../../patient/card-page/card-page-table/card-page-table.component";
import {CardPageGraphComponent} from "../../../patient/card-page/card-page-graph/card-page-graph.component";

@Component({
  selector: 'app-doctor-card-page-info',
  templateUrl: './doctor-card-page-info.component.html',
  styleUrls: ['./doctor-card-page-info.component.css'],
  standalone: true,
  imports: [
    MatTabGroup,
    MatTab,
    NgIf,
    CardPageTableComponent,
    CardPageGraphComponent
  ]
})
export class DoctorCardPageInfoComponent implements OnInit {
  @Input()
  cardid: number| undefined;
  @Input()
  userId: number | undefined;
  @Input()
  token: string | undefined | null;
  show: boolean | undefined;
  cardInfo: CardInfo | undefined;
  constructor() { }

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

}
