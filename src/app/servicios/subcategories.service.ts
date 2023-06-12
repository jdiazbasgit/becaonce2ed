import { Injectable } from "@angular/core";
import { ProyectosService } from "./proyectos.service";
import { HttpClient } from "@angular/common/http";


@Injectable({
  providedIn: 'root'
})
export class SubcategoryService extends ProyectosService {
  

  constructor(private http: HttpClient) { 
    super(http);
  } 
}
