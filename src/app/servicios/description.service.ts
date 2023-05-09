import { Injectable } from '@angular/core';
import { ProyectosService } from './proyectos.service';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DescriptionService extends ProyectosService {

  constructor(private httpClient: HttpClien) { }
}
