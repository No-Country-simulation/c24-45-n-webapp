import { Component, computed, inject, signal } from '@angular/core';
import { ProjectCardComponent } from './components/project-card/project-card.component';
import { JwtService } from '../core/services/jwt.service';
import { TitleCasePipe } from '@angular/common';
import { ProjectService } from '../core/services/project.service';
import { Project } from '../shared/models/project.interface';
import { MainNavbarComponent } from "../features/main/layout/main-navbar/main-navbar.component";
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-muro',
  imports: [ProjectCardComponent, TitleCasePipe, MainNavbarComponent, RouterModule],
  templateUrl: './muro.component.html',
  styleUrl: './muro.component.css'
})
export class MuroComponent {

  private readonly jwtSvc = inject(JwtService)
  private readonly projectSvc = inject(ProjectService)

  user = computed(()=> this.jwtSvc.user())
  projects = signal<Project[]>([])

  constructor() {
    this.getProjects()
  }

  getProjects(){
    this.projectSvc.getProjects().subscribe({
      next:r=>{
        this.projects.set(r)
      },
      error:e=>console.log(e)
    })
  }

}
