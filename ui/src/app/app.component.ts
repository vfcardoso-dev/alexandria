import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

    constructor(private http: HttpClient){}

    title = 'loading...';
    env = 'loading...';

    ngOnInit() {
        this.http.get('http://localhost:8080/test').subscribe((res: any) => {
            this.title = res.appName;
            this.env = res.envName;
        })
    }
}
