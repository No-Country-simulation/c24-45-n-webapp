export enum Preference {
  ENVIRONMENTALIST,
  SOCIAL,
  GERIATRICIAN,
  ANIMALIST,
  EDUCATIONAL,
  HEALTH,
  CULTURAL,
  CONSTRUCTION,
  GENERAL
}

export enum Skill {
  HEALTH,
  TUTORIA,
  ENVIRONMENT,
  TECHNOLOGICAL,
  LEGALADVISOR,
  GENERAL,
  EMERGENCY,
  PROFESSIONALADVISORY
}

export interface Volunteer {
  name:            string;
  lastname:        string;
  birthday:        Date;
  country:         string;
  state:           string;
  city:            string;
  preference:      Preference;
  phone:           number;
  street:          string;
  cp:              string;
  skills:          Skill[];
  userVolunteerId: number;
}
