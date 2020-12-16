import { Component, OnInit } from '@angular/core';
import { TestService } from 'src/app/services/Test Service/test.service';
import { TestManagement } from 'src/app/models/TestManagement';

@Component({
  selector: 'app-viewalltests',
  templateUrl: './viewalltests.component.html',
  styleUrls: ['./viewalltests.component.css']
})
export class ViewalltestsComponent implements OnInit {

  testList:TestManagement[];
  constructor(private _service:TestService) { }

  ngOnInit(): void {

this._service.viewAllTests().subscribe(

(data:TestManagement[])=>{this.testList=data;

  console.log(data);

}
// ,
// error=>alert("Failed to display Screens")
);
}
deleteTest(testid:string){
  console.log(testid);
  this._service.removeTest(testid).subscribe( (response)=>{
    alert("test deleted SuccessFully");
    this.ngOnInit();

  },
  (error)=>{
    alert("Failed To Delete Test");

  })

}
}
