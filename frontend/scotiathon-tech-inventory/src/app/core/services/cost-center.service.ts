import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';
import { CostCenter } from '../model/cost-center.model';
import { HttpParams } from '@angular/common/http';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class CostCenterService {

  constructor(private api: ApiService) { }

  get(operation: number): Observable<CostCenter[]> {
    let params = new HttpParams()
      .set('operacionId', operation.toString());
    return this.api.get("/centroCosto/findCentroCosto", params);
  }

  getAll(): Observable<CostCenter[]> {
    return this.api.get("/centroCosto/findAll");
  }
}
