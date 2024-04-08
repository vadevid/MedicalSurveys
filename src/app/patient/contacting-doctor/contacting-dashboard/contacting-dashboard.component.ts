import {Component, Input, OnInit} from '@angular/core';
import {PageEvent} from "@angular/material/paginator";
import {Card} from "../../../model/card";
import {Doctor} from "../../../model/doctor";
import axios from "axios";

@Component({
  selector: 'app-contacting-dashboard',
  templateUrl: './contacting-dashboard.component.html',
  styleUrls: ['./contacting-dashboard.component.css']
})
export class ContactingDashboardComponent implements OnInit {
  @Input()
  userId: number;
  @Input()
  token: String;

  doctors: Doctor[];
  pagedList: Doctor[] = [];
  doctorsLength: number;
  pageSize = 6;
  onPageChange(event: PageEvent) {
    let startIndex = event.pageIndex * event.pageSize;
    let endIndex = startIndex  + event.pageSize;
    if(endIndex < startIndex) {
      endIndex = this.doctorsLength;
    }
    this.pagedList = this.doctors.slice(startIndex, endIndex)
  }

  constructor() { }

  ngOnInit(): void {
    this.LoadDoctors();
  }
  async LoadDoctors() {
    await axios.post("/api/patient/findAllDoctor", {},{
      headers: {
        'Authorization': `Bearer ${this.token}`
      }
    }).then((response) => {
        this.doctors = response.data;
        this.doctorsLength = this.doctors.length;
        this.pagedList = this.doctors.slice(0, 6);
      }
    )
  }
}
