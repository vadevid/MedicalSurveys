import {Component, Input, OnInit} from '@angular/core';
import axios from "axios";
import {Message} from "../../../../model/message";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatRadioButton} from "@angular/material/radio";
import {NgIf} from "@angular/common";
import {MatButton} from "@angular/material/button";
import {MatInput} from "@angular/material/input";
import {FormsModule} from "@angular/forms";

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
    FormsModule
  ]
})
export class DoctorAnswerPageDashboardComponent implements OnInit {
  @Input()
  answerId: number | undefined;
  @Input()
  doctorId: number | undefined;
  @Input()
  token: string | undefined | null;
  answer: Message | undefined;
  textValue: boolean = true;
  numberValue: boolean | undefined;
  name: string | undefined;
  min: number | null = null;
  max: number | null = null;
  constructor() { }

  ngOnInit(): void {
    this.GetAnswer();
  }

  async GetAnswer() {
    await axios.post("http://localhost:8080/doctor/getmessage", {
      "id": this.answerId
    },{
      headers: {
        'Authorization': `Bearer ${this.token}`
      }
    }).then((response) => {
      this.answer = response.data;
    })
  }

  async SendCard(id: number | undefined) {
    await axios.post("http://localhost:8080/doctor/sendcard", {
      "name": this.name,
      "contactingId": this.answerId,
      "min": this.min,
      "max": this.max,
      "type": this.textValue ? "TextField" : "NumberField"
    },{
      headers: {
        'Authorization': `Bearer ${this.token}`
      }
    }).then((response) => {
      if (response.data) alert("Карточка отправлена")
    })
  }

}
