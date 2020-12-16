import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { ViewAllAppointmentComponent } from './components_secondary/AppointmentManagement/view-all-appointment/view-all-appointment.component';
import { MakeAppointmentComponent } from './components_secondary/AppointmentManagement/make-appointment/make-appointment.component';
import { CheckAppointmentComponent } from './components_secondary/AppointmentManagement/check-appointment/check-appointment.component';
import { AddTestComponent } from './components_secondary/Test Components/add-test/add-test.component';
import { TestComponent } from './components_secondary/Test Components/test/test.component';
import { UpdatetestComponent } from './components_secondary/Test Components/updatetest/updatetest.component';
import { ViewalltestsComponent } from './components_secondary/Test Components/viewalltests/viewalltests.component';
import { AddCenterComponent } from './components_secondary/CenterManagement/add-center/add-center.component';
import { ViewAllCentersComponent } from './components_secondary/CenterManagement/view-all-centers/view-all-centers.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'viewAllAppointment', component: ViewAllAppointmentComponent  },
  { path: 'makeAppointment', component: MakeAppointmentComponent },
  { path: 'checkAppointment', component: CheckAppointmentComponent },
  {path:'addTest',component: AddTestComponent},
  {path:'testComponent',component: TestComponent},
  {path:'updateTest',component: UpdatetestComponent},
  {path:'viewAllTest',component: ViewalltestsComponent},
  {path:'addCenter', component: AddCenterComponent},
  {path:'viewAllCenters', component:ViewAllCentersComponent},
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
