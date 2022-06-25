import {Component, Input, OnInit} from '@angular/core';
import {ChartType, Row} from "angular-google-charts";
import axios from "axios";
import {CardValues} from "../../../model/card-values";

@Component({
  selector: 'app-card-page-graph',
  templateUrl: './card-page-graph.component.html',
  styleUrls: ['./card-page-graph.component.css']
})
export class CardPageGraphComponent implements OnInit {
  @Input()
  cardid: number;
  @Input()
  token: string;
  columnNames = ["Дата" ,"Значение", "Мин", "Макс"]
  dataSource: CardValues[] = []
  options = {
    hAxis: {
      title: 'Дата'
    },
    vAxis:{
      title: 'Значения'
    },
  };
  chartData: Row[] = [
  ];
  title = 'Показатели';
  type:ChartType = ChartType.LineChart;

  constructor() {
  }

  ngOnInit() {
    this.LoadAllAnswer()
  }

  async LoadAllAnswer() {
    await axios.post("http://localhost:8080/card/getallanswer", {
      id: this.cardid
    }, {
      headers: {
        'Authorization': `Bearer ${this.token}`
      }
    }).then((response) => {
      this.dataSource = response.data
      this.dataSource.forEach((item) => {
        this.chartData.push([item.answerDate, Number(item.answer), item.minValue, item.maxValue])
      })
    })
  }
}
