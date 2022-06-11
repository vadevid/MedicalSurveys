import {Component, Inject, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {data} from "autoprefixer";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  router: Router;
  route: ActivatedRoute;
  login: string;
  pass: string;
  constructor(@Inject(Router) router: Router, @Inject(ActivatedRoute) route: ActivatedRoute) {
    this.router = router;
    this.route = route;
  }

  RegisterBtn() {
    if (this.login != null && this.pass != null) this.router.navigate(['login', {login : this.login}])
  }

  ngOnInit(): void {
  }
}
