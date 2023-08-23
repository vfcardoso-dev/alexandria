import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

@Component({
    selector: 'author-create',
    templateUrl: './author-create.component.html',
    styleUrls: ['./author-create.component.scss']
})

export class AuthorCreateComponent implements OnInit{

    constructor(private http: HttpClient, private router:Router){}

    ngOnInit() {                        
    }

}    