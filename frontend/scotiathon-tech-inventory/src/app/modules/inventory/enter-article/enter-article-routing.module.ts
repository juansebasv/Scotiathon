import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EnterArticleComponent } from './component/enter-article.component';


const routes: Routes = [
  {
    path: '',
    component: EnterArticleComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EnterArticleRoutingModule { }
