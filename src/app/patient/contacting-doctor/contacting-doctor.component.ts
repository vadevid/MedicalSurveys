import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {UserState} from "../../store/user.reducer";
import {ContactingNavComponent} from "./contacting-nav/contacting-nav.component";
import {RouterOutlet} from "@angular/router";
import {AsyncPipe} from "@angular/common";
import {selectToken, selectUserId} from "../../store/user.selectors";

@Component({
  selector: 'app-contacting-doctor',
  templateUrl: './contacting-doctor.component.html',
  styleUrls: ['./contacting-doctor.component.css'],
  standalone: true,
  imports: [
    ContactingNavComponent,
    RouterOutlet,
    AsyncPipe,
    AsyncPipe
  ]
})
export class ContactingDoctorComponent implements OnInit {
  userId: Observable<number | undefined> = this.store$.pipe(select(selectUserId));
  token: Observable<string | undefined | null> = this.store$.pipe(select(selectToken));

  constructor(
    private store$: Store<UserState>,
  ) {
  }

  ngOnInit(): void {
  }

}
