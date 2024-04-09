import {Component, EventEmitter, Inject, Input, numberAttribute, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";
import {UserLogoutAction} from "../../../store/user.actions";
import {Store} from "@ngrx/store";
import {UserState} from "../../../store/user.reducer";
import {Router, RouterLink} from "@angular/router";
import {DoctorPageDashboardComponent} from "../doctor-page-dashboard/doctor-page-dashboard.component";
import {MatListItem, MatNavList} from "@angular/material/list";
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from "@angular/material/sidenav";
import {MatToolbar} from "@angular/material/toolbar";
import {MatIcon} from "@angular/material/icon";
import {AsyncPipe, NgIf} from "@angular/common";
import {MatAnchor, MatIconButton} from "@angular/material/button";

@Component({
  selector: 'app-doctor-page-nav',
  templateUrl: './doctor-page-nav.component.html',
  styleUrls: ['./doctor-page-nav.component.css'],
  standalone: true,
  imports: [
    DoctorPageDashboardComponent,
    MatNavList,
    MatSidenav,
    MatToolbar,
    MatIcon,
    MatSidenavContent,
    MatSidenavContainer,
    NgIf,
    MatListItem,
    RouterLink,
    RouterLink,
    MatListItem,
    MatIconButton,
    MatAnchor,
    AsyncPipe,
    AsyncPipe
  ]
})
export class DoctorPageNavComponent implements OnInit {
  @Input({transform: numberAttribute})
  userId: number | undefined;
  @Input()
  token: string | undefined | null;
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
    this.LogoutDispatch(this.userId!);
    this.router.navigate(['login']);
  }
  LogoutDispatch(userid: number) {
    this.store$.dispatch(new UserLogoutAction({userid}))
  }
  ngOnInit(): void {
  }

}
