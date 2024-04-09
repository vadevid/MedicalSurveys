import {Component, Inject, Input, numberAttribute, OnInit} from '@angular/core';
import {Router, RouterLink} from "@angular/router";
import {MatDialog} from "@angular/material/dialog";
import {Observable} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";
import {DoctorCardPageInfoComponent} from "../doctor-card-page-info/doctor-card-page-info.component";
import {MatToolbar} from "@angular/material/toolbar";
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from "@angular/material/sidenav";
import {MatListItem, MatNavList} from "@angular/material/list";
import {MatIcon} from "@angular/material/icon";
import {AsyncPipe, NgIf} from "@angular/common";
import {MatIconButton} from "@angular/material/button";

@Component({
  selector: 'app-doctor-card-page-nav',
  templateUrl: './doctor-card-page-nav.component.html',
  styleUrls: ['./doctor-card-page-nav.component.css'],
  standalone: true,
  imports: [
    DoctorCardPageInfoComponent,
    MatToolbar,
    MatSidenavContainer,
    MatSidenavContent,
    MatNavList,
    MatSidenav,
    MatToolbar,
    MatIcon,
    NgIf,
    RouterLink,
    RouterLink,
    MatListItem,
    MatIconButton,
    AsyncPipe,
    AsyncPipe
  ]
})
export class DoctorCardPageNavComponent implements OnInit {
  @Input()
  cardid: number | undefined;
  @Input({transform: numberAttribute})
  userId: number | undefined;
  @Input()
  token: string | undefined | null;
  router: Router;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver, @Inject(Router) router: Router) {
    this.router = router;
  }

  ngOnInit(): void {
  }

}
