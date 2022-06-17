import {Component, Inject, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {map, shareReplay} from "rxjs/operators";
import {Router} from "@angular/router";

@Component({
  selector: 'app-card-page-nav',
  templateUrl: './card-page-nav.component.html',
  styleUrls: ['./card-page-nav.component.css']
})
export class CardPageNavComponent implements OnInit {

  @Input()
  id: number;
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
    if (this.id == 0) {
      this.router.navigate(['/login']);
    }
  }

}
