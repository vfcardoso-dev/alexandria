import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { catchError, Observable, throwError } from "rxjs";
import { environment } from "src/environments/environment";


export interface LoanForm {
    name: FormControl<string | null> 
}


@Component({
    selector: 'loan-create',
    templateUrl: './loan-create.component.html',
    styleUrls: ['./loan-create.component.scss']
})

export class LoanCreateComponent implements OnInit{

    

    public form: FormGroup = new FormGroup<LoanForm>({ 
        name: new FormControl('',[Validators.required])               
    })

    
    constructor(private http: HttpClient, private router:Router){}

    ngOnInit() {      
                          
    }

    private handleError(error: HttpErrorResponse) {
        if (error.status === 0) {
          // A client-side or network error occurred. Handle it accordingly.
          console.error('An error occurred:', error.error);
        } else {
          // The backend returned an unsuccessful response code.
          // The response body may contain clues as to what went wrong.
          console.error(
            `Backend returned code ${error.status}, body was: `, error.error);
        }
        // Return an observable with a user-facing error message.
        return throwError(() => new Error('Something bad happened; please try again later.'));
    }

    private addTitle(titleForm: LoanForm): Observable<any> {
        const headers = { 'content-type': 'application/json'}  
        const body=JSON.stringify(titleForm);                
        return this.http.post<LoanForm>(`${environment.apiUrl}/api/loan/add`, body,{'headers':headers})
                        .pipe(catchError(this.handleError));                        
    }

    public submit = () => {
        const name = this.form.get('name')?.value;        
        const titleForm : LoanForm = {name:name};    
       
        this.addTitle(titleForm)
        .subscribe(            
                () => this.router.navigate(['/app/library/loans/list'])
        );
       
    }

}