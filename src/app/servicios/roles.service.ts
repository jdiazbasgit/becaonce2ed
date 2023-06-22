import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ProyectosService } from './proyectos.service';
import {  map } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RolesService extends ProyectosService {

  constructor(private http: HttpClient) { 
    super(http);
  }

  getRoles(): Observable<any[]>{
    return this.getDatos("http://localhost:8080/once/roles").pipe(
      map((data: any) => {
        if(Array.isArray(data)){
          return data;
        }else if(data?._embedded?.rols){
          return data._embedded.rols;
        }else{
          return [];
        }
      })
    );
  }

  getRole(rolUrl:string): Observable<any>{
    return this.getDatos(rolUrl);
  }

}
