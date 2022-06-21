import {Component, Input, OnInit} from '@angular/core';
import axios from "axios";
import {CardValues} from "../../model/card-values";
import {ChartType, Row} from "angular-google-charts";

@Component({
  selector: 'app-card-page-graph',
  templateUrl: './card-page-graph.component.html',
  styleUrls: ['./card-page-graph.component.css']
})
export class CardPageGraphComponent implements OnInit {
  @Input()
  cardid: number;

  title = 'Показатели';
  type: ChartType = ChartType.LineChart;

  constructor() {
  }
  dataSource : CardValues[] = [];
  chartData: Row[] = [
  ];

  ngOnInit() {
    this.GetData();
  }

  LoadChartData() {
    this.dataSource.forEach((item) => {
      this.chartData.push([item.answerDate, Number(item.answer)])
    })
  }

  async GetData() {
    await axios.post("http://localhost:8080/card/getallanswer", {
      id: this.cardid
    }).then((response) => {
        this.dataSource = response.data;
      }
    )
    this.LoadChartData()
  }
}
