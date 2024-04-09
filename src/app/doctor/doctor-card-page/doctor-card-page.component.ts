import {Component, Inject, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {UserState} from "../../store/user.reducer";
import {ActivatedRoute, RouterOutlet} from "@angular/router";
import {DoctorCardPageNavComponent} from "./doctor-card-page-nav/doctor-card-page-nav.component";
import {AsyncPipe} from "@angular/common";
import {selectToken, selectUserId} from "../../store/user.selectors";

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
  userId: Observable<number | undefined> = this.store$.pipe(select(selectUserId));
  token: Observable<string | undefined> = this.store$.pipe(select(selectToken));
  route: ActivatedRoute;
  cardid: number | undefined;

  constructor(private store$: Store<UserState>,
              @Inject(ActivatedRoute) route: ActivatedRoute) {
    this.route = route;
    this.cardid = +this.route.snapshot.paramMap.get('id')!;
  }

  ngOnInit(): void {
  }

}
