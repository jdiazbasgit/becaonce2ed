import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Login from '../beans/LoginBean'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  identificar(url: string, user: string, pwd: string): Observable<any>{
    return this.http.post(url, new Login(user, pwd));
  }
}
