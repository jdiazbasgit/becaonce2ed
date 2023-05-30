import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Login} from '../clases/Login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  identificar(url:string,user:string, pwd:string){
   
    return this.http.post(url,{body:new Login(user,pwd)})
  }
}
