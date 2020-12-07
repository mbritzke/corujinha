import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PalavraChave } from './palavra-chave.model';
import { environment } from 'src/environments/environment';

const URL = environment.baseUrl;

@Injectable({
  providedIn: 'root'
})
export class PalavraChaveService {

  constructor(
    private http: HttpClient,
  ) { }

  public getAll(): Observable<PalavraChave[]> {
    return this.http.get<PalavraChave[]>(`${URL}keywords`);
  }
}
