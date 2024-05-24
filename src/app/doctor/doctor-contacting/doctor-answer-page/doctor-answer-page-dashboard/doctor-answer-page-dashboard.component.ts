import {Component, Input, OnInit} from '@angular/core';
import axios from "axios";
import {Message} from "../../../../model/message";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatRadioButton} from "@angular/material/radio";
import {NgIf} from "@angular/common";
import {MatButton} from "@angular/material/button";
import {MatInput} from "@angular/material/input";
import {FormsModule} from "@angular/forms";
import {MatCheckbox} from "@angular/material/checkbox";

@Component({
  selector: 'app-doctor-answer-page-dashboard',
  templateUrl: './doctor-answer-page-dashboard.component.html',
  styleUrls: ['./doctor-answer-page-dashboard.component.css'],
  standalone: true,
  imports: [
    MatLabel,
    MatFormField,
    MatRadioButton,
    MatFormField,
    MatRadioButton,
    MatLabel,
    MatLabel,
    MatFormField,
    NgIf,
    MatButton,
    MatButton,
    MatInput,
    FormsModule,
    MatCheckbox
  ]
})
export class DoctorAnswerPageDashboardComponent implements OnInit {
  @Input()
  data: any;
  answer: Message | undefined;
  textValue: boolean = true;
  numberValue: boolean | undefined;
  name: string | undefined;
  message: string | undefined
  min: number | null = null;
  max: number | null = null;
  flag: boolean = false;
  constructor() { }

  ngOnInit(): void {
    this.GetAnswer();
  }

  async GetAnswer() {
    await axios.post("/api/doctor/getMessage", {
      "id": this.data.answerId
    },{
      headers: {
        'Authorization': `Bearer ${this.data.token}`
      }
    }).then((response) => {
      this.answer = response.data;
    })
  }

  async SendCard(id: number | undefined) {
    if (!this.flag) {
      await axios.post("/api/doctor/sendCard", {
        "name": this.name,
        "contactingId": id,
        "min": this.min,
        "max": this.max,
        "type": this.textValue ? "TextField" : "NumberField"
      },{
        headers: {
          'Authorization': `Bearer ${this.data.token}`
        }
      }).then((response) => {
        if (response.data) alert("Карточка отправлена")

      })
    } else {
      await axios.post("/api/doctor/sendMessage", {
        "doctorId": this.data.userId,
        "contactingId": this.data.answerId,
        "message": this.message
      },{
        headers: {
          'Authorization': `Bearer ${this.data.token}`
        }
      }).then((response) => {
        if (response.data) alert("Сообщение отправлено")
      })
    }

  }

}
