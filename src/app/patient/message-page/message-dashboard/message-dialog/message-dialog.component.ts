import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {PatientNavComponent} from "../../../../nav/patient-nav/patient-nav.component";
import {Router} from "@angular/router";
import axios from "axios";
import {MatAnchor} from "@angular/material/button";

@Component({
  selector: 'app-message-dialog',
  standalone: true,
  imports: [
    MatAnchor
  ],
  templateUrl: './message-dialog.component.html',
  styleUrl: './message-dialog.component.css'
})
export class MessageDialogComponent implements OnInit{

  router: Router;
  dialog: MatDialog;

  constructor(@Inject(MatDialogRef) public dialogRef: MatDialogRef<PatientNavComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any,
              @Inject(Router) router: Router, @Inject(MatDialog) private matDialog: MatDialog) {
    this.dialog = matDialog;
    this.router = router;
  }

  doctorName: string | undefined;
  doctorType: string | undefined;
  text: string | undefined;

  ngOnInit(): void {
    this.getMessage()
  }

  async getMessage() {
    await axios.post('/api/patient/getMessage', {
      "id": this.data.messageId
    }, {
      headers: {
        'Authorization': `Bearer ${this.data.token}`
      }
    }).then((response) => {
      this.doctorName = response.data.doctorName;
      this.doctorType = response.data.doctorType;
      this.text = response.data.text
    })
  }

  async deleteMessage() {
    await axios.post('/api/patient/deleteMessage', {
      "id": this.data.messageId
    }, {
      headers: {
        'Authorization': `Bearer ${this.data.token}`
      }
    }).then((response) => {
      if (response.data) {
        this.dialog.closeAll();
        window.location.reload()
      }
    })
  }
}
