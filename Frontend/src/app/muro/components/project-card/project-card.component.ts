import { Component, effect, input } from '@angular/core';
import { Project } from '../../../shared/models/project.interface';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'project-card',
  imports: [RouterLink],
  templateUrl: './project-card.component.html',
  styleUrl: './project-card.component.css'
})
export class ProjectCardComponent {
  project = input.required<Project>()

  constructor(){
    effect(()=>{
      console.log(this.project())
    })
  }
}
