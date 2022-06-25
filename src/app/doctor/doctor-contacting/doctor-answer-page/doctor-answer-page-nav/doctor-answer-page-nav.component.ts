import {Component, EventEmitter, Inject, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";
import {Store} from "@ngrx/store";
import {UserState} from "../../../../store/user.reducer";
import {Router} from "@angular/router";
import {UserLogoutAction} from "../../../../store/user.actions";

@Component({
  selector: 'app-doctor-answer-page-nav',
  templateUrl: './doctor-answer-page-nav.component.html',
  styleUrls: ['./doctor-answer-page-nav.component.css']
})
export class DoctorAnswerPageNavComponent implements OnInit {

  @Input()
  answerId: number;
  @Input()
  doctorId: number;
  @Input()
  token: string;
  router: Router;
  logoutEmmit = new EventEmitter<number>();
  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );
  constructor(private breakpointObserver: BreakpointObserver,
              private store$: Store<UserState>, @Inject(Router) router: Router) {
    this.router = router;
  }

  ngOnInit(): void {
  }
  Logout() {
    this.logoutEmmit.emit(this.doctorId);
    this.LogoutDispatch(this.doctorId);
    this.router.navigate(['login']);
  }
  LogoutDispatch(userid: number) {
    this.store$.dispatch(new UserLogoutAction({userid}))
  }

}
