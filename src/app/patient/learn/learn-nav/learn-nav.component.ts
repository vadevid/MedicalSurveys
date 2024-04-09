import {Component, EventEmitter, Inject, Input, numberAttribute, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {Router, RouterLink} from "@angular/router";
import {Observable} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";
import {ProfileDialogComponent} from "../../profile-dialog/profile-dialog.component";
import {MatListItem, MatNavList} from "@angular/material/list";
import {MatToolbar} from "@angular/material/toolbar";
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from "@angular/material/sidenav";
import {MatIcon} from "@angular/material/icon";
import {AsyncPipe, NgIf} from "@angular/common";
import {MatButton, MatIconButton} from "@angular/material/button";
import {LearnDashboardComponent} from "../learn-dashboard/learn-dashboard.component";

@Component({
  selector: 'app-learn-nav',
  templateUrl: './learn-nav.component.html',
  styleUrls: ['./learn-nav.component.css'],
  standalone: true,
  imports: [
    MatNavList,
    MatToolbar,
    MatListItem,
    RouterLink,
    MatSidenav,
    MatIcon,
    AsyncPipe,
    MatButton,
    MatSidenavContainer,
    MatIconButton,
    LearnDashboardComponent,
    NgIf,
    MatSidenavContent
  ]
})
export class LearnNavComponent implements OnInit {

  @Input({transform: numberAttribute})
  userid: number | undefined;
  @Input()
  token: string | undefined | null = "";

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

  ngOnInit(): void {
    if (this.userid == 0) {
      this.router.navigate(['/login']);
    }
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
