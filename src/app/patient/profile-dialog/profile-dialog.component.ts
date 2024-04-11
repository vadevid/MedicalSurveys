import {Component, EventEmitter, Inject, Input, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {NavBarComponent} from "../client-page/nav-bar/nav-bar.component";
import {select, Store} from "@ngrx/store";
import {UserState} from "../../store/user.reducer";
import {Observable} from "rxjs";
import {Router} from "@angular/router";
import axios from "axios";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {FormsModule} from "@angular/forms";
import {MatInput} from "@angular/material/input";
import {MatButton} from "@angular/material/button";
import {logout} from "../../store/user.actions";

@Component({
  selector: 'app-profile-dialog',
  templateUrl: './profile-dialog.component.html',
  styleUrls: ['./profile-dialog.component.css'],
  imports: [
    MatFormField,
    FormsModule,
    MatInput,
    MatButton,
    MatLabel
  ],
  standalone: true
})
export class ProfileDialogComponent implements OnInit {

  router: Router;
  dialog: MatDialog;
  fio: string | undefined;
  age: string | undefined;
  sex: string | undefined;
  growth: string | undefined;
  weight: string | undefined;
  mass_index: string | undefined;
  mass_index_status: string | undefined;
  weightNew: string | undefined;
  growthNew: string | undefined;

  constructor(@Inject(MatDialogRef) public dialogRef: MatDialogRef<NavBarComponent>,
              private store$: Store<UserState>, @Inject(MAT_DIALOG_DATA) public data: any,
              @Inject(Router) router: Router, @Inject(MatDialog) private matDialog: MatDialog) {
    this.dialog = matDialog;
    this.router = router;
  }
  logoutEmmit = new EventEmitter<number>();
  userId: number = this.data.userId;
  token: string = this.data.token;

  OnLogout() {
    this.logoutEmmit.emit(this.userId);
    this.OnLogoutDispatch(this.userId);
    this.dialog.closeAll();
    this.router.navigate(['login']);
  }
  OnLogoutDispatch(userid: number) {
    this.store$.dispatch(logout({userid}))
  }

  ngOnInit(): void {
    this.getPatientInfo(this.userId);
  }

  async getPatientInfo(userid: number) {
    await axios.post('/api/patient/info', {
      "id": userid
    }, {
      headers: {
        'Authorization': `Bearer ${this.token}`
      }
    }).then((response) => {
      this.fio = response.data.fio;
      this.age = response.data.age;
      this.sex = response.data.sex == "М" ? "Мужской" : "Женский";
      this.growth = response.data.growth;
      this.weight = response.data.weight;
      this.mass_index = response.data.massIndex;
      if (Number(this.mass_index) < 18.5) this.mass_index_status = "Недостаточная масса тела";
      if (Number(this.mass_index) > 18.5 && Number(this.mass_index) < 25) this.mass_index_status = "Норма";
      if (Number(this.mass_index) > 25 && Number(this.mass_index) < 30) this.mass_index_status = "Избыточная масса тела";
      if (Number(this.mass_index) > 30) this.mass_index_status = "Ожирение";
    })
  }

  async SendNewDefaultValue() {
    await axios.post('/api/patient/setValue', {
      patientId: this.userId,
      growth: this.growthNew,
      weight: this.weightNew
    }, {
      headers: {
        'Authorization': `Bearer ${this.token}`
      }
    }).then( (response) => {
      if (response.data) this.dialog.closeAll();
      else prompt("Отправка не удалась")
      }
    )
  }

  GoToLearn() {
    this.dialog.closeAll();
    this.router.navigate(['learn'])
  }

}
