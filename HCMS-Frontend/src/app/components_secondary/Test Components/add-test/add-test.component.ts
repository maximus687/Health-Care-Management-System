import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';

import { TestManagement } from 'src/app/models/TestManagement';
import { TestService } from 'src/app/services/Test Service/test.service';

@Component({
  selector: 'app-add-test',
  templateUrl: './add-test.component.html',
  styleUrls: ['./add-test.component.css']
})
export class AddTestComponent implements OnInit {
 test:TestManagement;

   constructor(private _service:TestService,private _routerService:Router) { }
 
   ngOnInit(): void {
     this.test=new TestManagement();
     
    };
     
   
   addTest(){
     this._service.addTest(this.test).subscribe(
       (response)=>{
         
         
         alert("test added suceesfully");
         this._routerService.navigate(['viewalltests']);
       },
       (error)=>{
         alert("Failed to Add Test")
       }
     );
   }
 

}