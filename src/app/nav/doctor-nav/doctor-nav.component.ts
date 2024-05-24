import {Component, EventEmitter, Inject, Input, OnInit, TemplateRef} from '@angular/core';
import {AsyncPipe, NgIf, NgTemplateOutlet} from "@angular/common";
import {
    DoctorPageDashboardComponent
} from "../../doctor/doctor-page/doctor-page-dashboard/doctor-page-dashboard.component";
import {MatAnchor, MatIconButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";
import {MatListItem, MatNavList} from "@angular/material/list";
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from "@angular/material/sidenav";
import {MatToolbar} from "@angular/material/toolbar";
import {Router, RouterLink} from "@angular/router";
import {Observable} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";
import {Store} from "@ngrx/store";
import {UserState} from "../../store/user.reducer";
import {logout} from "../../store/user.actions";

@Component({
  selector: 'app-doctor-nav',
  standalone: true,
  imports: [
    AsyncPipe,
    DoctorPageDashboardComponent,
    MatAnchor,
    MatIcon,
    MatIconButton,
    MatListItem,
    MatNavList,
    MatSidenav,
    MatSidenavContainer,
    MatSidenavContent,
    MatToolbar,
    NgIf,
    RouterLink,
    NgTemplateOutlet
  ],
  templateUrl: './doctor-nav.component.html',
  styleUrl: './doctor-nav.component.css'
})
export class DoctorNavComponent implements OnInit {
  @Input()
  data: any;
  @Input()
  content: TemplateRef<any> | null = null;
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
    this.logoutEmmit.emit(this.data.userId);
    this.LogoutDispatch(this.data.userId!);
    this.router.navigate(['login']);
  }
  LogoutDispatch(userid: number) {
    this.store$.dispatch(logout({userid}))
  }
  ngOnInit() {
    if (this.data.userId == 0) {
      this.router.navigate(['/login']);
    }
  }
}
