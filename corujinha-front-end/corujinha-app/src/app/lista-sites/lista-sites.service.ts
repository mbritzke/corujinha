import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Site } from './sites.model';

const URL = environment.baseUrl;

@Injectable({
  providedIn: 'root'
})
export class ListaSitesService {

  constructor(
    private http: HttpClient,
  ) { }

  public getSitesByKeyWordId(keyWordId: number): Observable<Site[]> {
    console.log(URL);
    return this.http.get<Site[]>(`${URL}address/${keyWordId}`);
  }
}
