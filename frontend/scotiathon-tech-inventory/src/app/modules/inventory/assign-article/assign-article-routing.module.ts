import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AssignArticleComponent } from './component/assign-article.component';


const routes: Routes = [
  {
    path: '',
    component: AssignArticleComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AssignArticleRoutingModule { }
