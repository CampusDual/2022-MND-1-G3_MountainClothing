import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainHomeComponent } from './main-home/main-home.component';
import { AuthGuard } from '../auth/auth.guard';
import { ContactsComponent } from './contacts/contacts.component';
import { PaginaprendasComponent } from './prendas/paginaprendas/paginaprendas.component';

const routes: Routes = [
  {
    path: 'main',
    component: MainHomeComponent,
    canActivate: [AuthGuard],
    data: {
      allowedRoles: ['HOME','PRENDAS','CONTACTS'],
    },
  },
  {
    path: 'contacts',
    component: ContactsComponent,
    canActivate: [AuthGuard],
    data: {
      allowedRoles: ['CONTACTS'],
    },
  },
  {
    path: 'prendas',
    component: PaginaprendasComponent,
    canActivate: [AuthGuard],
    data: {
      allowedRoles: ['PRENDAS'],
    },
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class MainRoutingModule {}
