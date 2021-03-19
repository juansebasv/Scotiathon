import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { GbsInventoryComponent } from './layout/gbs-inventory/gbs-inventory.component';
import { LoginContainerComponent } from './layout/login-container/login-container.component';
import { LoginModule } from './modules/login/login.module';
import { InventoryModule } from './modules/inventory/inventory.module';


const routes: Routes = [
  {
    path: '',
    component: AppComponent,
    children: [
      {
        path: '',
        redirectTo: 'gbs-inventory',
        pathMatch: 'full'
      },
      {
        path: 'login',
        component: LoginContainerComponent,
        children: [
          {
            path: '',
            loadChildren: './modules/login/login.module#LoginModule'
          }
        ]
      },
      {
        path: 'gbs-inventory',
        component: GbsInventoryComponent,
        children: [
          {
            path: '',
            loadChildren: './modules/inventory/inventory.module#InventoryModule'
          }
        ]
      }
    ]
  },
  {
    path: '**',
    redirectTo: 'gbs-inventory',
    pathMatch: 'full'
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
