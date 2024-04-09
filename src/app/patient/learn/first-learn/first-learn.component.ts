import {Component, OnInit} from '@angular/core';
import {LearnContactingNavComponent} from "./learn-contacting-nav/learn-contacting-nav.component";
import introJs from "intro.js";
import {Router} from "@angular/router";
import {LearnServiceService} from "../../../service/learn-service.service";

@Component({
  selector: 'app-first-learn',
  templateUrl: './first-learn.component.html',
  styleUrls: ['./first-learn.component.css'],
  standalone: true,
  imports: [
    LearnContactingNavComponent
  ]
})
export class FirstLearnComponent implements OnInit {

  routing: Router;
  firstStep: boolean = true;
  secondStep: boolean = false;
  service: LearnServiceService = new LearnServiceService();

  constructor(router: Router) {
    this.routing = router;
  }

  ngOnInit(): void {
  }

}
