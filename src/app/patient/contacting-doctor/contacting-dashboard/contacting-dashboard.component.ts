import {Component, Input, OnInit} from '@angular/core';
import {MatPaginator, PageEvent} from "@angular/material/paginator";
import {Doctor} from "../../../model/doctor";
import axios from "axios";
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {MatGridList, MatGridTile} from "@angular/material/grid-list";
import {NgForOf} from "@angular/common";
import {MatAnchor} from "@angular/material/button";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-contacting-dashboard',
  templateUrl: './contacting-dashboard.component.html',
  styleUrls: ['./contacting-dashboard.component.css'],
  standalone: true,
  imports: [
    MatCardContent,
    MatCard,
    MatPaginator,
    MatCardTitle,
    MatCardHeader,
    MatGridTile,
    MatGridList,
    NgForOf,
    MatAnchor,
    RouterLink,
    MatAnchor
  ]
})
export class ContactingDashboardComponent implements OnInit {
  @Input()
  data: any;

  doctors: Doctor[] | undefined;
  pagedList: Doctor[] = [];
  doctorsLength: number | undefined;
  pageSize = 6;
  onPageChange(event: PageEvent) {
    let startIndex = event.pageIndex * event.pageSize;
    let endIndex = startIndex  + event.pageSize;
    if(endIndex < startIndex) {
      endIndex = this.doctorsLength!;
    }
    this.pagedList = this.doctors!.slice(startIndex, endIndex)
  }

  constructor() { }

  ngOnInit(): void {
    this.LoadDoctors();
  }
  async LoadDoctors() {
    await axios.post("/api/patient/findAllDoctor", {},{
      headers: {
        'Authorization': `Bearer ${this.data.token}`
      }
    }).then((response) => {
        this.doctors = response.data;
        this.doctorsLength = this.doctors!.length;
        this.pagedList = this.doctors!.slice(0, 6);
      }
    )
  }
}
