import { Injectable } from '@angular/core';
import { ProyectosService } from './proyectos.service';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CurrentAccountService extends ProyectosService {
  constructor(private httpClient: HttpClient) {
  }
}
