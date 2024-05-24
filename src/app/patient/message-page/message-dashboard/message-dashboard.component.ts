import {Component, Inject, Input, OnInit} from '@angular/core';
import {MatAnchor} from "@angular/material/button";
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {MatGridList, MatGridTile} from "@angular/material/grid-list";
import {MatPaginator, PageEvent} from "@angular/material/paginator";
import {NgForOf, NgIf} from "@angular/common";
import {Router} from "@angular/router";
import {PatientMessage} from "../../../model/patient-message";
import axios from "axios";
import {MatDialog} from "@angular/material/dialog";
import {MessageDialogComponent} from "./message-dialog/message-dialog.component";

@Component({
  selector: 'app-message-dashboard',
  standalone: true,
  imports: [
    MatAnchor,
    MatCard,
    MatCardContent,
    MatCardHeader,
    MatCardTitle,
    MatGridList,
    MatGridTile,
    MatPaginator,
    NgForOf,
    NgIf
  ],
  templateUrl: './message-dashboard.component.html',
  styleUrl: './message-dashboard.component.css'
})
export class MessageDashboardComponent implements OnInit{

  messages: PatientMessage[] = [];
  @Input()
  data: any;

  pagedList: PatientMessage[] = [];
  messagesLength: number | undefined;
  pageSize = 6;
  router: Router;
  dialog: MatDialog;

  onPageChange(event: PageEvent) {
    let startIndex = event.pageIndex * event.pageSize;
    let endIndex = startIndex  + event.pageSize;
    if(endIndex < startIndex) {
      endIndex = this.messagesLength!;
    }
    this.pagedList = this.messages.slice(startIndex, endIndex)
  }

  constructor(@Inject(Router) router: Router, @Inject(MatDialog) private matDialog: MatDialog) {
    this.router = router;
    this.dialog = matDialog;
  }

  ngOnInit(): void {
    this.LoadMessages()
  }

  async LoadMessages() {
    await axios.post("/api/patient/getAllMessage", {
      "id": this.data?.userId
    }, {
      headers: {
        'Authorization': `Bearer ${this.data?.token}`
      }
    }).then((response) => {
        this.messages = response.data;
        this.messagesLength = this.messages.length;
        this.pagedList = this.messages.slice(0, this.pageSize)
      }
    )
  }

  openMessage(id: number | undefined) {
    this.dialog.open(MessageDialogComponent, {
      width: '700px',
      height: '350px',
      data: {
        userId: this.data.userId,
        token: this.data.token,
        messageId: id
      }
    })
  }
}
