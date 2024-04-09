import {Component, Inject, OnInit, Output} from '@angular/core';
import {ActivatedRoute, Router, RouterOutlet} from "@angular/router";
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {UserState} from "../../store/user.reducer";
import {CardPageNavComponent} from "./card-page-nav/card-page-nav.component";
import {AsyncPipe} from "@angular/common";
import {selectToken, selectUserId} from "../../store/user.selectors";

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
  userId: Observable<number | undefined> = this.store$.pipe(select(selectUserId));
  token: Observable<string | undefined | null> = this.store$.pipe(select(selectToken));

  constructor(@Inject(Router) router: Router,
              @Inject(ActivatedRoute) route: ActivatedRoute,
              private store$: Store<UserState>,) {
    this.routing = router;
    this.route = route;
    this.cardid = +this.route.snapshot.paramMap.get('id')!;
  }

  ngOnInit(): void {
  }

}
