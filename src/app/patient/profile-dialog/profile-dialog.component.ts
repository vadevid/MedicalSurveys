import {Component, EventEmitter, Inject, Input, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {NavBarComponent} from "../client-page/nav-bar/nav-bar.component";
import {select, Store} from "@ngrx/store";
import {UserState} from "../../store/user.reducer";
import {Observable} from "rxjs";
import {userSelector} from "../../store/user.selectors";
import {UserLogoutAction} from "../../store/user.actions";
import {Router} from "@angular/router";
import axios from "axios";

@Component({
  selector: 'app-profile-dialog',
  templateUrl: './profile-dialog.component.html',
  styleUrls: ['./profile-dialog.component.css']
})
export class ProfileDialogComponent implements OnInit {

  router: Router;
  dialog: MatDialog;
  fio: String;
  age: String;
  sex: String;
  growth: String;
  weight: String;
  mass_index: String;
  mass_index_status: String;
  weightNew: String;
  growthNew: String;

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
    this.store$.dispatch(new UserLogoutAction({userid}))
  }

  ngOnInit(): void {
    this.getPatientInfo(this.userId);
  }

  async getPatientInfo(userid: number) {
    await axios.post('http://localhost:8080/patient/info', {
      "id": userid
    }, {
      headers: {
        'Authorization': `Bearer ${this.token}`
      }
    }).then((responce) => {
      this.fio = responce.data.fio;
      this.age = responce.data.age;
      this.sex = responce.data.sex == "М" ? "Мужской" : "Женский";
      this.growth = responce.data.growth;
      this.weight = responce.data.weight;
      this.mass_index = responce.data.mass_index == "NaN" ? 0: responce.data.mass_index.substring(0, 4);
      if (Number(responce.data.mass_index.substring(0,3)) < 18.5) this.mass_index_status = "Недостаточная масса тела";
      if (Number(responce.data.mass_index.substring(0,3)) > 18.5 && Number(responce.data.mass_index.substring(0,3)) < 25) this.mass_index_status = "Норма";
      if (Number(responce.data.mass_index.substring(0,3)) > 25 && Number(responce.data.mass_index.substring(0,3)) < 30) this.mass_index_status = "Избыточная масса тела";
      if (Number(responce.data.mass_index.substring(0,3)) > 30) this.mass_index_status = "Ожирение";
    })
  }

  async SendNewDefaultValue() {
    console.log(this.growthNew);
    console.log(this.weightNew);
    await axios.post('http://localhost:8080/patient/setvalue', {
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

}
