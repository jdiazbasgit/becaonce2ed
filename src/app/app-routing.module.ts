import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { GeneralesComponent } from './generales/generales.component';
import { GeograficosComponent } from './geograficos/geograficos.component';
import { BanderasComponent } from './banderas/banderas.component';
import { FronterasComponent } from './fronteras/fronteras.component';

const routes: Routes = [
  {path: 'generales/:pais', component: GeneralesComponent },
  {path: 'geograficos/:pais', component: GeograficosComponent },
  {path: 'banderas/:pais', component: BanderasComponent },
  {path: 'fronteras/:pais', component: FronterasComponent },
  { path: 'pipes/:pais', component: FronterasComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
