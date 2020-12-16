import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Center } from 'src/app/models/Centers';
import { CenterService } from 'src/app/services/CentreService/center.service';

@Component({
  selector: 'app-view-all-centers',
  templateUrl: './view-all-centers.component.html',
  styleUrls: ['./view-all-centers.component.css']
})
export class ViewAllCentersComponent implements OnInit {
  centerList: Array<Center>=[];
 // center : Center
  constructor(private router:Router, private centerservice:CenterService) { }

  ngOnInit(): void {


    this.reloadData();

  }
  reloadData() {
    this.centerservice.getAllCenters().subscribe(
      (response)=>{
        console.log(response);
        this.centerList=response;
      },
      error=>{
alert("failed to get centerList");
      }
    )
  }
  
    

 delete(id:string):void{
 console.log(id);
    alert("sure you want to delete");
this.centerservice.deleteCenter(id).subscribe(
      (response)=>{
        alert("Center Deleted")
      },
      error=>{
    alert("Couldn't able to delete");
      }
    )
  }



}
