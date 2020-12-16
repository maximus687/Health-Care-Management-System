import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from 'src/app/models/Appointment';
import { Center } from 'src/app/models/Center';
import { Tests } from 'src/app/models/Tests';
import { TokenStorageService } from 'src/app/_services/token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class AppointmenServiceService {
  
  userId : string = this.token.getUser().username;
  
  createAppointment(appointments: Appointment) : Observable<any> {
    const body= JSON.stringify(appointments);
    const headers = { 'content-type': 'application/json'};
    return this.http.post<Appointment>('http://localhost:9200/api/v1/appointment/makeAppointment',body,{headers});
  }

  readonly appointmentUrl : 'http://localhost:9200/api/v1/appointment'; 
  readonly centerUrl : 'http://localhost:8077/center/';

  constructor(private http: HttpClient , private token: TokenStorageService) { }

  getCenters(): Observable<Center[]> {
    return this.http.get<Center[]>('http://localhost:8077/center/getallcenters');
    }
  
  getAllAppointment(selectedCenterId : any): Observable<Appointment[]> {
    console.log(selectedCenterId);
    return this.http.get<Appointment[]>('http://localhost:9200/api/v1/appointment/getAllAppointments/'+selectedCenterId);
  }  

  getAllTest(): Observable<Tests[]>
  {
    return this.http.get<Tests[]>('http://localhost:8001/test/getAll');
  }

  viewAllAppointmentByUserId(): Observable<Appointment[]>
  {
    return this.http.get<Appointment[]>('http://localhost:9200/api/v1/appointment//viewAppointment/'+this.userId);
  }

  
  
  
}
