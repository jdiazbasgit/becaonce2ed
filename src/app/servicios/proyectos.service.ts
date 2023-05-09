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

  saveOrUpdate(url:string, objeto:Object):Observable<any>{
    return this.httpClient.post(url,{body:objeto})
  }

  delete(url:string):void{
    this.httpClient.delete(url);
  }

}
