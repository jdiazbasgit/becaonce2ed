import { Injectable } from '@angular/core';
import { ProyectosService } from './proyectos.service';
import { HttpClient } from '@angular/common/http';
import DocumentTypeBean from '../beans/DocumentTypeBean';
@Injectable({
  providedIn: 'root'
})
export class DocumentTypeService extends ProyectosService {
  
  constructor(private http: HttpClient) {
    super(http);
  }

  
}

 