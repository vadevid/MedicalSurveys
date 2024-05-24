import {Component, Inject, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {UserState} from "../../store/user.reducer";
import {ActivatedRoute, RouterOutlet} from "@angular/router";
import {AsyncPipe} from "@angular/common";
import {selectToken, selectUserId} from "../../store/user.selectors";
import {DoctorNavComponent} from "../../nav/doctor-nav/doctor-nav.component";
import {DoctorPageDashboardComponent} from "../doctor-page/doctor-page-dashboard/doctor-page-dashboard.component";
import {DoctorCardPageInfoComponent} from "./doctor-card-page-info/doctor-card-page-info.component";
import {UserSyncStorageService} from "../../service/user-sync-storage.service";

@Component({
  selector: 'app-doctor-card-page',
  templateUrl: './doctor-card-page.component.html',
  styleUrls: ['./doctor-card-page.component.css'],
  standalone: true,
  imports: [
    RouterOutlet,
    AsyncPipe,
    AsyncPipe,
    DoctorNavComponent,
    DoctorPageDashboardComponent,
    DoctorCardPageInfoComponent
  ]
})
export class DoctorCardPageComponent implements OnInit {
  userId: Observable<number | undefined> = this.store$.pipe(select(selectUserId));
  token: Observable<string | undefined> = this.store$.pipe(select(selectToken));
  route: ActivatedRoute;
  cardId: number | undefined;

  constructor(private store$: Store<UserState>,
              @Inject(ActivatedRoute) route: ActivatedRoute,
              private userSyncStorage: UserSyncStorageService) {
    this.route = route;
    this.cardId = +this.route.snapshot.paramMap.get('id')!;
    this.userId = this.store$.pipe(select(selectUserId));
    this.token = this.store$.pipe(select(selectToken));
  }

  ngOnInit(): void {
    this.userSyncStorage.init();
  }

}
