import {Component, Inject, Input, numberAttribute, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {Router, RouterLink} from "@angular/router";
import {Observable} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";
import {ProfileDialogComponent} from "../../../profile-dialog/profile-dialog.component";
import {ContactingDoctorDashboardComponent} from "../contacting-doctor-dashboard/contacting-doctor-dashboard.component";
import {MatListItem, MatNavList} from "@angular/material/list";
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from "@angular/material/sidenav";
import {MatToolbar} from "@angular/material/toolbar";
import {MatIcon} from "@angular/material/icon";
import {AsyncPipe, NgIf} from "@angular/common";
import {MatButton, MatIconButton} from "@angular/material/button";

@Component({
  selector: 'app-contacting-doctor-page-nav',
  templateUrl: './contacting-doctor-page-nav.component.html',
  styleUrls: ['./contacting-doctor-page-nav.component.css'],
  standalone: true,
  imports: [
    ContactingDoctorDashboardComponent,
    MatNavList,
    MatSidenavContainer,
    MatToolbar,
    MatIcon,
    MatSidenavContent,
    MatSidenav,
    NgIf,
    MatIconButton,
    MatListItem,
    MatListItem,
    RouterLink,
    RouterLink,
    MatButton,
    AsyncPipe,
    AsyncPipe,
    AsyncPipe,
    AsyncPipe
  ]
})
export class ContactingDoctorPageNavComponent implements OnInit {
  @Input()
  token: string | undefined | null;
  @Input({transform: numberAttribute})
  userId: number | undefined;
  @Input()
  doctorId: number | undefined;
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
  openProfileDialog() {
    this.dialog.open(ProfileDialogComponent, {
      width: '800px',
      data: {
        userId: this.userId,
        token: this.token
      }
    })
  }

  ngOnInit(): void {
  }

}
