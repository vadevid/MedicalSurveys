import {Component, Inject, OnInit, Output} from '@angular/core';
import {ActivatedRoute, Router, RouterOutlet} from "@angular/router";
import {UserSyncStorageService} from "../../service/user-sync-storage.service";
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {tokenSelector, userSelector} from "../../store/user.selectors";
import {UserState} from "../../store/user.reducer";
import {CardPageNavComponent} from "./card-page-nav/card-page-nav.component";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'app-card-page',
  templateUrl: './card-page.component.html',
  styleUrls: ['./card-page.component.css'],
  standalone: true,
  imports: [
    CardPageNavComponent,
    RouterOutlet,
    AsyncPipe
  ]
})
export class CardPageComponent implements OnInit {
  routing: Router;
  route: ActivatedRoute;
  cardid: number | undefined;
  userId: Observable<number | undefined> = this.store$.pipe(select(userSelector));
  token: Observable<string | undefined> = this.store$.pipe(select(tokenSelector));

  constructor(@Inject(Router) router: Router,
              @Inject(ActivatedRoute) route: ActivatedRoute,
              private userSyncStorage: UserSyncStorageService,
              private store$: Store<UserState>,) {
    this.routing = router;
    this.route = route;
    this.cardid = +this.route.snapshot.paramMap.get('id')!;
  }

  ngOnInit(): void {
    this.userSyncStorage.init();
  }

}
