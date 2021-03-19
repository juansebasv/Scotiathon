import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AssignArticleRoutingModule } from './assign-article-routing.module';
import { AssignArticleComponent } from './component/assign-article.component';


@NgModule({
  declarations: [AssignArticleComponent],
  imports: [
    CommonModule,
    AssignArticleRoutingModule
  ]
})
export class AssignArticleModule { }
