import {Component, EventEmitter, Inject, Input, numberAttribute, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";
import {Store} from "@ngrx/store";
import {UserState} from "../../../../store/user.reducer";
import {Router, RouterLink} from "@angular/router";
import {UserLogoutAction} from "../../../../store/user.actions";
import {
  DoctorAnswerPageDashboardComponent
} from "../doctor-answer-page-dashboard/doctor-answer-page-dashboard.component";
import {MatToolbar} from "@angular/material/toolbar";
import {MatListItem, MatNavList} from "@angular/material/list";
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from "@angular/material/sidenav";
import {MatIcon} from "@angular/material/icon";
import {AsyncPipe, NgIf} from "@angular/common";
import {MatAnchor, MatIconButton} from "@angular/material/button";

@Component({
  selector: 'app-doctor-answer-page-nav',
  templateUrl: './doctor-answer-page-nav.component.html',
  styleUrls: ['./doctor-answer-page-nav.component.css'],
  standalone: true,
  imports: [
    DoctorAnswerPageDashboardComponent,
    MatToolbar,
    MatNavList,
    MatSidenavContent,
    MatSidenavContainer,
    MatToolbar,
    MatSidenav,
    MatIcon,
    NgIf,
    MatIconButton,
    MatListItem,
    MatListItem,
    RouterLink,
    MatAnchor,
    RouterLink,
    AsyncPipe
  ]
})
export class DoctorAnswerPageNavComponent implements OnInit {

  @Input()
  answerId: number | undefined;
  @Input({transform: numberAttribute})
  doctorId: number | undefined;
  @Input()
  token: string | undefined | null;
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
    this.LogoutDispatch(this.doctorId!);
    this.router.navigate(['login']);
  }
  LogoutDispatch(userid: number) {
    this.store$.dispatch(new UserLogoutAction({userid}))
  }

}
