import {
  AfterViewChecked,
  Component,
  Input,
  OnInit
} from '@angular/core';
import axios from "axios";
import {CardValues} from "../../../model/card-values";
import {NgIf} from "@angular/common";
import {BaseChartDirective} from "ng2-charts";
import {Chart, registerables} from "chart.js";

@Component({
  selector: 'app-card-page-graph',
  templateUrl: './card-page-graph.component.html',
  styleUrls: ['./card-page-graph.component.css'],
  standalone: true,
  imports: [
    NgIf,
    BaseChartDirective
  ]
})
export class CardPageGraphComponent implements OnInit, AfterViewChecked {
  flag: boolean = false;
  @Input()
  cardid: number | undefined;
  @Input()
  token: string | undefined | null;
  @Input()
  target: boolean | undefined;
  dataSource: CardValues[] = []
  title = 'Показатели';

  valueData: number[] = [];
  minData: number[] = [];
  maxData: number[] = [];
  labels: string[] = [];

  constructor() {

  }

  ngOnInit() {
    this.LoadAllAnswer()
  }

  async LoadAllAnswer() {
    if (this.target) {
      await axios.post("/api/patient/getCardAllAnswer", {
        id: this.cardid
      }, {
        headers: {
          'Authorization': `Bearer ${this.token}`
        }
      }).then((response) => {
        this.dataSource = response.data
        this.dataSource.forEach((item) => {
          this.valueData.push(Number(item.answer));
          this.maxData.push(Number(item.maxValue));
          this.minData.push(Number(item.minValue))
          if (item.answerDate != null) {
            this.labels.push(item.answerDate)
          }
        })
      })
    }
    if (!this.target) {
      await axios.post("/api/doctor/getCardAllAnswer", {
        id: this.cardid
      }, {
        headers: {
          'Authorization': `Bearer ${this.token}`
        }
      }).then((response) => {
        this.dataSource = response.data
        this.dataSource.forEach((item) => {
          this.valueData.push(Number(item.answer));
          this.maxData.push(Number(item.maxValue));
          this.minData.push(Number(item.minValue))
          if (item.answerDate != null) {
            this.labels.push(item.answerDate)
          }
        })
      })
    }
  }

  ngAfterViewChecked(): void {
    this.loadChart()
  }

  loadChart() {
    Chart.register(...registerables)
    const canvas = document.getElementById("chart") as HTMLCanvasElement
    if (canvas && !this.flag) {
      const mixedChart = new Chart(canvas, {
        data: {
          datasets: [
            {
              type: 'line',
              label: 'Значение',
              data: this.valueData
            },
            {
              type: 'line',
              label: 'Максимальное значение',
              data: this.maxData
            },
            {
              type: 'line',
              label: 'Минимальное значение',
              data: this.minData
            }
          ],
          labels: this.labels
        },
        options: {
          scales: {
            y: {
              beginAtZero: true
            }
          },
          responsive: false
        }
      })
      mixedChart.resize(1200, 600)
      this.flag = true;
    }
  }
}
