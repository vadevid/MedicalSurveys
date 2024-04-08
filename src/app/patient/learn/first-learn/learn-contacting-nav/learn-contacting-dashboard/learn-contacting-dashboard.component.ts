import { Component, OnInit } from '@angular/core';
import {Doctor} from "../../../../../model/doctor";
import {PageEvent} from "@angular/material/paginator";

@Component({
  selector: 'app-learn-contacting-dashboard',
  templateUrl: './learn-contacting-dashboard.component.html',
  styleUrls: ['./learn-contacting-dashboard.component.css']
})
export class LearnContactingDashboardComponent implements OnInit {

  constructor() { }

  doctors: Doctor[] = [
    {id: 1, secondName: "Да", firstName: "Да", middleName: "Да", type: "Психотерапевт"},
    {id: 2, secondName: "Да", firstName: "Да", middleName: "Да", type: "Психотерапевт"},
    {id: 3, secondName: "Да", firstName: "Да", middleName: "Да", type: "Психотерапевт"},
    {id: 4, secondName: "Да", firstName: "Да", middleName: "Да", type: "Психотерапевт"},
    {id: 5, secondName: "Да", firstName: "Да", middleName: "Да", type: "Психотерапевт"},
    {id: 6, secondName: "Да", firstName: "Да", middleName: "Да", type: "Психотерапевт"},
    {id: 7, secondName: "Да", firstName: "Да", middleName: "Да", type: "Психотерапевт"},
    {id: 8, secondName: "Да", firstName: "Да", middleName: "Да", type: "Психотерапевт"},
    {id: 9, secondName: "Да", firstName: "Да", middleName: "Да", type: "Психотерапевт"},
    {id: 10, secondName: "Да", firstName: "Да", middleName: "Да", type: "Психотерапевт"},
    {id: 11, secondName: "Да", firstName: "Да", middleName: "Да", type: "Психотерапевт"},
    {id: 12, secondName: "Да", firstName: "Да", middleName: "Да", type: "Психотерапевт"}
  ]
  pagedList: Doctor[] = [];

  ngOnInit(): void {
    this.pagedList = this.doctors.slice(0, 6)
  }

  onPageChange(event: PageEvent) {
    let startIndex = event.pageIndex * event.pageSize;
    let endIndex = startIndex  + event.pageSize;
    if(endIndex < startIndex) {
      endIndex = this.doctors.length;
    }
    this.pagedList = this.doctors.slice(startIndex, endIndex)
  }

}
