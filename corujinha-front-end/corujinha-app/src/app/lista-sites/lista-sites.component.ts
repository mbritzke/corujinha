import { Component, Input, OnChanges, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ListaSitesService } from './lista-sites.service';
import { Site } from './sites.model';

@Component({
  selector: 'app-lista-sites',
  templateUrl: './lista-sites.component.html',
  styleUrls: ['./lista-sites.component.css']
})
export class ListaSitesComponent implements OnInit, OnChanges {

  public displayedColumns: string[] = ['id', 'name', 'url', 'language'];
  public dataSource;

  @Input()
  public palavraId: number;

  constructor(
    private readonly listaService: ListaSitesService,
  ) { }

  ngOnInit(): void {}

  ngOnChanges(): void {
    if (!this.palavraId) {
      return;
    }

    this.listaService.getSitesByKeyWordId(this.palavraId).subscribe((lista: Site[]) => {
      console.log(lista);
      this.dataSource = new MatTableDataSource<Site>(lista);
    });
  }
}
