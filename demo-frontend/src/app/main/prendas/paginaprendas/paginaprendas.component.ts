import {
  Component,
  OnInit,
  AfterViewInit,
  ViewChild,
  ElementRef,
} from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { merge, fromEvent, Observable, Observer } from 'rxjs';
import { tap, debounceTime, distinctUntilChanged } from 'rxjs/operators';
import { SelectionModel } from '@angular/cdk/collections';
import { AnyPageFilter, AnyField, SortFilter } from 'src/app/model/rest/filter';
import { TranslateService } from '@ngx-translate/core';
import { Router } from '@angular/router';
import { ConfirmationDialogComponent } from 'src/app/shared/confirmation-dialog/confirmation-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import { Prendas } from 'src/app/model/prendasweb';
import { PrendasDataSource } from 'src/app/model/datasource/prendas.datasource';
import { PrendasService } from 'src/app/services/prendas.service';

@Component({
  // selector: 'app-paginaprendas',
  templateUrl: './paginaprendas.component.html',
  styleUrls: ['./paginaprendas.component.scss']
})
export class PaginaprendasComponent implements OnInit, AfterViewInit {
  dataSource: PrendasDataSource;
  displayedColumns = [
    'nombre',
    'color',
    'precio',
    'prendas',
    'sexo',
    'tallas',
    'unidades',

  ];
  fields = ['nombre', 'color', 'precio', 'prendas', 'sexo', 'tallas', 'unidades'];

  selection = new SelectionModel<Prendas>(true, []);
  error = false; 

  @ViewChild('edit') editTemplate: any;
  highlightedRow: Prendas;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild('input') input: ElementRef;

  constructor(
    private prendasService: PrendasService,
    private translate: TranslateService,
    private router: Router,
    private dialog: MatDialog
  ) { }

  ngOnInit() {
    this.dataSource = new PrendasDataSource(this.prendasService);
    const pageFilter = new AnyPageFilter(
      '',
      this.fields.map((field) => new AnyField(field)),
      0,
      20,
      'nombre'
    );
    this.dataSource.getPrendas(pageFilter);
  }

  ngAfterViewInit(): void {
    // server-side search
    fromEvent(this.input.nativeElement, 'keyup')
      .pipe(
        debounceTime(150),
        distinctUntilChanged(),
        tap(() => {
          this.paginator.pageIndex = 0;
          this.loadPrendasPage();
        })
      )
      .subscribe();

    // reset the paginator after sorting
    this.sort.sortChange.subscribe(() => {
      this.paginator.pageIndex = 0;
      this.selection.clear();
    });

    // on sort or paginate events, load a new page
    merge(this.sort.sortChange, this.paginator.page)
      .pipe(
        tap(() => {
          this.loadPrendasPage();
        })
      )
      .subscribe();
  }

  loadPrendasPage() {
    this.selection.clear();
    this.error = false;
    const pageFilter = new AnyPageFilter(
      this.input.nativeElement.value,
      this.fields.map((field) => new AnyField(field)),
      this.paginator.pageIndex,
      this.paginator.pageSize
    );
    pageFilter.order = [];
    pageFilter.order.push(
      new SortFilter(this.sort.active, this.sort.direction.toString())
    );
    this.dataSource.getPrendas(pageFilter);
  }

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.prendasSubject.value.length;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    this.isAllSelected()
      ? this.selection.clear()
      : this.dataSource.prendasSubject.value.forEach((row) =>
          this.selection.select(row)
        );
  }

  onDelete() {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      width: '350px',
      data: this.translate.instant('delete-element-confirmation'),
    });
    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.delete();
        return new Observable((observer: Observer<boolean>) =>
          observer.next(true)
        );
      } else {
        return new Observable((observer: Observer<boolean>) =>
          observer.next(false)
        );
      }
    });
  }

  delete() {
    const prendas = this.selection.selected[0];
    this.selection.deselect(prendas);
    if (this.selection.selected && this.selection.selected.length === 0) {
      this.prendasService.deletePrenda(prendas.id).subscribe((response) => {
        console.log(response)
        if (response.responseCode !== 'OK') {
           this.error = true;
         } else {
          this.loadPrendasPage();
         }
      });
    } else {
      this.prendasService.deletePrenda(prendas.id).subscribe((response) => {
        console.log(response);
        if (response.responseCode !== 'OK') {
           this.error = true;
        }
        this.delete();
      });
    }
  }

  onAdd() {
    this.router.navigate(['/prendas/add']);
  }

  onEdit(row: Prendas) {
    this.highlightedRow = row;
    this.router.navigate(['/prendas/edit/' + row.id]);
  }

}
