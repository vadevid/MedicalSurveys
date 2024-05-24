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
  data: any;
  show: boolean | undefined;
  cardInfo: CardInfo | undefined;
  constructor() { }

  ngOnInit(): void {
    this.LoadCardInfo();
  }
  async LoadCardInfo() {
    await axios.post("/api/doctor/getCard", {
      id: this.data.cardId
    }, {
      headers: {
        'Authorization': `Bearer ${this.data.token}`
      }
    }).then((response) => {
      this.cardInfo = response.data
    })
    this.show = this.cardInfo!.cardType == "NumberField";
  }

}
