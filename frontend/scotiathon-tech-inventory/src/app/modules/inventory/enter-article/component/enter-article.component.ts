import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Brand } from 'src/app/core/model/brand.model';
import { BrandService } from 'src/app/core/services/brand.service';
import { CategoryService } from 'src/app/core/services/category.service';
import { Category } from 'src/app/core/model/category.model';
import { ModelService } from 'src/app/core/services/model.service';
import { Model } from 'src/app/core/model/model.model';
import { Operation } from 'src/app/core/model/operation.model';
import { OperationService } from 'src/app/core/services/operation.service';
import { CostCenter } from 'src/app/core/model/cost-center.model';
import { CostCenterService } from 'src/app/core/services/cost-center.service';
import { Warehouse } from 'src/app/core/model/warehouse.model';
import { State } from 'src/app/core/model/state.model';
import { WarehouseService } from 'src/app/core/services/warehouse.service';
import { StateService } from 'src/app/core/services/state.service';
import { MatTableDataSource } from '@angular/material/table';
import { Product } from 'src/app/core/model/product.model';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ProductService } from 'src/app/core/services/product.service';

@Component({
  selector: 'app-enter-article',
  templateUrl: './enter-article.component.html',
  styleUrls: ['./enter-article.component.scss']
})
export class EnterArticleComponent implements OnInit {

  fg: FormGroup;
  brands: String[];
  categories: Category[];
  models: Model[];
  operations: Operation[];
  costCenters: CostCenter[];
  warehouses: Warehouse[];
  states: State[];
  products: Product[];
  dataSource = new MatTableDataSource<any>();
  displayedColumns: string[] = ['buyOrder', 'billNumber', 'serial', 'category', 'brand', 'model', 'gbsSerial', 'warehouse', 'state', 'costCenter'];

  constructor(
    private fb: FormBuilder,
    private brandService: BrandService,
    private categoryService: CategoryService,
    private modelService: ModelService,
    private operationService: OperationService,
    private costCenterService: CostCenterService,
    private warehouseService: WarehouseService,
    private stateService: StateService,
    private productService: ProductService,
    private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.products = [];
    this.dataSource.data = this.products;

    this.fg = this.fb.group({
      'buyOrder': [''],
      'billNumber': [''],
      'serial': [''],
      'gbsSerial': [''],
      'brand': [''],
      'category': [''],
      'model': [''],
      'operation': [''],
      'costCenter': [''],
      'warehouse': [''],
      'state': [''],
    });

    //Load Categories
    this.categoryService.get().subscribe((categories) => {
      this.categories = categories;
    });

    //Load Operations
    this.operationService.get().subscribe((operations) => {
      this.operations = operations;
    });

    //Load warehouses
    this.warehouseService.get().subscribe((warehouses) => {
      this.warehouses = warehouses;
    });

    //Load states
    this.stateService.get().subscribe((states) => {
      this.states = states;
    });

    //Event to select category
    this.fg.get('category').valueChanges.subscribe((category) => {
      this.selectCategory(category);
    });

    //Event to select brand
    this.fg.get('brand').valueChanges.subscribe((brand) => {
      this.selectBrand(this.fg.get('category').value, brand);
    });

    //Event to select operation
    this.fg.get('operation').valueChanges.subscribe((operation) => {
      this.selectOperation(operation);
    });
  }

  selectCategory(category: Category) {
    this.brandService.get(category.id).subscribe((brands) => {
      this.brands = brands;
    });
  }

  selectBrand(category: Category, brand: string) {
    this.modelService.get(category.id, brand).subscribe((models) => {
      this.models = models;
    });
  }

  selectOperation(operation: Operation) {
    this.costCenterService.get(operation.id).subscribe((costCenters) => {
      this.costCenters = costCenters;
    });
  }

  addProduct() {
    //Valid serial and gbsSerial
    if (this.products.filter(product => product.serial == this.fg.get('serial').value).length > 0) {
      this._snackBar.open("El serial " + this.fg.get('serial').value + " ya se encuentra registrado", "OK", { duration: 3000 });
    } else if (this.products.filter(product => product.gbsSerial == this.fg.get('gbsSerial').value).length > 0) {
      this._snackBar.open("El serial GBS " + this.fg.get('gbsSerial').value + " ya se encuentra registrado", "OK", { duration: 3000 });
    } else {
      let product = {
        buyOrder: this.fg.get('buyOrder').value,
        billNumber: this.fg.get('billNumber').value,
        serial: this.fg.get('serial').value,
        gbsSerial: this.fg.get('gbsSerial').value,
        brand: this.fg.get('brand').value,
        category: this.fg.get('category').value,
        model: this.fg.get('model').value,
        operation: this.fg.get('operation').value,
        costCenter: this.fg.get('costCenter').value,
        warehouse: this.fg.get('warehouse').value,
        state: this.fg.get('state').value,
      };
      this.products.push(product);
      this.dataSource.data = this.products;
      this.fg.get('serial').setValue("");
      this.fg.get('gbsSerial').setValue("");
    }
  }

  saveProducts() {
    console.log(JSON.stringify(this.products));
    this.productService.save(this.products).subscribe((response: string) => {
      if(response == "OK") {
        this._snackBar.open("Los productos han sido ingresados", "OK", { duration: 3000 });
      } else {  
        this._snackBar.open("Ha ocurrido un error en el ingreso de productos. Por favor intentelo de nuevo", "OK", { duration: 3000 });
      }
    });
  }
}
