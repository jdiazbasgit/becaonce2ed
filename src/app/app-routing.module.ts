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
import { RolComponent } from './componentes/rol/rol.component';
import { DocumentTypesComponent } from './componentes/document-types/document-types.component';
import { CardTypeComponent } from './componentes/card-type/card-type.component';
import { HomeComponent } from './componentes/home/home.component';

const routes: Routes = [
  {path: '', component: HomeComponent },
  {path: 'login', component: LoginComponent },
  {path: 'product', component: ProductComponent },
  {path: 'profile', component: ProfileComponent },
  {path: 'offer', component: OfferComponent },
  {path: 'conf', component:ConfigurationComponent },
  {path: 'categorias', component: CategoryComponent },
  {path: 'subcategorias', component: SubcategoryComponent },
  {path: 'roles', component: RolComponent },
  {path: 'tipoDocumentos', component: DocumentTypesComponent },
  {path: 'tipoTarjetas', component: CardTypeComponent },
  {path: 'usuarios', component: UserComponent },
  {path: 'home', component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {}
