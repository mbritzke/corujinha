import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ListaSitesService {

  constructor(
    private http: HttpClient,
  ) { }

  public getSites(): Observable<any> {
    return this.http.get<any>('');
  }
}
