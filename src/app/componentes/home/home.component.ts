import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent {
  getSessionStorage():any{
    return sessionStorage.getItem("token");
  }
}
