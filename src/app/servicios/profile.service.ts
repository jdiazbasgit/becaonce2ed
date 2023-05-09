import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ProyectosService } from './proyectos.service';
@Injectable({
  providedIn: 'root'
})
export class ProfileServiceextends extends ProyectosService {

  constructor(private http: HttpClient) {
    super(http);
  }

  url='https://localhost:8080/';

  findAllProfile() {
    return this.http.request('GET', `${this.url}profile`);
  }

}
