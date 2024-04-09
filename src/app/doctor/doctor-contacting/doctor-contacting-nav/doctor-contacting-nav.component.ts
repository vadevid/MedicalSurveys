import {Component, EventEmitter, Inject, Input, numberAttribute, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";
import {Store} from "@ngrx/store";
import {UserState} from "../../../store/user.reducer";
import {Router, RouterLink} from "@angular/router";
import {DoctorContactingInfoComponent} from "../doctor-contacting-info/doctor-contacting-info.component";
import {MatIcon} from "@angular/material/icon";
import {MatToolbar} from "@angular/material/toolbar";
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from "@angular/material/sidenav";
import {MatListItem, MatNavList} from "@angular/material/list";
import {AsyncPipe, NgIf} from "@angular/common";
import {MatAnchor, MatIconButton} from "@angular/material/button";
import {logout} from "../../../store/user.actions";

@Component({
  selector: 'app-doctor-contacting-nav',
  templateUrl: './doctor-contacting-nav.component.html',
  styleUrls: ['./doctor-contacting-nav.component.css'],
  standalone: true,
  imports: [
    DoctorContactingInfoComponent,
    MatIcon,
    MatToolbar,
    MatToolbar,
    MatSidenavContent,
    MatSidenavContainer,
    MatSidenav,
    MatNavList,
    NgIf,
    RouterLink,
    MatListItem,
    MatListItem,
    RouterLink,
    MatIconButton,
    MatAnchor,
    AsyncPipe,
    AsyncPipe,
    AsyncPipe
  ]
})
export class DoctorContactingNavComponent implements OnInit {
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
    this.store$.dispatch(logout({userid}))
  }
  ngOnInit(): void {
  }
}
