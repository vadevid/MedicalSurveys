import {Component, EventEmitter, Inject, Input, Output} from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import {MatDialog} from "@angular/material/dialog";
import {ProfileDialogComponent} from "../profile-dialog/profile-dialog.component";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {

  @Input()
  userid: number;

  @Output()
  logoutEmmit = new EventEmitter<number>();

  dialog: MatDialog;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver, @Inject(MatDialog) private matDialog: MatDialog) {
    this.dialog = matDialog;
  }
  openProfileDialog() {
    this.dialog.open(ProfileDialogComponent, {
      width: '800px',
      data: {
        userId: this.userid
      }
    })
  }
}
