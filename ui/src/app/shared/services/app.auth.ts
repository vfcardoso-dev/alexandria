import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { map, Observable, of } from "rxjs";
import { environment } from "src/environments/environment";

export interface IToken { token: string }

@Injectable({providedIn: "root"})
export class AuthService {
    
    constructor(private http: HttpClient){}

    public login = (email: string, password: string): Observable<IToken> => {
        return this.http.post(`${environment.apiUrl}/authenticate`, { username: email, password: password })
            .pipe(map(token => {
                localStorage.setItem("token", JSON.stringify(token))
                return token as IToken
            }));
    }

    public logout = (): Observable<void> => {
        localStorage.removeItem("token");
        return of();
    }

    public isAuthenticated = (): boolean => Boolean(localStorage.getItem("token"));

    public getToken = (): IToken => {
        const token = localStorage.getItem("token");
        return token ? JSON.parse(token) : undefined;
    }
}