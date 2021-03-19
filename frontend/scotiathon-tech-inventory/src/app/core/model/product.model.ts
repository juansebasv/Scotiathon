import { Brand } from './brand.model';
import { CostCenter } from './cost-center.model';
import { Warehouse } from './warehouse.model';
import { Category } from './category.model';
import { Model } from './model.model';
import { Operation } from './operation.model';
import { State } from './state.model';

export class Product {
    public buyOrder: string;
    public billNumber: string;
    public serial: string;
    public gbsSerial: string;
    public brand: Brand;
    public category: Category;
    public model: Model;
    public operation: Operation;
    public costCenter: CostCenter;
    public warehouse: Warehouse;
    public state: State;
}