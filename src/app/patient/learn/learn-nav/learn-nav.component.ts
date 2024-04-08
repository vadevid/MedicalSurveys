import {Component, EventEmitter, Inject, Input, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";
import {ProfileDialogComponent} from "../../profile-dialog/profile-dialog.component";

@Component({
  selector: 'app-learn-nav',
  templateUrl: './learn-nav.component.html',
  styleUrls: ['./learn-nav.component.css']
})
export class LearnNavComponent implements OnInit {

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

  ngOnInit(): void {
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
