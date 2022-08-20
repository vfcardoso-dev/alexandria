import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { Router } from "@angular/router";


export interface Usuario {
    id: string;
    createdAt: string;
    email: string;
    name: string;
    role: string;
  }

  const ELEMENT_DATA: Usuario[] = [
    {id: '0xFD9E9F8AC7CD4827853BCC8F94A15A81[...]', createdAt: '2022-07-23 12:19:07.9090000', email: 'admin@vfcardoso.dev', name:'Alexandria Sysadmin', role: 'ADMIN'},
  ];

@Component({
    selector: 'usuarios',
    templateUrl: './usuarios.component.html',
    styleUrls: ['./usuarios.component.scss'],
})

export class UsuarioListComponent{

    constructor(private http: HttpClient, private router:Router){}

    displayedColumns: string[] = ['id', 'createdAt', 'email', 'name','role'];
    dataSource = ELEMENT_DATA;
    
}