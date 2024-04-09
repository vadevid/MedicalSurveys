import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {LearnContactingNavComponent} from "./learn-contacting-nav/learn-contacting-nav.component";
import introJs from "intro.js";
import {Router} from "@angular/router";
import {LearnServiceService} from "../../../service/learn-service.service";
import {NgIf} from "@angular/common";
import {LearnContactingSecondNavComponent} from "./learn-contacting-second-nav/learn-contacting-second-nav.component";

@Component({
  selector: 'app-first-learn',
  templateUrl: './first-learn.component.html',
  styleUrls: ['./first-learn.component.css'],
  standalone: true,
  imports: [
    LearnContactingNavComponent,
    NgIf,
    LearnContactingSecondNavComponent
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
    this.firstStep = this.service.firstStep
  }

  changeStep(newValue: boolean) {
    this.firstStep = newValue;
  }

}
