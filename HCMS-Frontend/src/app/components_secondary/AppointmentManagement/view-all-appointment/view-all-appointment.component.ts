import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { stringify } from 'querystring';
import { Appointment } from 'src/app/models/Appointment';
import { Center } from 'src/app/models/Center';
import { AppointmenServiceService } from 'src/app/services/AppointmentService/appointmen-service.service';

@Component({
  selector: 'app-view-all-appointment',
  templateUrl: './view-all-appointment.component.html',
  styleUrls: ['./view-all-appointment.component.css']
})
export class ViewAllAppointmentComponent implements OnInit {
  centers :  Center[];
  selectedCenterId : any = '';
  successSubmitted: boolean = false;
  appointment : Appointment = new Appointment;
  appointmentList : Appointment[];
  appointmentId :any;
  status1 : string = "approved";
  status2 : string = "disapproved";
  baseUrl: string  = "http://localhost:9200/api/v1/appointment/approveAppointment/";
  disapproveUrl : string = "http://localhost:9200/api/v1/appointment/disapproveAppointment/";

  constructor(private healthService : AppointmenServiceService, private http: HttpClient, private fb : FormBuilder ) { }

  appointmentForm = this.fb.group({
    selectedCenterId : [this.selectedCenterId]
  })
  showAllCenters()
  {
    return this.healthService.getCenters().subscribe(res => {this.centers = res;
      console.log('appointment service ',this.centers);
      });  
   
  }

  OnSubmit(){
    this.successSubmitted = true;
    this.showAllAppointment();
    //console.log(this.appointmentForm.get('selectedCenterId').value);
  }

  ngOnInit(): void {

    this.showAllCenters();
  }

showAllAppointment()
{
  return this.healthService.getAllAppointment(this.appointmentForm.get('selectedCenterId').value).subscribe(
    appointment => {this.appointmentList = appointment;
    console.log(this.appointmentList)},
    Error=>{console.log('Error',Error),
    alert('No Appointment For This Selected Center');
     this.appointmentList = null});
    };

approveAppointment(appointmentId:number)
{
  console.log("approve");
  console.log(appointmentId);
  this.http.get<Appointment>(this.baseUrl+appointmentId+'/approved').subscribe((res) =>{
    this.appointment=res
  });
  this.ngOnInit();
}    

disapproveAppointment(appointmentId:number)
{
 
  console.log("disapprove");
  console.log(appointmentId);
  this.http.get<Appointment>(this.disapproveUrl+appointmentId+'/disapproved').subscribe((res) =>{
    this.appointment = res;
  });
  this.ngOnInit();
}

}
