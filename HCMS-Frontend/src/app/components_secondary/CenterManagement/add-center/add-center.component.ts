import { Component, OnInit } from '@angular/core';
import { Center } from 'src/app/models/Centers';
import { CenterService } from 'src/app/services/CentreService/center.service';

@Component({
  selector: 'app-add-center',
  templateUrl: './add-center.component.html',
  styleUrls: ['./add-center.component.css']
})
export class AddCenterComponent implements OnInit {
test:string;
appointments:number;
  constructor(private apiService:CenterService) { }
center:Center
  ngOnInit(): void {
    this.center=new Center();
  }
  addCenter(center:Center):Center{
    // center.tests.push(this.test);
     center.tests=[null];
    center.tests.push(this.test);
     center.appointments=[null];
    center.appointments.push(this.appointments);
    
    console.log(center);
    this.apiService.addCenter(center).subscribe
    (
      (response)=>{
        alert("Center Added with ID:"+response.centerId);
      },
      error=>{
  alert("Failed to add Center");
      }
      
    )
    return center;
  }
}
