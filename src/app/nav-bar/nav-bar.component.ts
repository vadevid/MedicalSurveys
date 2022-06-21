import {Component, EventEmitter, Inject, Input, OnInit, Output} from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import {MatDialog} from "@angular/material/dialog";
import {ProfileDialogComponent} from "../profile-dialog/profile-dialog.component";
import {Router} from "@angular/router";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit{

  @Input()
  userid: number;
  @Input()
  token: string;

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

  ngOnInit(){
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
