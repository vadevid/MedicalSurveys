import {Component} from '@angular/core';
import {RouterOutlet} from "@angular/router";
import {LearnComponent} from "./patient/learn/learn.component";
import {LoginComponent} from "./login/login.component";
import {StoreModule} from "@ngrx/store";
import {userReducer} from "./store/user.reducer";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: 'app.component.css',
  standalone: true,
  imports: [
    RouterOutlet,
    LoginComponent,
    StoreModule.forRoot({})
  ]
})
export class AppComponent {
  title = 'Дневник здоровья'

}
