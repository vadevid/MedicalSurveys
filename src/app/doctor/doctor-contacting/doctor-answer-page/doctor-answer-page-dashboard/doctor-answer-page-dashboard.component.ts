import {Component, Input, OnInit} from '@angular/core';
import axios from "axios";
import {Message} from "../../../../model/message";

@Component({
  selector: 'app-doctor-answer-page-dashboard',
  templateUrl: './doctor-answer-page-dashboard.component.html',
  styleUrls: ['./doctor-answer-page-dashboard.component.css']
})
export class DoctorAnswerPageDashboardComponent implements OnInit {
  @Input()
  answerId: number;
  @Input()
  doctorId: number;
  @Input()
  token: string;
  answer: Message;
  textValue: boolean = true;
  numberValue: boolean;
  name: String;
  min: number = null;
  max: number = null;
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

  async SendCard(id: number) {
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
