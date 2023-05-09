import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ProyectosService } from './proyectos.service';

@Injectable({
  providedIn: 'root'
})

export class ExistingproductService extends ProyectosService {

  constructor(private http: HttpClient) {
    super(HttpClient);
  }

  url='https://localhost:8080/';

  findAll() {
    return this.http.get(`${this.url}products`);
  }
}
