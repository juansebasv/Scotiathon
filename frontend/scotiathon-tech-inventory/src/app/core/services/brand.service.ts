import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Brand } from '../model/brand.model';
import { ApiService } from './api.service';
import { HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BrandService {

  constructor(private api: ApiService) { }

  get(category: number): Observable<string[]> {
    let params = new HttpParams().set('categoriaid', category.toString());
    return this.api.get("/marcas/findByCategoria", params);
  }
}
