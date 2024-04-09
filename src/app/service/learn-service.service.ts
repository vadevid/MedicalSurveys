import { Injectable } from '@angular/core';
import introJs from "intro.js";
import {resolve} from "@angular/compiler-cli";
import {IntroJs} from "intro.js/src/intro";

@Injectable({
  providedIn: 'root'
})
export class LearnServiceService {

  private _steps = introJs().setOptions({
    steps: [
      {
        element: '#doctorList',
        intro: 'Это список врачей',
        position: "bottom-middle-aligned",
        disableInteraction: true
      },
      {
        element: '#paging',
        intro: 'Список можно переключать',
        position: "top-middle-aligned",
        disableInteraction: true
      },
      {
        element: '#confirm',
        intro: 'Давайте выберем этого врача',
        position: "right"
      },
      {
        element: '#pageLearn',
        intro: 'Это страница заполнения запроса',
        position: "bottom",
      },
      {
        element: '#inputLearn',
        intro: 'Здесь заполняются данные',
        position: "right"
      },
      {
        element: '#finishButton',
        intro: 'Нажав на эту кнопку будет произведена отправка запроса',
        position: "right"
      },
    ],
    showProgress: true,
    autoPosition: false,
    exitOnOverlayClick: false,
    skipLabel: "<h6 style='margin: 0 0 0 -70px; padding: 0; color: #0D47A1'>Пропустить</h6>",
    nextLabel: "Далее",
    prevLabel: "Назад",
    hidePrev: true,
    doneLabel: "Готово"
  }).onbeforechange(async () => {
    return new Promise((resolve) => {
      console.log('Performing I/O...');
      setInterval(resolve, 200);
    });
  })

  private _firstStep = true;

  constructor() { }


  get steps(): IntroJs {
    return this._steps;
  }

  get firstStep(): boolean {
    return this._firstStep;
  }

  set firstStep(value: boolean) {
    this._firstStep = value;
  }
}
