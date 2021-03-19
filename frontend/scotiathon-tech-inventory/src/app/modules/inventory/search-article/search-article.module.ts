import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SearchArticleRoutingModule } from './search-article-routing.module';
import { SearchArticleComponent } from './component/search-article.component';
import { MatTableModule } from '@angular/material/table';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input'
import { MatIconModule } from '@angular/material/icon'
import { MatButtonModule } from '@angular/material/button'
import { MatSelectModule } from '@angular/material/select';


@NgModule({
  declarations: [SearchArticleComponent],
  imports: [
    CommonModule,
    SearchArticleRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule,
    MatSelectModule,
    MatTableModule
  ]
})
export class SearchArticleModule { }
