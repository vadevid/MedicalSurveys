import {Component, Inject, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {tokenSelector, userSelector} from "../../store/user.selectors";
import {UserSyncStorageService} from "../../service/user-sync-storage.service";
import {UserState} from "../../store/user.reducer";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-doctor-card-page',
  templateUrl: './doctor-card-page.component.html',
  styleUrls: ['./doctor-card-page.component.css']
})
export class DoctorCardPageComponent implements OnInit {
  userId: Observable<number> = this.store$.pipe(select(userSelector));
  token: Observable<string> = this.store$.pipe(select(tokenSelector));
  route: ActivatedRoute;
  cardid: number;

  constructor(private userSyncStorage: UserSyncStorageService,
              private store$: Store<UserState>,
              @Inject(ActivatedRoute) route: ActivatedRoute) {
    this.route = route;
    this.cardid = +this.route.snapshot.paramMap.get('id');
  }

  ngOnInit(): void {
    this.userSyncStorage.init();
  }

}
