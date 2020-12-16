import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { MakeAppointmentComponent } from './components_secondary/AppointmentManagement/make-appointment/make-appointment.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CheckAppointmentComponent } from './components_secondary/AppointmentManagement/check-appointment/check-appointment.component';
import { ViewAllAppointmentComponent } from './components_secondary/AppointmentManagement/view-all-appointment/view-all-appointment.component';
import { ViewAppointmentComponent } from './components_secondary/AppointmentManagement/view-appointment/view-appointment.component';
import {AddTestComponent} from  './components_secondary/Test Components/add-test/add-test.component';
import {TestComponent} from  './components_secondary/Test Components/test/test.component';
import {UpdatetestComponent} from  './components_secondary/Test Components/updatetest/updatetest.component';
import {ViewalltestsComponent} from  './components_secondary/Test Components/viewalltests/viewalltests.component';
import {ViewAllCentersComponent} from './components_secondary/CenterManagement/view-all-centers/view-all-centers.component';
import {AddCenterComponent} from './components_secondary/CenterManagement/add-center/add-center.component';


import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { DatePipe } from '@angular/common';
import { FooterComponent } from './layouts/footer/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    MakeAppointmentComponent,
    CheckAppointmentComponent,
    ViewAllAppointmentComponent,
    ViewAppointmentComponent,
    AddTestComponent,
    TestComponent,
    UpdatetestComponent,
    ViewalltestsComponent,
    AddCenterComponent,
    ViewAllCentersComponent,
    FooterComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
