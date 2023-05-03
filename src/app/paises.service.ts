// paises.service.ts
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PaisesService {
  constructor(private service: HttpClient) { }

  dameDatos(url: string): any {
    return this.service.get(url);
  }
}
