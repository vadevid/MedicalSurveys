import {Component, EventEmitter, Inject, Input, OnInit, TemplateRef} from '@angular/core';
import {AsyncPipe, NgIf, NgTemplateOutlet} from "@angular/common";
import {DashboardClientComponent} from "../../patient/client-page/dashboard-client/dashboard-client.component";
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";
import {MatListItem, MatNavList} from "@angular/material/list";
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from "@angular/material/sidenav";
import {MatToolbar} from "@angular/material/toolbar";
import {Router, RouterLink} from "@angular/router";
import {Observable} from "rxjs";
import {MatDialog} from "@angular/material/dialog";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";
import {ProfileDialogComponent} from "./profile-dialog/profile-dialog.component";
import axios from "axios";

@Component({
  selector: 'app-patient-nav',
  standalone: true,
  imports: [
    AsyncPipe,
    DashboardClientComponent,
    MatButton,
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
  templateUrl: './patient-nav.component.html',
  styleUrl: './patient-nav.component.css'
})
export class PatientNavComponent implements OnInit{
  @Input()
  content: TemplateRef<any> | null = null;
  @Input()
  data: any;

  newContext: any;

  newCards: boolean = false;

  newMessages: boolean = false;

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
    if (this.data.userId == 0) {
      this.router.navigate(['/login']);
    }
    this.checkNewCards()
    this.checkNewMessages()
  }

  openProfileDialog() {
    this.dialog.open(ProfileDialogComponent, {
      width: '800px',
      height: '507px',
      data: {
        userId: this.data.userId,
        token: this.data.token
      }
    })
  }

  async checkNewCards() {
    await axios.post("/api/patient/checkNewCard", {
      id: this.data.userId
    },
      {
        headers: {
          'Authorization': `Bearer ${this.data.token}`
        }
      }).then(res => this.newCards = res.data)
  }

  async checkNewMessages() {
    await axios.post("/api/patient/checkNewMessages", {
        id: this.data.userId
      },
      {
        headers: {
          'Authorization': `Bearer ${this.data.token}`
        }
      }).then(res => this.newMessages = res.data)
  }
}
