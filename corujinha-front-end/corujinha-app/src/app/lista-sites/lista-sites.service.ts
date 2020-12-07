import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Site } from './sites.model';
import { catchError } from 'rxjs/operators';

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
    return this.http.get<Site[]>(`${URL}addresses/${keyWordId}`)
      .pipe(
        catchError(err => {
          console.error(err)
          return of([]);
        })
      );
  }
}
