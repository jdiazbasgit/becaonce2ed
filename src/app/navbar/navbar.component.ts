import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
menuVisible: boolean = false;

toggleMenu(): void {
  this.menuVisible = !this.menuVisible;
}
}

function highlightActiveButton(activeButtonId: string) {
  const buttons = document.querySelectorAll('.nav-link button');

  buttons.forEach(button => {
    button.classList.remove('active');
  });

  const activeButton = document.getElementById(activeButtonId);
  if (activeButton) {
    activeButton.classList.add('active');
  } 
}

