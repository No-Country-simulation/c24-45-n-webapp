export enum Cause {
  ENVIRONMENT,
  CHILDRENANDYOUTH,
  OLDERADULTS,
  ANIMALS,
  EDUCATION,
  HEALTH,
  ARTANDCULTURE,
  CONSTRUCTION,
  OTHERS
}

export interface Organization {
  name: string;
  description: string;
  cause: Cause;
  phone: number;
  webSite: string;
  socialMedia: string;
  userOrganizationId: number;
}

export type CreateOrganization = Omit<Organization,"userOrganizationId">

