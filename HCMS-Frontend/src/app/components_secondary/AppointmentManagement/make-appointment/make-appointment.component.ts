import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Appointment } from 'src/app/models/Appointment';
import { Center } from 'src/app/models/Center';
import { Tests } from 'src/app/models/Tests';
import { AppointmenServiceService } from 'src/app/services/AppointmentService/appointmen-service.service';
import { TokenStorageService } from 'src/app/_services/token-storage.service';

@Component({
  selector: 'app-make-appointment',
  templateUrl: './make-appointment.component.html',
  styleUrls: ['./make-appointment.component.css']
})
export class MakeAppointmentComponent implements OnInit {
   
  appointments : Appointment;
  centers :  Center[];

  listOfTest : Tests[];

  username: string;

  appointmentForm : FormGroup;
  

  constructor(private healthService : AppointmenServiceService, private fb: FormBuilder, private token: TokenStorageService) { }

  ngOnInit(): void {
    this.showAllCenters();
    this.showAllTest();
    this.appointmentForm = this.fb.group({
      testId        : ['', Validators.required],
      centreId      : ['', Validators.required],
      date     : ['', Validators.required],
      time     : ['', Validators.required]
    });
  }

 

  get testId(){return this.appointmentForm.get('testId');}
  get centreId(){return this.appointmentForm.get('centreId');}
  get date(){return this.appointmentForm.get('date');}
  get time(){return this.appointmentForm.get('time');}

  public addAppointment = (appointmentForm: {testId : string; centreId : string; date : number; time:number}) => {
    if (this.appointmentForm.valid) {
      this.executeAppointmentsCreation(appointmentForm);
    }
  }

  private executeAppointmentsCreation = (appointmentForm: {testId : string; centreId : string; date : number; time:number}) => {
       this.appointments = {
      appointmentId: null,
      userId:this.token.getUser().username,
      testId:appointmentForm.testId,
      centreId:appointmentForm.centreId,
      status:"pending",
      dateTime:new Date(appointmentForm.date+" "+appointmentForm.time),
    } 
    this.healthService.createAppointment(this.appointments)
    .subscribe(
     Response =>{console.log('Success!',Response),
     alert('Added Successfully');},
     Error=>{console.log('Error',Error),
    alert('The Slot Is Not Available');}
    )
  }
   

  showAllCenters()
  {
    return this.healthService.getCenters().subscribe(res => {this.centers = res;
      console.log('appointment service ',this.centers);
      });  
   
  }


  showAllTest()
  {
    return this.healthService.getAllTest().subscribe(res => {this.listOfTest = res;
      console.log('appointment service ',this.listOfTest);
      });
    
  }

  

  // showTest(id:string){
  //   console.log(id);
  //   for (let index = 0; index < this.centers.length; index++) {

  //     if (this.centers[index].centerName==this.selectedCenter) {
          
  //       for (let i= 0; i< this.centers[index].tests.length; i++) {

  //         this.selectedTest.push(this.centers[index].tests[i]);
  //         console.log(this.centers[index].tests[i]);
  //         console.log("hello");
  //       }  
  //     }     
  //   }
  // }

}
