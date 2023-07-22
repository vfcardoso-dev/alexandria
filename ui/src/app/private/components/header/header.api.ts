import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";

@Injectable()
export class HeaderApi {
    constructor(private http: HttpClient){}

    public getUserInfo(): Observable<any> {
        return this.http.get(`${environment.apiUrl}/api/user/info.json`);
    }    
}