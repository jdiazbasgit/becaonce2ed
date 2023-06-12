import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProyectosService {

  constructor(private httpClient: HttpClient) { }
  getDatos(url: string): Observable<any> {
    return this.httpClient.get(url);
  }

  saveOrUpdate(url:string, objeto:any):Observable<any>{
    console.log("objeto:"+objeto)
    return this.httpClient.post(url,objeto)
  }

  delete(url:string):Observable<any>{
    return this.httpClient.delete(url);
  }

  ifExist(url:string):Observable<any>{
  
    return this.httpClient.post(url,"");

  }

}