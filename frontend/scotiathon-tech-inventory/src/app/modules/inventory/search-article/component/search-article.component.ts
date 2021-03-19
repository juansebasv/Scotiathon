import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CategoryService } from 'src/app/core/services/category.service';
import { BrandService } from 'src/app/core/services/brand.service';
import { ModelService } from 'src/app/core/services/model.service';
import { Category } from 'src/app/core/model/category.model';
import { Brand } from 'src/app/core/model/brand.model';
import { Model } from 'src/app/core/model/model.model';
import { CostCenter } from 'src/app/core/model/cost-center.model';
import { CostCenterService } from 'src/app/core/services/cost-center.service';
import { WarehouseService } from 'src/app/core/services/warehouse.service';
import { Warehouse } from 'src/app/core/model/warehouse.model';

@Component({
  selector: 'app-search-article',
  templateUrl: './search-article.component.html',
  styleUrls: ['./search-article.component.scss']
})
export class SearchArticleComponent implements OnInit {

  fg: FormGroup;
  categories: Category[];
  brands: string[];
  models: Model[];
  costCenters: CostCenter[];
  warehouses: Warehouse[];

  constructor(
    private fb: FormBuilder,
    private categoryService: CategoryService,
    private brandService: BrandService,
    private modelService: ModelService,
    private costCenterService: CostCenterService,
    private warehouseService: WarehouseService
  ) { }

  ngOnInit(): void {
    this.fg = this.fb.group({
      'buyOrder': [''],
      'billNumber': [''],
      'gbsSerial': [''],
      'serial': [''],
      'category': [''],
      'brand': [''],
      'model': [''],
      'costCenter': [''],
      'warehouse': [''],
    });

    this.categoryService.get().subscribe((categories) => {
      this.categories = categories;
    });

    this.costCenterService.getAll().subscribe((costCenters) => {
      this.costCenters = costCenters;
    });

   this.warehouseService.get().subscribe((warehouses) => {
      this.warehouses = warehouses;
    });

    this.fg.get('category').valueChanges.subscribe((category) => {
      this.selectCategory(category);
    });

    this.fg.get('brand').valueChanges.subscribe((brand) => {
      this.selectBrand(this.fg.get('category').value, brand);
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

  clear() {
    this.fg.reset();
  }

  search() {

  }

  isValid() {
    return this.fg.get('buyOrder').value 
    || this.fg.get('billNumber').value 
    || this.fg.get('gbsSerial').value 
    || this.fg.get('serial').value 
    || this.fg.get('category').value 
    || this.fg.get('brand').value 
    || this.fg.get('model').value
    || this.fg.get('costCenter').value 
    || this.fg.get('warehouse').value;
  }

}
