import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Operation } from '../model/operation.model';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class OperationService {

  constructor(private api: ApiService) { }

  get(): Observable<Operation[]> {
    return this.api.get("/operaciones/findAll");
  }
}
