import { Component, Directive, ElementRef, OnInit, Renderer2 } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';

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

@Directive({
  selector: '[highlightActiveButton]'
})
export class HighlightActiveButtonDirective implements OnInit {
  constructor(private router: Router, private el: ElementRef, private renderer: Renderer2) {}

    ngOnInit() {
      this.router.events.subscribe(event => {
        if (event instanceof NavigationEnd) {
          const currentRoute = this.router.url.slice(1);

          if (currentRoute === this.el.nativeElement.id) {
            this.renderer.addClass(this.el.nativeElement, 'active');
          } else {
            this.renderer.removeClass(this.el.nativeElement, 'active');
          } 
        }
      });
    }
  }
