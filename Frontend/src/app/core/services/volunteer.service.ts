import { inject, Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Volunteer } from '../../shared/models/volunteer.interface';

@Injectable({
  providedIn: 'root'
})
export class VolunteerService {

  private readonly _baseUrl = `${environment.baseUrl}/volunteer`
  private readonly _http = inject(HttpClient)

  getVolunteerById(id:number):Observable<Volunteer>{
    return this._http.get<Volunteer>(`${this._baseUrl}/user/${id}`)
  }

  registerVolunteer(volunteer:Volunteer){
    return this._http.post(`${this._baseUrl}`,{...volunteer})
  }

  updateVolunteer(id:number, volunteer:Partial<Volunteer>){
    return this._http.patch(`${this._baseUrl}/${id}`, {...volunteer})
  }

  deleteVolunteer(id:number){
    return this._http.delete(`${this._baseUrl}/${id}`)
  }

}
