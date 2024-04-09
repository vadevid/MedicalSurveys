import { Component, OnInit } from '@angular/core';
import {LearnContactingNavComponent} from "./learn-contacting-nav/learn-contacting-nav.component";
import introJs from "intro.js";

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

  constructor() { }

  ngOnInit(): void {
    introJs().setOptions({
      steps: [
        {
          element: '#doctorList',
          intro: 'Это список врачей',
          position: "bottom"
        }]
    }).start()
  }

}
