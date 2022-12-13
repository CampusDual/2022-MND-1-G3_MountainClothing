import { DataSource } from '@angular/cdk/table';
import { BehaviorSubject } from 'rxjs';
import { finalize } from 'rxjs/operators';
import { PrendasService } from 'src/app/services/prendas.service';
import { Prendas } from '../prendasweb';
import { AnyPageFilter } from '../rest/filter';

export class PrendasDataSource extends DataSource<Prendas> {
  prendasSubject = new BehaviorSubject<Prendas[]>([]);
  loadingSubject = new BehaviorSubject<boolean>(false);
  public loading$ = this.loadingSubject.asObservable();
  public totalElements: number;

  constructor(private prendasService: PrendasService) {
    super();
  }

  getPrendas(pageFilter: AnyPageFilter) {
    this.prendasSubject.next([]);
    this.loadingSubject.next(true);
    this.prendasService.getPrendas(pageFilter).pipe(
      finalize(() => this.loadingSubject.next(false))
    ).subscribe(
      response => {
        this.totalElements = response.totalElements;
        this.prendasSubject.next(response.data);
      }
    );
  }

  connect(): BehaviorSubject<Prendas[]> {
    return this.prendasSubject;
  }

  disconnect(): void {
    this.prendasSubject.complete();
    this.loadingSubject.complete();
  }
}
