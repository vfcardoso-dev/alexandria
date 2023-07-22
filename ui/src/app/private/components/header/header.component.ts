import { Component, OnInit } from "@angular/core";
import { HeaderApi } from "./header.api";

@Component({
    selector: 'header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.scss'],
    providers: [HeaderApi]
})
export class HeaderComponent implements OnInit {
    public user: any;

    constructor(private headerApi: HeaderApi){}
    
    ngOnInit(): void {
        this.headerApi.getUserInfo().subscribe(user => this.user = user);
    }
}