import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { EditPaginaprendasComponent } from './edit-paginaprendas/edit-paginaprendas.component';

import { PaginaprendasComponent } from './paginaprendas/paginaprendas.component';

const routes: Routes = [
  { path: "", 
  component: PaginaprendasComponent },

  { path: 'add', component: EditPaginaprendasComponent },
  { path: 'edit/:id', component: EditPaginaprendasComponent }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PrendasRoutingModule { }
