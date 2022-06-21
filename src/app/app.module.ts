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
import {MatNativeDateModule} from "@angular/material/core";
import {FormsModule} from '@angular/forms';
import {Router, RouterModule, Routes} from "@angular/router";
import { StoreModule } from '@ngrx/store';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
import { environment } from '../environments/environment';
import { EffectsModule } from '@ngrx/effects';
import { StoreRouterConnectingModule } from '@ngrx/router-store';
import {AppEffects} from "./app.effects";
import { ClientPageComponent } from './client-page/client-page.component';
import {
  AvatarModule,
  BadgeModule,
  BreadcrumbModule,
  DropdownModule,
  GridModule,
  HeaderModule,
  NavModule
} from "@coreui/angular";
import { DashboardClientComponent } from './dashboard-client/dashboard-client.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { LayoutModule } from '@angular/cdk/layout';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import {MatButtonToggleModule} from "@angular/material/button-toggle";
import {IconModule} from "@coreui/icons-angular";
import { ProfileDialogComponent } from './profile-dialog/profile-dialog.component';
import {MatDialog, MatDialogModule} from "@angular/material/dialog";
import {MatPaginatorModule} from "@angular/material/paginator";
import { CardPageComponent } from './card-page/card-page.component';
import { CardPageNavComponent } from './card-page/card-page-nav/card-page-nav.component';
import { CardPageInfoComponent } from './card-page/card-page-info/card-page-info.component';
import {MatTabsModule} from "@angular/material/tabs";
import { CardPageTableComponent } from './card-page/card-page-table/card-page-table.component';
import { CardPageGraphComponent } from './card-page/card-page-graph/card-page-graph.component';
import {USER_REDUCER_NODE, userReducer} from "./store/user.reducer";
import {MatTableModule} from "@angular/material/table";
import {GoogleChartsModule} from "angular-google-charts";

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
    ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule{
}
