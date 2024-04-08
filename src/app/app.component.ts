import {Component} from '@angular/core';
import {Store} from "@ngrx/store";
import {UserState} from "./store/user.reducer";
import {UserLoginAction} from "./store/user.actions";
import {WebSocketAPI} from "./api/WebSocketAPI";

@Component({
  selector: 'my-app',
  template: `<router-outlet></router-outlet>`
})
export class AppComponent {
  title: 'Дневник здоровья'

  // webSocketAPI: WebSocketAPI;
  greeting: any;
  name: string;

  ngOnInit() {
    // this.webSocketAPI = new WebSocketAPI(this);
  }

  constructor(
    private store$: Store<UserState>,
  ) {
  }
  // connect(){
  //   this.webSocketAPI._connect();
  // }
  //
  // disconnect(){
  //   this.webSocketAPI._disconnect();
  // }
  //
  // sendMessage(){
  //   this.webSocketAPI._send(this.name);
  // }
  //
  handleMessage(message: any){
    this.greeting = message;
  }
}
