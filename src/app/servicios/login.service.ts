import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import Login from '../beans/Login';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  identificar(url:string,user:string, pwd:string): Observable<any>{
   //console.log(JSON.stringify(new Login(user,"1234")))
    //console.log(new Login("PEPE","1234"))
   
    return this.http.post(url,new Login(user,pwd))
  }
}