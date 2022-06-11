import {Component, Inject, Injectable, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {StoreRouterConfig} from "@ngrx/router-store";

@Component({
  selector: 'app-login',
  templateUrl:  './login.component.html',
  styleUrls: ['./login.component.css']
})
@Injectable({providedIn: 'root'})
export class LoginComponent implements OnInit {
  login: string;
  pass: string;
  activate: boolean = false;
  routing: Router;
  route: ActivatedRoute;

  constructor(@Inject(Router) router: Router, @Inject(ActivatedRoute) route: ActivatedRoute) {
    this.routing = router;
    this.route = route;
    this.login = this.route.snapshot.paramMap.get('login');
  }

  LoginBtn() {
    this.routing.navigate(['clientpage'])
  }

  ngOnInit() {
  }
}
