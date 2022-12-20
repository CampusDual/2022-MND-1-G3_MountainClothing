import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PrendasRoutingModule } from './prendas-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { ContactsRoutingModule } from '../contacts/contacts-routing.module';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { TranslateModule } from '@ngx-translate/core';
import { PaginaprendasComponent } from './paginaprendas/paginaprendas.component';
import { EditPaginaprendasComponent } from './edit-paginaprendas/edit-paginaprendas.component';


@NgModule({
  declarations: [
    PaginaprendasComponent,
    EditPaginaprendasComponent,
  ],
  imports: [
    CommonModule,
    PrendasRoutingModule,
    ReactiveFormsModule,
    ContactsRoutingModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    MatPaginatorModule,
    MatProgressSpinnerModule,
    MatSortModule,
    MatTableModule,
    MatCardModule,
    MatCheckboxModule,
    TranslateModule,
  ]
})
export class PrendasModule { }
