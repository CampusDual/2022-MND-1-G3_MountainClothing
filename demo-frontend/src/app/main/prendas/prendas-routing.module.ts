import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PaginaprendasComponent } from './paginaprendas/paginaprendas.component';

const routes: Routes = [
  { path: "", 
  component: PaginaprendasComponent },
  //{ path: 'add' component: EditContactComponent },
  //{ path: 'edit/id', component: EditContactComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PrendasRoutingModule { }
