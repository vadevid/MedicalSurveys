import {Component, Input, OnInit} from '@angular/core';
import axios from "axios";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatButton} from "@angular/material/button";
import {MatInput} from "@angular/material/input";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-contacting-doctor-dashboard',
  templateUrl: './contacting-doctor-dashboard.component.html',
  styleUrls: ['./contacting-doctor-dashboard.component.css'],
  standalone: true,
  imports: [
    MatFormField,
    MatLabel,
    MatButton,
    MatInput,
    MatInput,
    FormsModule
  ]
})
export class ContactingDoctorDashboardComponent implements OnInit {
  @Input()
  data: any;
  textValue: string | undefined;
  constructor() { }

  ngOnInit(): void {
  }

  async SendMessage() {
    await axios.post("/api/patient/sendMessage", {
      patientId: this.data.userId,
      doctorId: this.data.doctorId,
      message: this.textValue
    }, {
      headers: {
        'Authorization': `Bearer ${this.data.token}`
      }
    }).then((response) => {
      if (response.data) alert("Сообщение отправлено")
      else alert("Ошибка отправки")
    })
  }
}
