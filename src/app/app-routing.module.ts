import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
<<<<<<< HEAD
//import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './componentes/profile/profile.component';
=======
import { LoginComponent } from './componentes/login/login.component';
>>>>>>> 8d1d533e60d2bf5ebbdc016eac43f2930d4a9402
import { ProductComponent } from './componentes/product/product.component';
import { ProfileComponent } from './componentes/profile/profile.component';
import { OfferComponent } from './componentes/offer/offer.component';

const routes: Routes = [
  //{path: 'login', component: LoginComponent },
  {path: 'product', component: ProductComponent },
  {path: 'profile', component: ProfileComponent },
  {path: 'offer', component: OfferComponent }
];

@NgModule({
 // imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {

}
