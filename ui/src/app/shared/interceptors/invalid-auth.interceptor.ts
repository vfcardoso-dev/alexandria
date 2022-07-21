import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { catchError, from, Observable, throwError } from "rxjs";
import { AuthService } from "../services/app.auth";

@Injectable({providedIn: "root"})
export class InvalidAuthInterceptor implements HttpInterceptor {
    
    constructor(private auth: AuthService, private router: Router){}
    
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        
        return next.handle(req).pipe(
            catchError(error => {
                // handle only 401 error
                if (error instanceof HttpErrorResponse && error.status === 401) {
                    this.auth.logout()
                        .subscribe(() => this.router.navigateByUrl('/login'));
                    
                    return throwError(() => error);
                }

                return next.handle(req);
            })
        );
    }
}