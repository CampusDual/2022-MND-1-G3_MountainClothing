import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders, HttpParams } from '@angular/common/http';
import { catchError, map, Observable, throwError } from 'rxjs';
import { API_CONFIG } from '../shared/api.config';
import { environment } from 'src/environments/environment';
import { AnyPageFilter } from '../model/rest/filter';
import { DataSourceRESTResponse } from '../model/rest/response';
import { CreateContactRequest, CreatePrendaRequest, EditContactRequest, EditPrendaRequest } from '../model/rest/request';
import { Buffer } from 'buffer';
import { Prendas } from '../model/prendasweb';

@Injectable({
  providedIn: 'root'
})
export class PrendasService {

  constructor(private http: HttpClient) { }

  public getPrendas(pageFilter: AnyPageFilter): Observable<DataSourceRESTResponse<Prendas[]>> {
    const url = API_CONFIG.getPrendas;
    const headers = new HttpHeaders({
      'Content-type': 'application/json; charset=utf-8',
      // Authorization: 'Basic ' + btoa(`${environment.clientName}:${environment.clientSecret}`),
      Authorization: 'Basic ' + Buffer.from(`${environment.clientName}:${environment.clientSecret}`, 'utf8').toString('base64'),
    });
    return this.http.post<DataSourceRESTResponse<Prendas[]>>(url, pageFilter, { headers });
  }

  public getPrenda(id: number): Observable<Prendas> {
    const url = API_CONFIG.getPrenda;
    const headers = new HttpHeaders({
      'Content-type': 'charset=utf-8',
      Authorization: 'Basic ' + Buffer.from(`${environment.clientName}:${environment.clientSecret}`, 'utf8').toString('base64'),
    });
    const params = new HttpParams().set('id', id.toString());
    return this.http.get<Prendas>(url, { params, headers });
  }

  public createPrenda(prenda: Prendas): Observable<any> {
    const url = API_CONFIG.createPrendas;
    const body: CreatePrendaRequest = new CreatePrendaRequest(prenda);
    const headers = new HttpHeaders({
      'Content-type': 'application/json; charset=utf-8',
      Authorization: 'Basic ' + Buffer.from(`${environment.clientName}:${environment.clientSecret}`, 'utf8').toString('base64'),
    });
    return this.http.post<Prendas>(url, body, { headers }).pipe(
      catchError(e =>{
        return throwError(()=>e);
      })
    );
  }

  public editPrenda(prenda: Prendas): Observable<any> {
    const url = API_CONFIG.editPrendas;
    const body: EditPrendaRequest = new EditPrendaRequest(prenda);
    const headers = new HttpHeaders({
      'Content-type': 'application/json; charset=utf-8',
      Authorization: 'Basic ' + Buffer.from(`${environment.clientName}:${environment.clientSecret}`, 'utf8').toString('base64'),
    });
    return this.http.post<any>(url, body, { headers }).pipe(
      catchError((e:HttpErrorResponse) =>{
        return throwError(()=>e);
      })
    );
  }

  public deletePrenda(id: number): Observable<any> {
    const url = API_CONFIG.deletePrendas;
    const headers = new HttpHeaders({
      'Content-type': 'charset=utf-8',
      Authorization: 'Basic ' + Buffer.from(`${environment.clientName}:${environment.clientSecret}`, 'utf8').toString('base64'),
    });
    const params = new HttpParams().set('id', id.toString());
    return this.http.delete<any>(url, { params, headers });
  }
}
