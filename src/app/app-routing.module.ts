import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
//import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './componentes/profile/profile.component';
import { ProductComponent } from './componentes/product/product.component';

const routes: Routes = [
  //{path: 'login', component: LoginComponent },
  {path: 'product', component: ProductComponent },
  {path: 'productdata', component: ProductComponent },
  {path: 'profile', component: ProfileComponent }
];

@NgModule({
 // imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {

}
