import {Component, Inject, OnInit} from '@angular/core';
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {data} from "autoprefixer";
import axios from "axios";
import {
  MatDatepicker,
  MatDatepickerActions, MatDatepickerApply, MatDatepickerCancel,
  MatDatepickerInput,
  MatDatepickerToggle
} from "@angular/material/datepicker";
import {MatFormField, MatHint, MatLabel} from "@angular/material/form-field";
import {FormsModule} from "@angular/forms";
import {MatRadioButton} from "@angular/material/radio";
import {MatAnchor, MatButton} from "@angular/material/button";
import {MatInput} from "@angular/material/input";

@Component({
  selector: 'app-register',
  standalone: true,
  templateUrl: './register.component.html',
  imports: [
    MatFormField,
    FormsModule,
    MatRadioButton,
    MatDatepickerInput,
    MatDatepickerToggle,
    MatDatepicker,
    MatDatepickerActions,
    MatHint,
    MatAnchor,
    MatButton,
    RouterLink,
    MatDatepickerCancel,
    MatDatepickerApply,
    MatInput,
    MatLabel
  ],
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  login: string | undefined;
  pass: string | undefined;
  secondName: string | undefined;
  firstName: string | undefined;
  middleName: string | undefined;
  dateOfBirthField: any;
  dateOfBirth: string | undefined;
  male: boolean = true;
  woman: boolean = false;
  email: string | undefined;
  sex: string | undefined;
  router: Router;
  constructor(@Inject(Router) router: Router) {
    this.router = router;
  }
  OnDateChange(date: unknown) {
    this.dateOfBirthField = date;
    var month;
    var day;
    if (this.dateOfBirthField.getMonth()+1 < 10) month = "0"+(this.dateOfBirthField.getMonth()+1)
    else month = (this.dateOfBirthField.getMonth()+1)

    if (this.dateOfBirthField.getDate() < 10) day = "0"+(this.dateOfBirthField.getDate())
    else day = (this.dateOfBirthField.getDate())

    this.dateOfBirth = day+"."+month+"."+this.dateOfBirthField.getFullYear();
  }

  async RegisterBtn() {
    if (this.male) this.sex = 'М';
    if (this.woman) this.sex = 'Ж';
    if (this.login != null && this.pass != null && this.secondName != null &&
      this.firstName != null && this.middleName != null && this.dateOfBirth != null ) {
      await axios.post("http://localhost:8080/auth/register", {
        secondName: this.secondName,
        firstName: this.firstName,
        middleName: this.middleName,
        email: this.email,
        login: this.login,
        password: this.pass,
        birthdate: this.dateOfBirth,
        sex: this.sex
      }).then((response) => {
        if (response.data) {
          this.router.navigate(['login', {login: this.login}])
        } else alert("Такой пользователь уже существует")
      }
      )
    } else alert("Заполнены не все поля.")
  }

  ngOnInit(): void {
  }
}
