import { Component, OnInit } from '@angular/core';
import { cliente } from '../cliente';

@Component({
  selector: 'app-clientes-form',
  templateUrl: './clientes-form.component.html',
  styleUrls: ['./clientes-form.component.css']
})
export class ClientesFormComponent implements OnInit {

  cliente!: cliente;
  
  constructor() { }

  ngOnInit(): void {
  }

}
