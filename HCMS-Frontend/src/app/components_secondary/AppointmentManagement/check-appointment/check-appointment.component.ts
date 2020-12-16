import { Component, OnInit } from '@angular/core';
import { Appointment } from 'src/app/models/Appointment';
import { AppointmenServiceService } from 'src/app/services/AppointmentService/appointmen-service.service';

@Component({
  selector: 'app-check-appointment',
  templateUrl: './check-appointment.component.html',
  styleUrls: ['./check-appointment.component.css']
})
export class CheckAppointmentComponent implements OnInit {

  allUserAppointment : Appointment[];   

  appointment : Appointment;

  constructor(private appointmentService : AppointmenServiceService) { }

  ngOnInit(): void 
  {
    this.showAllUserAppointment();
  }

  showAllUserAppointment()
  {
    return this.appointmentService.viewAllAppointmentByUserId().subscribe(appointment=>{
      this.allUserAppointment = appointment;
      console.log(this.allUserAppointment);
    })
  }

}
