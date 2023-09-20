import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";



export interface MemberForm {
    name: FormControl<string | null> 
}

@Component({
    selector: 'author-create',
    templateUrl: './author-create.component.html',
    styleUrls: ['./author-create.component.scss']
})

export class AuthorCreateComponent implements OnInit{

    public form: FormGroup = new FormGroup<MemberForm>({ 
        name: new FormControl('',[Validators.required])               
    })
    
    constructor(private http: HttpClient, private router:Router){}

    ngOnInit() {                        
    }

}    