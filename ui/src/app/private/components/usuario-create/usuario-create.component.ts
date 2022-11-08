import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { Router } from "@angular/router";


  
@Component({
    selector: 'usuario-create',
    templateUrl: './usuario-create.component.html',
    styleUrls: ['./usuario-create.component.scss'],
})


export class UsuarioCreateComponent{

    constructor(private http: HttpClient, private router:Router){}
    
}