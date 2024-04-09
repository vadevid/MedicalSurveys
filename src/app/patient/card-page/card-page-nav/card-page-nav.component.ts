import {Component, Inject, Input, numberAttribute, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";
import {Router, RouterLink} from "@angular/router";
import {ProfileDialogComponent} from "../../profile-dialog/profile-dialog.component";
import {MatDialog} from "@angular/material/dialog";
import {CardPageInfoComponent} from "../card-page-info/card-page-info.component";
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from "@angular/material/sidenav";
import {MatIcon} from "@angular/material/icon";
import {MatListItem, MatNavList} from "@angular/material/list";
import {MatToolbar} from "@angular/material/toolbar";
import {AsyncPipe, NgIf} from "@angular/common";
import {MatIconButton} from "@angular/material/button";

@Component({
  selector: 'app-card-page-nav',
  templateUrl: './card-page-nav.component.html',
  styleUrls: ['./card-page-nav.component.css'],
  standalone: true,
  imports: [
    CardPageInfoComponent,
    MatSidenav,
    MatIcon,
    MatNavList,
    MatToolbar,
    MatSidenavContent,
    MatSidenavContainer,
    NgIf,
    RouterLink,
    MatIconButton,
    MatListItem,
    MatListItem,
    AsyncPipe,
    AsyncPipe,
    AsyncPipe
  ]
})
export class CardPageNavComponent implements OnInit {

  @Input()
  cardid: number | undefined;
  @Input({transform: numberAttribute})
  userId: number | undefined;
  @Input()
  token: string | undefined | null;
  router: Router;
  dialog: MatDialog;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver, @Inject(Router) router: Router, @Inject(MatDialog) private matDialog: MatDialog) {
    this.router = router;
    this.dialog = matDialog;
  }

  ngOnInit(): void {
    if (this.userId == 0) {
      this.router.navigate(['/login']);
    }
  }

}
