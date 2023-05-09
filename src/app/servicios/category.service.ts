import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ProyectosService } from './proyectos.service';

@Injectable({
  providedIn: 'root'
})
export class categoryService extends ProyectosService {

  constructor(private http: HttpClient) {
    super(http);
   }
}
