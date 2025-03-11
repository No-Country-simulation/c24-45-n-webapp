import { inject, Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CreateOrganization, Organization } from '../../shared/models/organization.interface';

@Injectable({
  providedIn: 'root'
})
export class OrganizationService {

  private readonly _baseUrl = environment.baseUrl
  private readonly _http = inject(HttpClient)

  getOrganizations():Observable<Organization[]>{
    return this._http.get<Organization[]>(`${this._baseUrl}/organization`)
  }

  getOrganizationbyId(id:number):Observable<Organization | null>{
    return this._http.get<Organization | null>(`${this._baseUrl}/organization/${id}`)
  }

  createOrganization(organization:CreateOrganization):Observable<any>{
    return this._http.post<any>(`${this._baseUrl}/organization`,{...organization})
  }

  getOrganizationsByUser(id:number):Observable<Organization[]>{
    return this._http.get<Organization[]>(`${this._baseUrl}/organization/user/${id}`)
  }
}
