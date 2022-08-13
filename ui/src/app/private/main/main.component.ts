import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { environment } from "src/environments/environment";

@Component({
    selector: 'main',
    template: `<p>Logado!</p><br>
               <button mat-flat-button color="primary" (click)="test()">Teste</button>     
               <button mat-flat-button (click)="logout()">Logout</button><br/>
               <span [innerText]="message"><br/></span><button mat-flat-button (click)="limpar()">Limpar</button>`
})
export class MainComponent {

    message:  string = "";
    
    constructor(private http: HttpClient, private router:Router){}    
    
    public test = () => {
        this.http.get(`${environment.apiUrl}/api/test`)
        .subscribe(res =>{                                      
            this.message = JSON.parse(JSON.stringify(res)).message;        
        });
    }

    public limpar = () => {
        this.message = "";
    }

    public logout = () => {
        this.router.navigateByUrl('/app/logout');   
    }
}