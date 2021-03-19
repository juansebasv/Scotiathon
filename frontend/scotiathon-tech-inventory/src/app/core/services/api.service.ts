import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  /**
   * Invoke get request to api
   * @param endpoint Api endpoint
   * @param params Params to send in request
   */
  get(endpoint: string, params?: HttpParams): Observable<any> {
    if (params) {
      return this.http.get(environment.api.base + endpoint, { params });
    } else {
      return this.http.get(environment.api.base + endpoint);
    }
  }

  /**
   * Invoke post request to api
   * @param endpoint Api endpoint
   * @param body Body object to request
   */
  post(endpoint: string, body: any): Observable<any> {
    return this.http.post(environment.api.base + endpoint, body);
  }

  /**
   * Invoke put request to api
   * @param endpoint Api endpoint
   * @param body Body object to request
   */
  put(endpoint: string, body: any): Observable<any> {
    return this.http.put(environment.api.base + endpoint, body);
  }

  /**
   * Invoke patch request to api
   * @param endpoint Api endpoint
   * @param body Body object to request
   */
  patch(endpoint: string, body: any): Observable<any> {
    return this.http.patch(environment.api.base + endpoint, body);
  }

  /**
   * Invoke delete request to api
   * @param endpoint Api endpoint
   */
  delete(endpoint: string): Observable<any> {
    return this.http.delete(environment.api.base + endpoint);
  }
}
