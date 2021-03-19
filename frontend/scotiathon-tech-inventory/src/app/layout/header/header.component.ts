import { Component, OnInit } from '@angular/core';
import { VERSION } from 'src/app/core/constants/constants';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  public version: string;

  constructor() { }

  ngOnInit(): void {
    this.version = VERSION;
  }

}
