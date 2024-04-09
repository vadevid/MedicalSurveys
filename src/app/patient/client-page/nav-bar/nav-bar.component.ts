import {Component, EventEmitter, Inject, Input, numberAttribute, OnInit} from '@angular/core';
import {BreakpointObserver, Breakpoints} from '@angular/cdk/layout';
import {Observable} from 'rxjs';
import {map, shareReplay} from 'rxjs/operators';
import {MatDialog} from "@angular/material/dialog";
import {ProfileDialogComponent} from "../../profile-dialog/profile-dialog.component";
import {Router, RouterLink} from "@angular/router";
import {DashboardClientComponent} from "../dashboard-client/dashboard-client.component";
import {MatIcon} from "@angular/material/icon";
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from "@angular/material/sidenav";
import {MatToolbar} from "@angular/material/toolbar";
import {MatListItem, MatNavList} from "@angular/material/list";
import {AsyncPipe, NgIf} from "@angular/common";
import {MatButton, MatIconButton} from "@angular/material/button";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css'],
  standalone: true,
  imports: [
    DashboardClientComponent,
    MatIcon,
    MatSidenavContainer,
    MatToolbar,
    MatToolbar,
    MatSidenav,
    MatSidenavContent,
    MatNavList,
    NgIf,
    MatListItem,
    RouterLink,
    MatButton,
    MatIconButton,
    AsyncPipe,
    AsyncPipe
  ]
})
export class NavBarComponent implements OnInit {

  @Input({transform: numberAttribute})
  userid: number | undefined;
  @Input()
  token$: Observable<string | undefined> | undefined;
  token: string | undefined;

  logoutEmmit = new EventEmitter<number>();

  dialog: MatDialog;
  router: Router;
  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver, @Inject(MatDialog) private matDialog: MatDialog, @Inject(Router) router: Router) {
    this.dialog = matDialog;
    this.router = router;
  }

  ngOnInit() {
    if (this.userid == 0) {
      this.router.navigate(['/login']);
    }
    this.token$!.subscribe(value => this.token = value)
    console.log(this.token)
  }

  openProfileDialog() {
    this.dialog.open(ProfileDialogComponent, {
      width: '800px',
      data: {
        userId: this.userid,
        token: this.token
      }
    })
  }
}
