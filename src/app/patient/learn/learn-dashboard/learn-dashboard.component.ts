import {Component, Input, OnInit} from '@angular/core';
import {LearnModule} from "../../../model/learn-module";
import axios from "axios";
import {data} from "autoprefixer";

@Component({
  selector: 'app-learn-dashboard',
  templateUrl: './learn-dashboard.component.html',
  styleUrls: ['./learn-dashboard.component.css']
})
export class LearnDashboardComponent implements OnInit {

  modules: LearnModule[] = null;

  @Input()
  userId: number;
  @Input()
  token: string;

  constructor() { }

  ngOnInit(): void {
    this.LoadModules()
  }

  async LoadModules() {
    console.log(this.userId)
    await axios.post("/api/patient/getModules", {
      "id": this.userId
    }, {
      headers: {
        'Authorization': `Bearer ${this.token}`
      }
    }).then((response) => {
      this.modules = response.data;
    })
  }

  ActivateLesson(id: number) {

  }
}
