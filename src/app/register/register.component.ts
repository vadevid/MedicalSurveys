import { Component, OnInit } from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public href: string = "";
  constructor() {
  }

  ngOnInit(): void {
    this.href = location.host.substring(0, 0);
  }


}
