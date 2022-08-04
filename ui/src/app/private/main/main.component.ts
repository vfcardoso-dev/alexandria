import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { environment } from "src/environments/environment";

@Component({
    selector: 'main',
    template: '<p>Logado!</p><br><button mat-flat-button (click)="test()">Teste</button>'
})
export class MainComponent {

    constructor(private http: HttpClient){}
    
    public test = () => {
        this.http.get(`${environment.apiUrl}/api/test`).subscribe(res => console.log(res));
    }
}