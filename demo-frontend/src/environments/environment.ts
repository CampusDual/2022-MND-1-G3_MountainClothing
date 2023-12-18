// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  apiBaseUrl: 'http://localhost:30062' ,
  authBaseUrl: 'http://localhost:30062',
  adminBaseUrl: 'http://localhost:30062',
  contactsBaseUrl: 'http://localhost:30062/contacts',
  prendasBaseUrl: 'http://localhost:30062/prendas',
  loginBaseUrl: 'http://localhost:30062/login',
  clientName: 'demo',
  clientSecret: '8Fjkk59bXKws8bmMNFZB',
  isDebugMode: false,
  idle: 1,
  idleTimeout: 900,
  idlePingInterval: 15
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
