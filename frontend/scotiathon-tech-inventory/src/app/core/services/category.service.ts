import { Injectable } from '@angular/core';
import { Category } from '../model/category.model';
import { Observable } from 'rxjs';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private api: ApiService) { }

  get(): Observable<Category[]> {
    return this.api.get("/categorias/findAll");
    // return Observable.create((observable) => {
    //   let categories = [];
    //   categories = [{ id: 2, name: 'Televisor' }, { id: 3, name: 'Laptop' }, { id: 4, name: 'Licencia' }];
    //   return observable.next(categories);
    // });
  }
}
