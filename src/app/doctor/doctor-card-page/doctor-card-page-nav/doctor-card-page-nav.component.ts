import {Component, Inject, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {MatDialog} from "@angular/material/dialog";
import {Observable} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";

@Component({
  selector: 'app-doctor-card-page-nav',
  templateUrl: './doctor-card-page-nav.component.html',
  styleUrls: ['./doctor-card-page-nav.component.css']
})
export class DoctorCardPageNavComponent implements OnInit {
  @Input()
  cardid: number;
  @Input()
  userId: number;
  @Input()
  token: String;
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
