import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditPrendasComponent } from './edit-prendas/edit-prendas.component';
import { PaginaprendasComponent } from './paginaprendas/paginaprendas.component';

const routes: Routes = [
  { path: "", 
  component: PaginaprendasComponent },
  { path: 'add', component: EditPrendasComponent },
  { path: 'edit/id', component: EditPrendasComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PrendasRoutingModule { }
