import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { State } from '../model/state.model';
import { Warehouse } from '../model/warehouse.model';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class WarehouseService {

  constructor(private api: ApiService) { }

  get(): Observable<Warehouse[]> {
    return this.api.get("/bodega/findAll");
  }
}
