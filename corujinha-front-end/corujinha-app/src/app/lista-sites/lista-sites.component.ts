import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { ListaSitesService } from './lista-sites.service';
import { Site } from './sites.model';

@Component({
  selector: 'app-lista-sites',
  templateUrl: './lista-sites.component.html',
  styleUrls: ['./lista-sites.component.css']
})
export class ListaSitesComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name', 'url', 'language'];
  dataSource;

  // @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(
    private readonly listaService: ListaSitesService,
  ) { }

  ngOnInit(): void {
    this.listaService.getSitesByKeyWordId(1).subscribe((lista: Site[]) => {
      console.log(lista);
      this.dataSource = new MatTableDataSource<Site>(lista);
    });
  }

  ngAfterViewInit() {
    // this.dataSource.paginator = this.paginator;
  }
}
