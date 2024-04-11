import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
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
import {LearnServiceService} from "../../../../service/learn-service.service";
import {select, Store} from "@ngrx/store";
import {selectToken, selectUserId} from "../../../../store/user.selectors";
import {UserState} from "../../../../store/user.reducer";

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

  constructor(private breakpointObserver: BreakpointObserver, private store$: Store<UserState>) {
    this.userId = this.store$.pipe(select(selectUserId));
    this.token = this.store$.pipe(select(selectToken));
  }

  userId: Observable<number | undefined> | undefined;
  token: Observable<string> | undefined;

  ngOnInit(): void {
  }

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  @Input() service: LearnServiceService | undefined;


  @Output() changeStepEvent = new EventEmitter<boolean>;

  changeStep(newValue: boolean) {
    this.changeStepEvent.emit(newValue);
  }

}
