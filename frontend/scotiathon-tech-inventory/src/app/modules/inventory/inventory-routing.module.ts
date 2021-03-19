import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardModule } from './dashboard/dashboard.module';
import { EnterArticleModule } from './enter-article/enter-article.module';
import { SearchArticleModule } from './search-article/search-article.module';
import { EditArticleModule } from './edit-article/edit-article.module';
import { AssignArticleModule } from './assign-article/assign-article.module';


const routes: Routes = [
  {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full'
  },
  {
    path: 'dashboard',
    loadChildren: './dashboard/dashboard.module#DashboardModule'
  }, 
  {
    path: 'enter-article',
    loadChildren: './enter-article/enter-article.module#EnterArticleModule'
  }, 
  {
    path: 'search-article',
    loadChildren: './search-article/search-article.module#SearchArticleModule'
  }, 
  {
    path: 'edit-article',
    loadChildren: './edit-article/edit-article.module#EditArticleModule'
  },
  {
    path: 'assign-article',
    loadChildren: './assign-article/assign-article.module#AssignArticleModule'
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class InventoryRoutingModule { }
