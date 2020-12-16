import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {TestManagement} from  'src/app/models/TestManagement';
@Injectable({
  providedIn: 'root'
})
export class TestService {

  constructor(private http:HttpClient) { }
  rootURL:String="http://localhost:8001/test/";
  public addTest(test:TestManagement):Observable<TestManagement>
{
  console.log(this.rootURL+"addTest/");
  return this.http.post<TestManagement>(this.rootURL+"addTest/",test);
}
public updateTest(test:TestManagement):Observable<TestManagement>
{
  console.log(this.rootURL+"updateTest/");
  return this.http.put<TestManagement>(this.rootURL+"updateTest/",test);
}
public removeTest(testId:string)
{
  console.log(this.rootURL+"deleteTest/id");
  return this.http.delete(this.rootURL+"deleteTest/id/"+testId);
}
public viewAllTests()
{
  console.log(this.rootURL+"/getAll");
  return this.http.get(this.rootURL+"getAll/");
}
}
