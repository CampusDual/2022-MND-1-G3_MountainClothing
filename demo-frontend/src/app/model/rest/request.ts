import { Contact } from '../contact';
import { Prendas } from '../prendasweb';

export class QuerySortPaginationRequest {
  query: string;
  pageIndex: number;
  pageSize: number;
  sortDirection: string;
  sortColumn: string;

  constructor(query: string, pageIndex: number, pageSize: number, sortDirection: string, sortColumn: string) {
    this.query = query;
    this.pageIndex = pageIndex;
    this.pageSize = pageSize;
    this.sortDirection = sortDirection;
    this.sortColumn = sortColumn;
  }
}

export class CreateContactRequest {
  name: string;
  surname1: string;
  surname2: string;
  phone: number;
  email: string;

  constructor(contact: Contact) {
    this.name = contact.name;
    this.surname1 = contact.surname1;
    this.surname2 = contact.surname2;
    this.phone = contact.phone;
    this.email = contact.email;
  }
}

export class EditContactRequest extends CreateContactRequest {
  id: number;

  constructor(contact: Contact) {
    super(contact);
    this.id = contact.id;
  }
}
export class CreatePrendaRequest {
  nombre: string;
  tallas: string;
  sexo: string;
  prendas: string;
  color: string;
  precio: number;
  unidades: number;

  constructor(prenda: Prendas) {
    this.nombre = prenda.nombre;
    this.tallas = prenda.tallas;
    this.sexo = prenda.sexo;
    this.prendas = prenda.prendas;
    this.color = prenda.color;
    this.precio = prenda.precio;
    this.unidades = prenda.unidades;
  }
}
export class EditPrendaRequest extends CreatePrendaRequest {
  id: number;

  constructor(prenda: Prendas) {
    super(prenda);
    this.id = prenda.id;
  }
}