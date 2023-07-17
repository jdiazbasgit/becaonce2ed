import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProyectosService {

  constructor(private httpClient: HttpClient) { }
  getDatos(url: string): Observable<any> {
    // const headers = new HttpHeaders();
    // headers.set('Authorization', sessionStorage['token']);
    // return this.httpClient.get(url,{headers:{'Authorization': sessionStorage['token']}});

    const headers = new HttpHeaders();
    const token = sessionStorage.getItem('token');
    if (token != null)
      headers.set('Authorization', token);
    return this.httpClient.get(url, { headers });
  }

  saveOrUpdate(url: string, objeto: any): Observable<any> {
    // const headers = new HttpHeaders();
    // headers.set('Authorization', sessionStorage['token']);
    // return this.httpClient.post(url, { headers: { 'Authorization': sessionStorage['token'] } });
    const headers = new HttpHeaders();
    const token = sessionStorage.getItem('token');
    if (token != null)
      headers.set('Authorization', token);
    return this.httpClient.post(url, { headers });
  }

  delete(url: string): Observable<any> {
    // const headers = new HttpHeaders();
    // headers.set('Authorization', sessionStorage['token']);
    // return this.httpClient.delete(url, { headers: { 'Authorization': sessionStorage['token'] } });

    const headers = new HttpHeaders();
    const token = sessionStorage.getItem('token');
    if (token != null)
      headers.set('Authorization', token);
    return this.httpClient.delete(url, { headers });
  }

  patch(url: string, user: any): Observable<any> {
    // const headers = new HttpHeaders;
    // headers.set('Authorization', sessionStorage['token']);
    // return this.httpClient.patch(url, user, { headers: { 'Authorization': sessionStorage['token'] } });

    const headers = new HttpHeaders();
    const token = sessionStorage.getItem('token');
    if (token != null)
      headers.set('Authorization', token);
    return this.httpClient.patch(url, user, { headers });
  }

}