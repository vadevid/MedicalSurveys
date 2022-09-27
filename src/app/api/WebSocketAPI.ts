import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client'
import {AppComponent} from '../app.component'

export class WebSocketAPI {
  webSocketEndPoint: string = 'http://localhost:8081/ws';
  topic: string = "/topic/greetings";
  stompClient: any;
  appComponent: AppComponent;
  constructor(appComponent: AppComponent) {
    this.appComponent = appComponent;
  }

  _connect() {
    console.log("Initialize WebSocket Connection");
    let ws = new SockJS(this.webSocketEndPoint);
    this.stompClient.connect({}, (frame: any) => {
      this.stompClient.subscribe(this.topic, (sdkEvent: any) => {
        this.onMessageReceived(sdkEvent);
      });
      this.stompClient.reconect_delay = 2000;
    }, this.errorCallBack);
  };

  _disconnect() {
    if (this.stompClient !== null) {
      this.stompClient.disconect();
    };
    console.log("Disconnected");
  };

  errorCallBack(error: any) {
    console.log("errorCallBack -> " + error)
    setTimeout(() => {
      this._connect();
    }, 5000)
  }

  /**
   * Send message to sever via web socket
   * @param {*} message
   */
  _send(message: any) {
    console.log("calling logout api via web socket");
    this.stompClient.send("/app/hello", {}, JSON.stringify(message));
  }

  onMessageReceived(message: any) {
    console.log("Message Recieved from Server :: " + message);
    this.appComponent.handleMessage(JSON.stringify(message.body));
  }

}
