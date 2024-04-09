import {AfterViewInit, Component, Input} from '@angular/core';
import {MatAnchor, MatButton} from "@angular/material/button";
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {MatGridList, MatGridTile} from "@angular/material/grid-list";
import {MatPaginator} from "@angular/material/paginator";
import {NgForOf} from "@angular/common";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {FormsModule} from "@angular/forms";
import {LearnServiceService} from "../../../../../service/learn-service.service";

@Component({
  selector: 'app-learn-contacting-second-dashboard',
  standalone: true,
  imports: [
    MatAnchor,
    MatCard,
    MatCardContent,
    MatCardHeader,
    MatCardTitle,
    MatGridList,
    MatGridTile,
    MatPaginator,
    NgForOf,
    MatButton,
    MatFormField,
    MatInput,
    MatLabel,
    FormsModule
  ],
  templateUrl: './learn-contacting-second-dashboard.component.html',
  styleUrl: './learn-contacting-second-dashboard.component.css'
})
export class LearnContactingSecondDashboardComponent implements AfterViewInit {

  textValue = "У меня болит голова"
  @Input() service: LearnServiceService | undefined;

  ngAfterViewInit(): void {
    this.service?.steps.refresh(true);
    this.service?.steps.nextStep();
  }
}
