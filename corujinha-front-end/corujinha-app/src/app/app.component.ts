import { Component, Output } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  public title = 'corujinha-app';
  public palavraSelecionada = null;

  constructor() { }

  public onTrocaPalavra(palavraId: number): void {
    console.log(palavraId);
    this.palavraSelecionada = palavraId;
  }
}
