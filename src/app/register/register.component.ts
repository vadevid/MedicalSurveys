import {Component, Inject, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {data} from "autoprefixer";
import axios from "axios";
import {MatDatepicker} from "@angular/material/datepicker";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  login: string;
  pass: string;
  secondName: string;
  firstName: string;
  middleName: string;
  dateOfBirthField: any;
  dateOfBirth: string;
  male: boolean = true;
  woman: boolean = false;
  email: string;
  sex: string;
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
