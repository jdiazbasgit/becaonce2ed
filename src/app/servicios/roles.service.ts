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

}
