import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ProductComponent } from './product/product.component';
import { ProductDataComponent } from './product-data/product-data.component';
import { ProfileComponent } from './profile/profile.component';
import { OfferComponent } from './offer/offer.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent },
  {path: 'product', component: ProductComponent },
  {path: 'productdata', component: ProductDataComponent },
  {path: 'profile', component: ProfileComponent },
  {path: 'offer', component: OfferComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {

}
