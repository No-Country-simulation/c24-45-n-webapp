import { Component, signal } from '@angular/core';
import { Company } from '../../models/company.interface';
import { companies } from '../../data/companies';

@Component({
  selector: 'companies-working-with-us',
  imports: [],
  templateUrl: './companies-working-with-us.component.html',
  styleUrl: './companies-working-with-us.component.css',
})
export class CompaniesWorkingWithUsComponent {
  companies = signal<Company[]>(companies);
}
