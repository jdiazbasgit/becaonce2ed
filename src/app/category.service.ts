import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ProyectosService } from './servicios/proyectos.service';

@Injectable({
  providedIn: 'root'
})
export class categoryService extends ProyectosService {

  constructor(private httpClient: HttpClient) { }
}
