import {Component, Input, OnInit} from '@angular/core';
import axios from "axios";

@Component({
  selector: 'app-contacting-doctor-dashboard',
  templateUrl: './contacting-doctor-dashboard.component.html',
  styleUrls: ['./contacting-doctor-dashboard.component.css']
})
export class ContactingDoctorDashboardComponent implements OnInit {
  @Input()
  token: String;
  @Input()
  userId: number;
  @Input()
  doctorId: number;
  textValue: String;
  constructor() { }

  ngOnInit(): void {
  }

  async SendMessage() {
    await axios.post("http://localhost:8080/patient/sendmessage", {
      patientId: this.userId,
      doctorId: this.doctorId,
      message: this.textValue
    }, {
      headers: {
        'Authorization': `Bearer ${this.token}`
      }
    }).then((response) => {
      if (response.data) alert("Сообщение отправлено")
      else alert("Ошибка отправки")
    })
  }
}
