import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-card-page-info',
  templateUrl: './card-page-info.component.html',
  styleUrls: ['./card-page-info.component.css']
})
export class CardPageInfoComponent implements OnInit {
  @Input()
  id: number;
  show: boolean = true;
  constructor() { }

  ngOnInit(): void {

  }

}
