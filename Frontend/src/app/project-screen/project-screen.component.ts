import { Component, effect, input, signal } from '@angular/core';
import { MainNavbarComponent } from '../features/main/layout/main-navbar/main-navbar.component'; 
import { ProjectService } from '../core/services/project.service';
import { Project } from '../shared/models/project.interface';

@Component({
  selector: 'app-project-screen',
  standalone: true,
  imports: [MainNavbarComponent],
  templateUrl: './project-screen.component.html',
  styleUrl: './project-screen.component.css'
})
export class ProjectScreenComponent {
  id=input<number>()
  project=signal<Project | null>(null)
  constructor(
    private projectSvc:ProjectService
  ){
    //this.getProjectById(this.id())
    effect(()=>{
      console.log(this.id())
      //this.getProjectById(this.id())
      console.log(this.project())
    })
  }
  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    console.log(this.id())
    this.getProjectById(this.id())
  }
  getProjectById(id:any){
    this.projectSvc.getProjectbyId(id).subscribe({
      next:response=>{
        this.project.set(response)
      }
    })
  }
}
