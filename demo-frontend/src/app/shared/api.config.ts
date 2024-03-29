import { environment } from '../../environments/environment';

export const API_CONFIG = {
  authUrl: environment.authBaseUrl,
  login: environment.authBaseUrl + '/oauth/token',
  logout: environment.authBaseUrl + '/logout',
  getAllProfiles: environment.adminBaseUrl + '/getAllProfiles',
  getAllSections: environment.adminBaseUrl + '/getAllSections',



  // Contacts API
  getContacts: environment.contactsBaseUrl + '/getContacts',
  getContact: environment.contactsBaseUrl + '/getContact',
  createContact: environment.contactsBaseUrl + '/createContact',
  editContact: environment.contactsBaseUrl + '/editContact',
  deleteContact: environment.contactsBaseUrl + '/deleteContact',

  // Prendas API
  getPrendas: environment.prendasBaseUrl + '/getPrendas',
  getPrenda: environment.prendasBaseUrl + '/getPrenda',
  createPrendas: environment.prendasBaseUrl + '/createPrendas',
  editPrendas: environment.prendasBaseUrl + '/editPrendas',
  deletePrendas: environment.prendasBaseUrl + '/deletePrendas',

};
