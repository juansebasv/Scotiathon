import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SearchArticleComponent } from './component/search-article.component';


const routes: Routes = [
  {
    path: '',
    component: SearchArticleComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SearchArticleRoutingModule { }
