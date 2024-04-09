import {Component, Input, OnInit} from '@angular/core';
import {CardValues} from "../../../model/card-values";
import axios from "axios";
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell, MatHeaderCellDef,
  MatHeaderRow, MatHeaderRowDef,
  MatRow,
  MatRowDef,
  MatTable
} from "@angular/material/table";

@Component({
  selector: 'app-card-page-table',
  templateUrl: './card-page-table.component.html',
  styleUrls: ['./card-page-table.component.css'],
  standalone: true,
  imports: [
    MatRowDef,
    MatRow,
    MatCell,
    MatColumnDef,
    MatTable,
    MatColumnDef,
    MatHeaderCell,
    MatHeaderRow,
    MatTable,
    MatCell,
    MatHeaderCell,
    MatCellDef,
    MatHeaderRowDef,
    MatCellDef,
    MatHeaderCellDef,
    MatHeaderCellDef
  ]
})
export class CardPageTableComponent implements OnInit {
  @Input()
  cardid: number | undefined;
  @Input()
  token: string | undefined | null;

  dataSource : CardValues[] = [];
  displayedColumns: string[] = ['answer', 'answerDate']
  constructor() { }

  ngOnInit(): void {
    this.GetData();
  }

  async GetData() {
    await axios.post("http://localhost:8080/card/getallanswer", {
      id: this.cardid
    }, {
      headers: {
        'Authorization': `Bearer ${this.token}`
      }
    }).then((response) => {
        this.dataSource = response.data;
      }
    )
  }

}
