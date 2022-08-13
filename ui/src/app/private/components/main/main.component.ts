import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { Router } from "@angular/router";

@Component({
    selector: 'main',
    template: `<p>Logado!</p>`
})
export class MainComponent {

    constructor(private http: HttpClient, private router:Router){}    
    
    public logout = () => {
        this.router.navigateByUrl('/app/logout');   
    }
}