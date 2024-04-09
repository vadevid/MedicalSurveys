import {Component, Inject, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {UserState} from "../../../store/user.reducer";
import {ActivatedRoute} from "@angular/router";
import {ContactingDoctorPageNavComponent} from "./contacting-doctor-page-nav/contacting-doctor-page-nav.component";
import {AsyncPipe} from "@angular/common";
import {selectToken, selectUserId} from "../../../store/user.selectors";

@Component({
  selector: 'app-contacting-doctor-page',
  templateUrl: './contacting-doctor-page.component.html',
  styleUrls: ['./contacting-doctor-page.component.css'],
  standalone: true,
  imports: [
    ContactingDoctorPageNavComponent,
    AsyncPipe,
    AsyncPipe
  ]
})
export class ContactingDoctorPageComponent implements OnInit {
  userId: Observable<number | undefined> = this.store$.pipe(select(selectUserId));
  token: Observable<string | undefined | null> = this.store$.pipe(select(selectToken));
  doctorId: number | undefined;
  route: ActivatedRoute;

  constructor(
    private store$: Store<UserState>,
    @Inject(ActivatedRoute) route: ActivatedRoute,) {
    this.route = route;
    this.doctorId = +this.route.snapshot.paramMap.get('id')!; }

  ngOnInit(): void {
  }

}
