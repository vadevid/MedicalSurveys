import {Component, EventEmitter, Inject, Input, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";
import {ProfileDialogComponent} from "../../profile-dialog/profile-dialog.component";

@Component({
  selector: 'app-contacting-nav',
  templateUrl: './contacting-nav.component.html',
  styleUrls: ['./contacting-nav.component.css']
})
export class ContactingNavComponent implements OnInit {
  @Input()
  token: String;
  @Input()
  userId: number;

  logoutEmmit = new EventEmitter<number>();

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

  ngOnInit(): void {
    if (this.userId == 0) {
      this.router.navigate(['/login']);
    }
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
}
