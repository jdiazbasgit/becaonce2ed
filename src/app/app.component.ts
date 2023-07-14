import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  constructor(private http:HttpClient ){}

  ngOnInit(): void {
    this.http.get("http://localhost:8080/once/arrancar").subscribe((dato:any)=>{
    console.log(dato)
    })
  }
  title = 'BankInsert';
}
