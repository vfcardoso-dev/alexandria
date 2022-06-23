import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

    constructor(private http: HttpClient){}

    public title: string = 'loading...';
    public env: string = 'loading...';

    ngOnInit() {
        this.http.get(`${environment.apiUrl}/test`).subscribe((res: any) => {
            this.title = res.appName;
            this.env = res.envName;
        })
    }
}
