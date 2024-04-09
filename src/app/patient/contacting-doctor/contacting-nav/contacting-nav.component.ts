import {Component, EventEmitter, Inject, Input, numberAttribute, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {Router, RouterLink} from "@angular/router";
import {Observable} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";
import {ProfileDialogComponent} from "../../profile-dialog/profile-dialog.component";
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from "@angular/material/sidenav";
import {ContactingDashboardComponent} from "../contacting-dashboard/contacting-dashboard.component";
import {MatToolbar} from "@angular/material/toolbar";
import {MatListItem, MatNavList} from "@angular/material/list";
import {MatIcon} from "@angular/material/icon";
import {AsyncPipe, NgIf} from "@angular/common";
import {MatButton, MatIconButton} from "@angular/material/button";

@Component({
  selector: 'app-contacting-nav',
  templateUrl: './contacting-nav.component.html',
  styleUrls: ['./contacting-nav.component.css'],
  standalone: true,
  imports: [
    MatSidenavContainer,
    ContactingDashboardComponent,
    MatToolbar,
    MatNavList,
    MatIcon,
    NgIf,
    MatListItem,
    MatSidenav,
    MatIconButton,
    MatButton,
    RouterLink,
    AsyncPipe,
    MatSidenavContent
  ]
})
export class ContactingNavComponent implements OnInit {
  @Input()
  token: string | undefined | null;
  @Input({transform: numberAttribute})
  userId: number | undefined;

  logoutEmmit = new EventEmitter<number>();

  dialog: MatDialog;
  router: Router;
  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );
  constructor(private breakpointObserver: BreakpointObserver, @Inject(MatDialog) private matDialog: MatDialog, @Inject(Router) router: Router) {
    this.router = router;
    this.dialog = matDialog;
  }

  ngOnInit(): void {
    if (this.userId == 0) {
      this.router.navigate(['/login']);
    }
  }

  openProfileDialog() {
    this.dialog.open(ProfileDialogComponent, {
      width: '800px',
      data: {
        userId: this.userId,
        token: this.token
      }
    })
  }
}
