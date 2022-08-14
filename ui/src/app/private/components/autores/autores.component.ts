import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { Router } from "@angular/router";

@Component({
    selector: 'autores',
    template: '<marquee>Autores Aqui</marquee>'
})
export class AutorListComponent{

    constructor(private http: HttpClient, private router:Router){}
    
}