import { Component, OnInit } from '@angular/core';
import { PalavraChave } from './palavra-chave.model';
import { PalavraChaveService } from './palavra-chave.service';

@Component({
  selector: 'app-palavras-chave',
  templateUrl: './palavras-chave.component.html',
  styleUrls: ['./palavras-chave.component.css']
})
export class PalavrasChaveComponent implements OnInit {

  public palavrasChave: PalavraChave[] = [];

  constructor(
    private readonly palavraChaveService: PalavraChaveService,
  ) { }

  ngOnInit(): void {
    this.palavraChaveService.getAll().subscribe((palavrasChave: PalavraChave[]) => {
      this.palavrasChave = palavrasChave;
    });
  }

}
