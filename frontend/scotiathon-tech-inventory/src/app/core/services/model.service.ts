import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Model } from '../model/model.model';
import { ApiService } from './api.service';
import { HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ModelService {

  constructor(private api: ApiService) { }

  get(category: number, brand: string): Observable<Model[]> {
    let params = new HttpParams()
    .set('categoriaid', category.toString())
    .set('marca', brand);
    return this.api.get("/marcas/find", params);
  }
}
