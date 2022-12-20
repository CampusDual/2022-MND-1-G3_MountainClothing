import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Prendas } from 'src/app/model/prendasweb';
import { LoggerService } from 'src/app/services/logger.service';
import { PrendasService } from 'src/app/services/prendas.service';

@Component({
  selector: 'app-edit-paginaprendas',
  templateUrl: './edit-paginaprendas.component.html',
  styleUrls: ['./edit-paginaprendas.component.scss']
})
export class EditPaginaprendasComponent implements OnInit {
  idPrendas: number;

  prendasForm: FormGroup;
  prendas: Prendas;
  errores: string[];

  constructor(
    private fb: FormBuilder,
    private prendasService: PrendasService,
    private router: Router,
    private route: ActivatedRoute,
    private logger: LoggerService
  ) {
    this.prendas = new Prendas();
  }

  ngOnInit() {
    this.createFormGroup();
    this.idPrendas = this.route.snapshot.params['id'];
    if (this.idPrendas) {
      this.prendasService.getPrenda(this.idPrendas).subscribe(
        response => {
          this.prendas = response;
          this.prendasForm.patchValue(this.prendas, { emitEvent: false, onlySelf: false });
          this.logger.info(this.prendas);
        }
      );
    }
  }

  onFormChanges() {
    this.prendasForm.valueChanges.subscribe((val) => { });
  }

  createFormGroup() {
    this.prendasForm = this.fb.group({
      id: [this.prendas.id],
      nombre: [this.prendas.nombre],
      precio: [this.prendas.precio],
      color: [this.prendas.color],
      prendas: [this.prendas.prendas],
      sexo: [this.prendas.sexo],
      tallas: [this.prendas.tallas],
      unidades: [this.prendas.unidades],
    });
  }

  save() {
    const newPrendas: Prendas = Object.assign({}, this.prendasForm.value);
    if (newPrendas.id) {
      this.prendasService.editPrenda(newPrendas).subscribe((response) => {
        this.redirectList(response);
      });
    } else {
      this.prendasService.createPrenda(newPrendas).subscribe((response) => {
        this.redirectList(response);
      });
    }
  }

  redirectList(response: any) {
    if (response.responseCode === 'OK') {
      this.router.navigate(['/prendas']);
    } else {
      console.log(response);
    }
  }

  compareObjects(o1: any, o2: any): boolean {
    if (o1 && o2) {
      return o1.id === o2.id;
    } else {
      return false;
    }
  }

  cancel() {
    this.router.navigate(['/prendas']);
  }

}

