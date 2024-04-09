import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from "@angular/material/sidenav";
import {MatToolbar} from "@angular/material/toolbar";
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";
import {LearnContactingDashboardComponent} from "./learn-contacting-dashboard/learn-contacting-dashboard.component";
import {MatListItem, MatNavList} from "@angular/material/list";
import {AsyncPipe, NgIf} from "@angular/common";

@Component({
  selector: 'app-learn-contacting-nav',
  templateUrl: './learn-contacting-nav.component.html',
  styleUrls: ['./learn-contacting-nav.component.css'],
  standalone: true,
  imports: [
    MatSidenavContainer,
    MatToolbar,
    MatIconButton,
    MatIcon,
    MatButton,
    LearnContactingDashboardComponent,
    MatNavList,
    MatSidenav,
    MatListItem,
    AsyncPipe,
    MatSidenavContent,
    NgIf
  ]
})
export class LearnContactingNavComponent implements OnInit {

  constructor(private breakpointObserver: BreakpointObserver) { }

  ngOnInit(): void {
  }

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

}
