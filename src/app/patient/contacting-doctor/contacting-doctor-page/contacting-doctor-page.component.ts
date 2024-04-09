import {Component, Inject, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {tokenSelector, userSelector} from "../../../store/user.selectors";
import {UserState} from "../../../store/user.reducer";
import {UserSyncStorageService} from "../../../service/user-sync-storage.service";
import {ActivatedRoute} from "@angular/router";
import {ContactingDoctorPageNavComponent} from "./contacting-doctor-page-nav/contacting-doctor-page-nav.component";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'app-contacting-doctor-page',
  templateUrl: './contacting-doctor-page.component.html',
  styleUrls: ['./contacting-doctor-page.component.css'],
  standalone: true,
  imports: [
    ContactingDoctorPageNavComponent,
    AsyncPipe,
    AsyncPipe
  ]
})
export class ContactingDoctorPageComponent implements OnInit {
  userId: Observable<number | undefined> = this.store$.pipe(select(userSelector));
  token: Observable<string | undefined> = this.store$.pipe(select(tokenSelector));
  doctorId: number | undefined;
  route: ActivatedRoute;

  constructor(
    private store$: Store<UserState>,
    private userSyncStorage: UserSyncStorageService,
    @Inject(ActivatedRoute) route: ActivatedRoute,) {
    this.route = route;
    this.doctorId = +this.route.snapshot.paramMap.get('id')!; }

  ngOnInit(): void {
    this.userSyncStorage.init();
  }

}
