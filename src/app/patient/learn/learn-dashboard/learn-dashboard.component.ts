import {Component, Input, numberAttribute, OnInit} from '@angular/core';
import {LearnModule} from "../../../model/learn-module";
import axios from "axios";
import {data} from "autoprefixer";
import {RouterLink} from "@angular/router";
import {MatButton} from "@angular/material/button";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-learn-dashboard',
  templateUrl: './learn-dashboard.component.html',
  styleUrls: ['./learn-dashboard.component.css'],
  standalone: true,
  imports: [
    RouterLink,
    MatButton,
    NgIf,
    NgIf,
    NgForOf
  ]
})
export class LearnDashboardComponent implements OnInit {

  modules: LearnModule[] | null = null;

  @Input({transform: numberAttribute})
  userId: number | undefined;
  @Input()
  token: string | undefined | null;

  constructor() { }

  ngOnInit(): void {
    this.LoadModules()
  }

  async LoadModules() {
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
