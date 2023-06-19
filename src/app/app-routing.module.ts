import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './componentes/login/login.component';
import { ProductComponent } from './componentes/product/product.component';
import { ProfileComponent } from './componentes/profile/profile.component';
import { OfferComponent } from './componentes/offer/offer.component';
import { ConfigurationComponent } from './componentes/configuration/configuration.component';
import { CategoryComponent } from './componentes/category/category.component';
import { UserComponent } from './componentes/user/user.component';
import { SubcategoryComponent } from './componentes/subcategory/subcategory.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent },
  {path: 'product', component: ProductComponent },
  {path: 'profile', component: ProfileComponent },
  {path: 'offer', component: OfferComponent },
  {path: 'conf', component:ConfigurationComponent },
  {path: 'categorias', component: CategoryComponent },
  {path: 'subcategorias', component: SubcategoryComponent },
  {path: 'usuarios', component: UserComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {

}
