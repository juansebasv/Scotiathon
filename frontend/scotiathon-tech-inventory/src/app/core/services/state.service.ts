import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { State } from '../model/state.model';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class StateService {

  constructor(private api: ApiService) { }

  get(): Observable<State[]> {
    return this.api.get("/estados/findAll");
  }
}
