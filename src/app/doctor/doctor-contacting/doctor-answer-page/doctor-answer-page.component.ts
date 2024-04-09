import {Component, Inject, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {UserState} from "../../../store/user.reducer";
import {ActivatedRoute, RouterOutlet} from "@angular/router";
import {DoctorAnswerPageNavComponent} from "./doctor-answer-page-nav/doctor-answer-page-nav.component";
import {AsyncPipe} from "@angular/common";
import {selectToken, selectUserId} from "../../../store/user.selectors";

@Component({
  selector: 'app-doctor-answer-page',
  templateUrl: './doctor-answer-page.component.html',
  styleUrls: ['./doctor-answer-page.component.css'],
  standalone: true,
  imports: [
    DoctorAnswerPageNavComponent,
    RouterOutlet,
    AsyncPipe,
    AsyncPipe
  ]
})
export class DoctorAnswerPageComponent implements OnInit {

  answerId: number | undefined;
  userId: Observable<number | undefined> = this.store$.pipe(select(selectUserId));
  token: Observable<string | undefined> = this.store$.pipe(select(selectToken));
  route: ActivatedRoute;
  constructor(
    private store$: Store<UserState>,
    @Inject(ActivatedRoute) route: ActivatedRoute) {
    this.route = route;
  }

  ngOnInit(): void {
    this.answerId = +this.route.snapshot.paramMap.get('id')!;
  }

}
