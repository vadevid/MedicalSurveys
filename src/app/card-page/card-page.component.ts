import {Component, Inject, OnInit, Output} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {UserSyncStorageService} from "../service/user-sync-storage.service";
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {userSelector} from "../store/user.selectors";
import {UserState} from "../store/user.reducer";

@Component({
  selector: 'app-card-page',
  templateUrl: './card-page.component.html',
  styleUrls: ['./card-page.component.css']
})
export class CardPageComponent implements OnInit {
  routing: Router;
  route: ActivatedRoute;
  cardid: number;
  userId: Observable<number> = this.store$.pipe(select(userSelector));

  constructor(@Inject(Router) router: Router,
              @Inject(ActivatedRoute) route: ActivatedRoute,
              private userSyncStorage: UserSyncStorageService,
              private store$: Store<UserState>,) {
    this.routing = router;
    this.route = route;
    this.cardid = +this.route.snapshot.paramMap.get('id');
  }

  ngOnInit(): void {
    this.userSyncStorage.init();
  }

}
