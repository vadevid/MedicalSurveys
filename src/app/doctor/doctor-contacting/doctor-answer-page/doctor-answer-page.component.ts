import {Component, Inject, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {tokenSelector, userSelector} from "../../../store/user.selectors";
import {UserState} from "../../../store/user.reducer";
import {UserSyncStorageService} from "../../../service/user-sync-storage.service";
import {ActivatedRoute, RouterOutlet} from "@angular/router";
import {DoctorAnswerPageNavComponent} from "./doctor-answer-page-nav/doctor-answer-page-nav.component";
import {AsyncPipe} from "@angular/common";

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
  userId: Observable<number | undefined> = this.store$.pipe(select(userSelector));
  token: Observable<string | undefined> = this.store$.pipe(select(tokenSelector));
  route: ActivatedRoute;
  constructor(
    private store$: Store<UserState>,
    private userSyncStorage: UserSyncStorageService,
    @Inject(ActivatedRoute) route: ActivatedRoute) {
    this.route = route;
  }

  ngOnInit(): void {
    this.userSyncStorage.init();
    this.answerId = +this.route.snapshot.paramMap.get('id')!;
  }

}
