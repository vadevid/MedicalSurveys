import {Component, EventEmitter, Input, Output} from '@angular/core';
import {AsyncPipe, NgIf} from "@angular/common";
import {
    ContactingDashboardComponent
} from "../../../contacting-doctor/contacting-dashboard/contacting-dashboard.component";
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";
import {MatListItem, MatNavList} from "@angular/material/list";
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from "@angular/material/sidenav";
import {MatToolbar} from "@angular/material/toolbar";
import {RouterLink} from "@angular/router";
import {Observable} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";
import {
  LearnContactingSecondDashboardComponent
} from "./learn-contacting-second-dashboard/learn-contacting-second-dashboard.component";
import {
  ContactingDoctorDashboardComponent
} from "../../../contacting-doctor/contacting-doctor-page/contacting-doctor-dashboard/contacting-doctor-dashboard.component";
import {LearnServiceService} from "../../../../service/learn-service.service";

@Component({
  selector: 'app-learn-contacting-second-nav',
  standalone: true,
  imports: [
    AsyncPipe,
    ContactingDashboardComponent,
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
    LearnContactingSecondDashboardComponent,
    ContactingDoctorDashboardComponent
  ],
  templateUrl: './learn-contacting-second-nav.component.html',
  styleUrl: './learn-contacting-second-nav.component.css'
})
export class LearnContactingSecondNavComponent {

  constructor(private breakpointObserver: BreakpointObserver) { }

  @Input() service: LearnServiceService | undefined;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

}
