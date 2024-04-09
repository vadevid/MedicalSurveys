import {Component, Inject, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {tokenSelector, userSelector} from "../../store/user.selectors";
import {UserSyncStorageService} from "../../service/user-sync-storage.service";
import {UserState} from "../../store/user.reducer";
import {ActivatedRoute, RouterOutlet} from "@angular/router";
import {DoctorCardPageNavComponent} from "./doctor-card-page-nav/doctor-card-page-nav.component";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'app-doctor-card-page',
  templateUrl: './doctor-card-page.component.html',
  styleUrls: ['./doctor-card-page.component.css'],
  standalone: true,
  imports: [
    DoctorCardPageNavComponent,
    RouterOutlet,
    AsyncPipe,
    AsyncPipe
  ]
})
export class DoctorCardPageComponent implements OnInit {
  userId: Observable<number | undefined> = this.store$.pipe(select(userSelector));
  token: Observable<string | undefined> = this.store$.pipe(select(tokenSelector));
  route: ActivatedRoute;
  cardid: number | undefined;

  constructor(private userSyncStorage: UserSyncStorageService,
              private store$: Store<UserState>,
              @Inject(ActivatedRoute) route: ActivatedRoute) {
    this.route = route;
    this.cardid = +this.route.snapshot.paramMap.get('id')!;
  }

  ngOnInit(): void {
    this.userSyncStorage.init();
  }

}
