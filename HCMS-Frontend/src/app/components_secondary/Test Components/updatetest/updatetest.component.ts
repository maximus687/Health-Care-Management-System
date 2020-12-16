import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TestService } from 'src/app/services/Test Service/test.service';
import { TestManagement } from 'src/app/models/TestManagement';

@Component({
  selector: 'app-updatetest',
  templateUrl: './updatetest.component.html',
  styleUrls: ['./updatetest.component.css']
})
export class UpdatetestComponent implements OnInit {

  test:TestManagement;

   constructor(private _service:TestService,private _routerService:Router) { }
 
   ngOnInit(): void {
     this.test=new TestManagement();
     
    };
     
   
   updateTest(){
     this._service.updateTest(this.test).subscribe(
       (response)=>{
         
         
         alert("test updated suceesfully");
         this._routerService.navigate(['viewalltests']);
       },
       (error)=>{
         alert("Failed to update Test")
       }
     );
   }
 

}
