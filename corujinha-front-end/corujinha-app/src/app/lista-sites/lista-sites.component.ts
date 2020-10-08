import { Component, OnInit } from '@angular/core';
import { ListaSitesService } from './lista-sites.service';
import { Site } from './sites.model';

@Component({
  selector: 'app-lista-sites',
  templateUrl: './lista-sites.component.html',
  styleUrls: ['./lista-sites.component.css']
})
export class ListaSitesComponent implements OnInit {

  constructor(
    private readonly listaService: ListaSitesService,
  ) { }

  ngOnInit(): void {
    this.listaService.getSitesByKeyWordId(1).subscribe((lista: Site[]) => {
      console.log(lista);
    });
  }

}
