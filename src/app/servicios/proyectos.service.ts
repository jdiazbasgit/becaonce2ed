import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

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
    return this.httpClient.post(url,objeto)
  }
  delete(url:string):void{
    this.httpClient.delete(url);
  }

}
