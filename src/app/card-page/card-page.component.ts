import {Component, Inject, OnInit, Output} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {UserSyncStorageService} from "../service/user-sync-storage.service";

@Component({
  selector: 'app-card-page',
  templateUrl: './card-page.component.html',
  styleUrls: ['./card-page.component.css']
})
export class CardPageComponent implements OnInit {
  routing: Router;
  route: ActivatedRoute;
  id: number;

  constructor(@Inject(Router) router: Router,
              @Inject(ActivatedRoute) route: ActivatedRoute,
              private userSyncStorage: UserSyncStorageService) {
    this.routing = router;
    this.route = route;
    this.id = +this.route.snapshot.paramMap.get('id');
  }

  ngOnInit(): void {
    this.userSyncStorage.init();
  }

}
