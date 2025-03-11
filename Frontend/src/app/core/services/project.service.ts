import { inject, Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Project } from '../../shared/models/project.interface';

interface Params {
  name: string;
  location: string;
  type: string;
  status: boolean;
}

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private readonly _baseUrl = `${environment.baseUrl}/project`
  private readonly _http = inject(HttpClient)

  getProjects(): Observable<Project[]> {
    return this._http.get<Project[]>(`${this._baseUrl}`)
  }

  getProjectbyId(id: number): Observable<Project> {
    return this._http.get<Project>(`${this._baseUrl}/${id}`)
  }

  registerProject(project: Project): Observable<any> {
    return this._http.post(`${this._baseUrl}`, { ...project })
  }

  searchProject(params:Partial<Params>): Observable<Project> {
    return this._http.get<Project>(`${this._baseUrl}/search`,{ params })
  }

  registerNewVolunteer(projectId: number, volunteerId: number): Observable<any> {
    return this._http.post(`${this._baseUrl}/${projectId}/volunteers/${volunteerId}`, {})
  }

  updateProject(project:Partial<Project>, id:number):Observable<any>{
    return this._http.put<any>(`${this._baseUrl}/${id}`,{...project})
  }

  deleteProject(id:number):Observable<any>{
    return this._http.delete(`${this._baseUrl}/${id}`)
  }
}
