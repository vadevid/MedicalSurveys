import {Component, Inject, OnInit} from '@angular/core';
import {ActivatedRoute, Router, RouterOutlet} from "@angular/router";
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {UserState} from "../../store/user.reducer";
import {AsyncPipe} from "@angular/common";
import {selectToken, selectUserId} from "../../store/user.selectors";
import {PatientNavComponent} from "../../nav/patient-nav/patient-nav.component";
import {DashboardClientComponent} from "../client-page/dashboard-client/dashboard-client.component";
import {UserSyncStorageService} from "../../service/user-sync-storage.service";
import {CardPageInfoComponent} from "./card-page-info/card-page-info.component";

@Component({
  selector: 'app-card-page',
  templateUrl: './card-page.component.html',
  styleUrls: ['./card-page.component.css'],
  standalone: true,
  imports: [
    RouterOutlet,
    AsyncPipe,
    PatientNavComponent,
    DashboardClientComponent,
    CardPageInfoComponent
  ]
})
export class CardPageComponent implements OnInit {
  routing: Router;
  route: ActivatedRoute;
  cardid: number | undefined;
  userId: Observable<number | undefined>;
  token: Observable<string> | undefined;

  constructor(
    private store$: Store<UserState>,
    private userSyncStorage: UserSyncStorageService,
    @Inject(Router) router: Router,
    @Inject(ActivatedRoute) route: ActivatedRoute,
  ) {
    this.routing = router;
    this.route = route;
    this.userId = this.store$.pipe(select(selectUserId));
    this.token = this.store$.pipe(select(selectToken));
    this.cardid = +this.route.snapshot.paramMap.get('id')!;
  }

  ngOnInit(): void {
    this.userSyncStorage.init()
  }

}
