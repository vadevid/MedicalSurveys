import {AfterViewInit, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Doctor} from "../../../../../model/doctor";
import {MatPaginator, PageEvent} from "@angular/material/paginator";
import {MatGridList, MatGridTile} from "@angular/material/grid-list";
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {MatAnchor} from "@angular/material/button";
import {NgForOf} from "@angular/common";
import introJs from "intro.js";
import {async} from "rxjs";
import {LearnServiceService} from "../../../../../service/learn-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-learn-contacting-dashboard',
  templateUrl: './learn-contacting-dashboard.component.html',
  styleUrls: ['./learn-contacting-dashboard.component.css'],
  standalone: true,
  imports: [
    MatGridList,
    MatGridTile,
    MatCard,
    MatCardHeader,
    MatCardContent,
    MatPaginator,
    MatAnchor,
    MatCardTitle,
    NgForOf
  ]
})
export class LearnContactingDashboardComponent implements OnInit, AfterViewInit {

  constructor(router: Router) {
    this.routing = router;
  }

  @Input() service: LearnServiceService | undefined;

  // myDoctor: Doctor =

  doctors: Doctor[] = [
    {id: 1, secondName: "Иванов", firstName: "Александр", middleName: "Петрович", type: "Психотерапевт"},
    {id: 2, secondName: "Петров", firstName: "Елена", middleName: "Сергеевна", type: "Кардиолог"},
    {id: 3, secondName: "Сидоров", firstName: "Ольга", middleName: "Анатольевна", type: "Невролог"},
    {id: 4, secondName: "Смирнов", firstName: "Дмитрий", middleName: "Иванович", type: "Онколог"},
    {id: 5, secondName: "Кузнецова", firstName: "Мария", middleName: "Алексеевна", type: "Офтальмолог"},
    {id: 6, secondName: "Васильев", firstName: "Анна", middleName: "Владимировна", type: "Педиатр"},
    {id: 7, secondName: "Михайлов", firstName: "Алексей", middleName: "Павлович", type: "Травматолог"},
    {id: 8, secondName: "Федоров", firstName: "Евгения", middleName: "Дмитриевна", type: "Стоматолог"},
    {id: 9, secondName: "Алексеев", firstName: "Александра", middleName: "Игоревна", type: "Гинеколог"},
    {id: 10, secondName: "Яковлев", firstName: "Виктор", middleName: "Сергеевич", type: "Уролог"},
    {id: 11, secondName: "Соловьев", firstName: "Елена", middleName: "Андреевна", type: "Эндокринолог"},
    {id: 12, secondName: "Волкова", firstName: "Антонина", middleName: "Александровна", type: "Дерматолог"}
  ]
  pagedList: Doctor[] = [];

  routing: Router;

  ngOnInit(): void {
    this.pagedList = this.doctors.slice(0, 6)
  }

  onPageChange(event: PageEvent) {
    let startIndex = event.pageIndex * event.pageSize;
    let endIndex = startIndex + event.pageSize;
    if (endIndex < startIndex) {
      endIndex = this.doctors.length;
    }
    this.pagedList = this.doctors.slice(startIndex, endIndex)
  }

  ngAfterViewInit(): void {
    this.service?.steps
      .oncomplete(() => this.complete())
      .onskip(() => this.skip())
      .start();
  }

  complete() {
    this.routing.navigate(['clientpage'])
  }

  skip() {
    this.routing.navigate(['clientpage'])
  }


  @Output() changeStepEvent = new EventEmitter<boolean>;

  changeStep() {
    this.changeStepEvent.emit(false);
  }
}
