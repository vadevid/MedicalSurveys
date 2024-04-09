import {Component, Input, numberAttribute, OnInit} from '@angular/core';
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
  token: string | undefined | null;
  @Input({transform: numberAttribute})
  userId: number | undefined;
  @Input({transform: numberAttribute})
  doctorId: number | undefined;
  textValue: string | undefined;
  constructor() { }

  ngOnInit(): void {
  }

  async SendMessage() {
    await axios.post("/api/patient/sendMessage", {
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
