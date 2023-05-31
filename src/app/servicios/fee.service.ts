import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ProyectosService } from './proyectos.service';

@Injectable({
  providedIn: 'root'
})
export class FeeService extends ProyectosService{

  constructor(private httpClientS:HttpClient) {
    super(httpClientS);
  }

  
}
