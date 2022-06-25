import {Component, EventEmitter, Inject, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";
import {UserLogoutAction} from "../../../store/user.actions";
import {Store} from "@ngrx/store";
import {UserState} from "../../../store/user.reducer";
import {Router} from "@angular/router";

@Component({
  selector: 'app-doctor-page-nav',
  templateUrl: './doctor-page-nav.component.html',
  styleUrls: ['./doctor-page-nav.component.css']
})
export class DoctorPageNavComponent implements OnInit {
  @Input()
  userId: number;
  @Input()
  token: string;
  logoutEmmit = new EventEmitter<number>();
  router: Router;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver,
              private store$: Store<UserState>, @Inject(Router) router: Router) {
    this.router = router;
  }

  Logout() {
    this.logoutEmmit.emit(this.userId);
    this.LogoutDispatch(this.userId);
    this.router.navigate(['login']);
  }
  LogoutDispatch(userid: number) {
    this.store$.dispatch(new UserLogoutAction({userid}))
  }
  ngOnInit(): void {
  }

}
