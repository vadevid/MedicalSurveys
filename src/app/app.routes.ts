import {Routes} from "@angular/router";
import {RegisterComponent} from "./register/register.component";
import {LoginComponent} from "./login/login.component";
import {ClientPageComponent} from "./patient/client-page/client-page.component";
import {CardPageComponent} from "./patient/card-page/card-page.component";
import {ContactingDoctorComponent} from "./patient/contacting-doctor/contacting-doctor.component";
import {DoctorContactingComponent} from "./doctor/doctor-contacting/doctor-contacting.component";
import {DoctorAnswerPageComponent} from "./doctor/doctor-contacting/doctor-answer-page/doctor-answer-page.component";
import {
  ContactingDoctorPageComponent
} from "./patient/contacting-doctor/contacting-doctor-page/contacting-doctor-page.component";
import {DoctorPageComponent} from "./doctor/doctor-page/doctor-page.component";
import {DoctorCardPageComponent} from "./doctor/doctor-card-page/doctor-card-page.component";
import {MessagePageComponent} from "./patient/message-page/message-page.component";

export const routes: Routes = [
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
  },
  {
    path: 'messagespage',
    component: MessagePageComponent
  }
];
