import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Center} from 'src/app/models/Centers';


@Injectable({
  providedIn: 'root'
})
export class CenterService {

  constructor(private httpclient: HttpClient) { }
  
  rootUrl = "http://localhost:8077/center"
   
  addCenter(center: Center): Observable<Center> {
    //console.log(center);
    return this.httpclient.post<Center>(this.rootUrl + "/addcenter", center);
  }

  getAllCenters(): Observable<Array<Center>> {
    return this.httpclient.get<Array<Center>>(this.rootUrl + "/getallcenters");
  }
  deleteCenter(id: string) {
    return this.httpclient.delete(this.rootUrl + "/removecenter/centerId/" + id);
  }
  getCenter(id: string): Observable<Center> {
    return this.httpclient.get<Center>(this.rootUrl + "get/id/" + id);
  }
     
}


