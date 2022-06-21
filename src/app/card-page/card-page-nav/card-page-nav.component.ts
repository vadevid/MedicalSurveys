import {Component, Inject, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";
import {Router} from "@angular/router";
import {ProfileDialogComponent} from "../../profile-dialog/profile-dialog.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-card-page-nav',
  templateUrl: './card-page-nav.component.html',
  styleUrls: ['./card-page-nav.component.css']
})
export class CardPageNavComponent implements OnInit {

  @Input()
  cardid: number;
  @Input()
  userId: number;
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
  openProfileDialog() {
    this.dialog.open(ProfileDialogComponent, {
      width: '800px',
      data: {
        userId: this.userId
      }
    })
  }

}
