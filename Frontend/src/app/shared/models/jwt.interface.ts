export interface TokenData {
  token: string;
  volunteerId: number;
  name: null;
  lastname: null;
  birthday: null;
  address: Address;
  preference: null;
  phone: number;
  skills: null;
  user: User;
}

export interface User {
  userName: string;
  email: string;
  rol: string;
}

export interface Address {
  country : string,
  state : string,
  city : string,
  street: string,
  cp: string
}
