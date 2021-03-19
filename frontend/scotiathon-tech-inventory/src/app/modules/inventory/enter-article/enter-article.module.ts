import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EnterArticleRoutingModule } from './enter-article-routing.module';
import { EnterArticleComponent } from './component/enter-article.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input'
import { MatIconModule } from '@angular/material/icon'
import { MatButtonModule } from '@angular/material/button'
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';
import { MatSnackBarModule } from '@angular/material/snack-bar';


@NgModule({
  declarations: [EnterArticleComponent],
  imports: [
    CommonModule,
    EnterArticleRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule,
    MatSelectModule,
    MatTableModule,
    MatSnackBarModule
  ]
})
export class EnterArticleModule { }
