import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ProyectosService } from './proyectos.service';
@Injectable({
  providedIn: 'root'
})
export class RolService extends ProyectosService {
  getRoleById(arg0: number) {
    throw new Error('Method not implemented.');
  }

  constructor(private http: HttpClient) {
    super(http);
   }
}
