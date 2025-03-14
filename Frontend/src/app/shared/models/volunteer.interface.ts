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
  name:            null;
  lastname:        null;
  birthday:        null;
  country:         null;
  state:           null;
  city:            null;
  preference:      Preference;
  phone:           number;
  street:          null;
  cp:              null;
  skills:          Skill;
  userVolunteerId: number;
  user:            User;
}

export interface User {
  userName: string;
  email:    string;
  rol:      string;
}
