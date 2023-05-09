import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ProyectosService } from './servicios/proyectos.service';

@Injectable({
  providedIn: 'root'
})
export class CardTypeService extends ProyectosService{

  constructor(private http:HttpClient) {
    super(http);
    this.http.delete;
    this.http.get;
    this.http.head;
    this.http.jsonp;
    this.http.options;
    this.http.patch;
    this.http.post;
    this.http.put;
    this.http.request;
    
  }
}
