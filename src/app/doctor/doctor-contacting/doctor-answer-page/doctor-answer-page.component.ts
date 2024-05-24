import {Component, Inject, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {UserState} from "../../../store/user.reducer";
import {ActivatedRoute, RouterOutlet} from "@angular/router";
import {AsyncPipe} from "@angular/common";
import {selectToken, selectUserId} from "../../../store/user.selectors";
import {DoctorContactingInfoComponent} from "../doctor-contacting-info/doctor-contacting-info.component";
import {DoctorNavComponent} from "../../../nav/doctor-nav/doctor-nav.component";
import {
  DoctorAnswerPageDashboardComponent
} from "./doctor-answer-page-dashboard/doctor-answer-page-dashboard.component";
import {UserSyncStorageService} from "../../../service/user-sync-storage.service";

@Component({
  selector: 'app-doctor-answer-page',
  templateUrl: './doctor-answer-page.component.html',
  styleUrls: ['./doctor-answer-page.component.css'],
  standalone: true,
  imports: [
    RouterOutlet,
    AsyncPipe,
    AsyncPipe,
    DoctorContactingInfoComponent,
    DoctorNavComponent,
    DoctorAnswerPageDashboardComponent
  ]
})
export class DoctorAnswerPageComponent implements OnInit {

  answerId: number | undefined;
  userId: Observable<number | undefined> = this.store$.pipe(select(selectUserId));
  token: Observable<string | undefined> = this.store$.pipe(select(selectToken));
  route: ActivatedRoute;

  constructor(
    private store$: Store<UserState>,
    @Inject(ActivatedRoute) route: ActivatedRoute,
    private userSyncStorage: UserSyncStorageService
  ) {
    this.route = route;
    this.userId = this.store$.pipe(select(selectUserId));
    this.token = this.store$.pipe(select(selectToken));
  }

  ngOnInit(): void {
    this.userSyncStorage.init();
    this.answerId = +this.route.snapshot.paramMap.get('id')!;
  }

}
