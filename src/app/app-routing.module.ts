import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './componentes/login/login.component';
import { ProductComponent } from './componentes/product/product.component';
import { ConfigurationComponent } from './componentes/configuration/configuration.component';
import { CategoryComponent } from './componentes/category/category.component';
import { UserComponent } from './componentes/user/user.component';
import { SubcategoryComponent } from './componentes/subcategory/subcategory.component';
import { RolComponent } from './componentes/rol/rol.component';
import { DocumentTypesComponent } from './componentes/document-types/document-types.component';
import { CardTypeComponent } from './componentes/card-type/card-type.component';
//import { HomeComponent } from './componentes/home/home.component';
import { ProfileComponent } from './componentes/profile/profile.component';
import { SoldProductComponent } from './componentes/sold-product/sold-product.component';
import { ExistingProductComponent } from './componentes/existing-product/existing-product.component';

const routes: Routes = [
  {path: '', component: ProductComponent },
  {path: 'login', component: LoginComponent },
  {path: 'product', component: ProductComponent },
  {path: 'profile', component: ProfileComponent },
  {path: 'conf', component:ConfigurationComponent },
  {path: 'categorias', component: CategoryComponent },
  {path: 'subcategorias', component: SubcategoryComponent },
  {path: 'roles', component: RolComponent },
  {path: 'tipoDocumentos', component: DocumentTypesComponent },
  {path: 'tipoTarjetas', component: CardTypeComponent },
  {path: 'usuarios', component: UserComponent },
  {path: 'home', component: ProductComponent },
  {path: 'cesta', component: SoldProductComponent },
  {path: 'productosexistentes', component: ExistingProductComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {}
