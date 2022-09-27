import {NgModule, OnInit} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './login/login.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatIconModule} from "@angular/material/icon";
import {MatSelectModule} from "@angular/material/select";
import {MatInputModule} from "@angular/material/input";
import { RegisterComponent } from './register/register.component';
import {MatButtonModule} from "@angular/material/button";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {ReactiveFormsModule} from "@angular/forms";
import {MAT_DATE_FORMATS, MatNativeDateModule} from "@angular/material/core";
import {FormsModule} from '@angular/forms';
import {Router, RouterModule, Routes} from "@angular/router";
import { StoreModule } from '@ngrx/store';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
import { environment } from '../environments/environment';
import { EffectsModule } from '@ngrx/effects';
import { StoreRouterConnectingModule } from '@ngrx/router-store';
import {AppEffects} from "./app.effects";
import { ClientPageComponent } from './patient/client-page/client-page.component';
import {
  AvatarModule,
  BadgeModule,
  BreadcrumbModule,
  DropdownModule,
  GridModule,
  HeaderModule,
  NavModule
} from "@coreui/angular";
import { DashboardClientComponent } from './patient/client-page/dashboard-client/dashboard-client.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { LayoutModule } from '@angular/cdk/layout';
import { NavBarComponent } from './patient/client-page/nav-bar/nav-bar.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import {MatButtonToggleModule} from "@angular/material/button-toggle";
import {IconModule} from "@coreui/icons-angular";
import { ProfileDialogComponent } from './patient/profile-dialog/profile-dialog.component';
import {MatDialog, MatDialogModule} from "@angular/material/dialog";
import {MatPaginatorModule} from "@angular/material/paginator";
import { CardPageComponent } from './patient/card-page/card-page.component';
import { CardPageNavComponent } from './patient/card-page/card-page-nav/card-page-nav.component';
import { CardPageInfoComponent } from './patient/card-page/card-page-info/card-page-info.component';
import {MatTabsModule} from "@angular/material/tabs";
import { CardPageTableComponent } from './patient/card-page/card-page-table/card-page-table.component';
import { CardPageGraphComponent } from './patient/card-page/card-page-graph/card-page-graph.component';
import {USER_REDUCER_NODE, userReducer} from "./store/user.reducer";
import {MatTableModule} from "@angular/material/table";
import {GoogleChartsModule} from "angular-google-charts";
import {MatSlideToggleModule} from "@angular/material/slide-toggle";
import {MY_DATE_FORMATS} from "./model/my-date-format";
import {MatRadioModule} from "@angular/material/radio";
import { ContactingDoctorComponent } from './patient/contacting-doctor/contacting-doctor.component';
import { ContactingNavComponent } from './patient/contacting-doctor/contacting-nav/contacting-nav.component';
import { ContactingDashboardComponent } from './patient/contacting-doctor/contacting-dashboard/contacting-dashboard.component';
import { ContactingDoctorPageComponent } from './patient/contacting-doctor/contacting-doctor-page/contacting-doctor-page.component';
import { ContactingDoctorPageNavComponent } from './patient/contacting-doctor/contacting-doctor-page/contacting-doctor-page-nav/contacting-doctor-page-nav.component';
import { ContactingDoctorDashboardComponent } from './patient/contacting-doctor/contacting-doctor-page/contacting-doctor-dashboard/contacting-doctor-dashboard.component';
import { DoctorPageComponent } from './doctor/doctor-page/doctor-page.component';
import { DoctorPageNavComponent } from './doctor/doctor-page/doctor-page-nav/doctor-page-nav.component';
import { DoctorPageDashboardComponent } from './doctor/doctor-page/doctor-page-dashboard/doctor-page-dashboard.component';
import { DoctorCardPageComponent } from './doctor/doctor-card-page/doctor-card-page.component';
import { DoctorCardPageNavComponent } from './doctor/doctor-card-page/doctor-card-page-nav/doctor-card-page-nav.component';
import { DoctorCardPageInfoComponent } from './doctor/doctor-card-page/doctor-card-page-info/doctor-card-page-info.component';
import { DoctorContactingComponent } from './doctor/doctor-contacting/doctor-contacting.component';
import { DoctorContactingNavComponent } from './doctor/doctor-contacting/doctor-contacting-nav/doctor-contacting-nav.component';
import { DoctorContactingInfoComponent } from './doctor/doctor-contacting/doctor-contacting-info/doctor-contacting-info.component';
import { DoctorAnswerPageComponent } from './doctor/doctor-contacting/doctor-answer-page/doctor-answer-page.component';
import { DoctorAnswerPageNavComponent } from './doctor/doctor-contacting/doctor-answer-page/doctor-answer-page-nav/doctor-answer-page-nav.component';
import { DoctorAnswerPageDashboardComponent } from './doctor/doctor-contacting/doctor-answer-page/doctor-answer-page-dashboard/doctor-answer-page-dashboard.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'clientpage',
    component: ClientPageComponent
  },
  {
    path: 'cardpage',
    component: CardPageComponent
  },
  {
    path: 'contactingdoctor',
    component: ContactingDoctorComponent
  },
  {
    path: 'doctorcontact',
    component: DoctorContactingComponent
  },
  {
    path: 'doctoranswer',
    component: DoctorAnswerPageComponent
  },
  {
    path: 'contactingdoctorpage',
    component: ContactingDoctorPageComponent
  },
  {
    path: 'doctorpage',
    component: DoctorPageComponent
  },
  {
    path: 'doctorcardpage',
    component: DoctorCardPageComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ClientPageComponent,
    DashboardClientComponent,
    NavBarComponent,
    ProfileDialogComponent,
    CardPageComponent,
    CardPageNavComponent,
    CardPageInfoComponent,
    CardPageTableComponent,
    CardPageGraphComponent,
    ContactingDoctorComponent,
    ContactingNavComponent,
    ContactingDashboardComponent,
    ContactingDoctorPageComponent,
    ContactingDoctorPageNavComponent,
    ContactingDoctorDashboardComponent,
    DoctorPageComponent,
    DoctorPageNavComponent,
    DoctorPageDashboardComponent,
    DoctorCardPageComponent,
    DoctorCardPageNavComponent,
    DoctorCardPageInfoComponent,
    DoctorContactingComponent,
    DoctorContactingNavComponent,
    DoctorContactingInfoComponent,
    DoctorAnswerPageComponent,
    DoctorAnswerPageNavComponent,
    DoctorAnswerPageDashboardComponent,
  ],
  imports: [
    RouterModule.forRoot(routes, {useHash: true}),
    FormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatIconModule,
    MatSelectModule,
    MatInputModule,
    MatButtonModule,
    MatDatepickerModule,
    MatDialogModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    StoreModule.forRoot({}, {
      runtimeChecks: {
        strictStateImmutability: true,
        strictActionImmutability: true
      }
    }),
    StoreModule.forFeature(USER_REDUCER_NODE, userReducer),
    StoreDevtoolsModule.instrument({maxAge: 25, logOnly: environment.production}),
    GridModule,
    HeaderModule,
    NavModule,
    BreadcrumbModule,
    DropdownModule,
    AvatarModule,
    BadgeModule,
    MatGridListModule,
    MatCardModule,
    MatMenuModule,
    LayoutModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatButtonToggleModule,
    IconModule,
    MatPaginatorModule,
    MatTabsModule,
    MatTableModule,
    GoogleChartsModule,
    MatSlideToggleModule,
    MatRadioModule
  ],
  providers: [
    {provide: MAT_DATE_FORMATS, useValue: MY_DATE_FORMATS}
  ],
  bootstrap: [AppComponent]
})
export class AppModule{
}
