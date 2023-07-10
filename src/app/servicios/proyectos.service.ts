import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import UserNameBean from '../beans/UserNameBean';

@Injectable({
  providedIn: 'root'
})
export class ProyectosService {

  constructor(private httpClient: HttpClient) { }
  getDatos(url: string): Observable<any> {
    const headers = new HttpHeaders();
    headers.set('Authorization', sessionStorage['token']);
    return this.httpClient.get(url, {headers:{'Authorization': sessionStorage['token']}});
  }
  saveOrUpdate(url:string, objeto:any):Observable<any>{
    const headers = new HttpHeaders();
    headers.set('Authorization', sessionStorage['token']);
    return this.httpClient.post(url,objeto, {headers:{'Authorization': sessionStorage['token']}})
  }
  delete(url:string):Observable<any>{
    const headers = new HttpHeaders();
    headers.set('Authorization', sessionStorage['token']);
    return this.httpClient.delete(url, {headers:{'Authorization': sessionStorage['token']}});
  }
  patch(url:string,user:any):Observable<any>{
    const headers = new HttpHeaders();
    headers.set('Authorization', sessionStorage['token']);
    return this.httpClient.patch(url,user, {headers:{'Authorization': sessionStorage['token']}});
  }
  

}
