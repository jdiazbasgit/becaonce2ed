import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
<<<<<<< HEAD
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './componentes/profile/profile.component';
import { ProductComponent } from './componentes/product/product.component';
=======
import { LoginComponent } from './componentes/login/login.component';
import { ProductComponent } from './componentes/product/product.component';
import { ProfileComponent } from './componentes/profile/profile.component';
import { OfferComponent } from './componentes/offer/offer.component';
>>>>>>> e967fb9ce2634847633369b3ada9d9c9d5872f1c

const routes: Routes = [
  {path: 'login', component: LoginComponent },
  {path: 'product', component: ProductComponent },
<<<<<<< HEAD
  {path: 'productdata', component: ProductComponent },
  {path: 'profile', component: ProfileComponent }
=======
  {path: 'profile', component: ProfileComponent },
  {path: 'offer', component: OfferComponent }
>>>>>>> e967fb9ce2634847633369b3ada9d9c9d5872f1c
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {

}
