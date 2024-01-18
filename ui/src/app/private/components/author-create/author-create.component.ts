import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { Observable, catchError, throwError } from "rxjs";
import { environment } from "src/environments/environment";



export interface AuthorForm {
    name: FormControl<string | null>,
    lastName: FormControl<string | null>,
    pseudonym: FormControl<string | null>
}

@Component({
    selector: 'author-create',
    templateUrl: './author-create.component.html',
    styleUrls: ['./author-create.component.scss']
})

export class AuthorCreateComponent implements OnInit{

    public form: FormGroup = new FormGroup<AuthorForm>({ 
        name: new FormControl('',[Validators.required]),               
        lastName: new FormControl(''),
        pseudonym: new FormControl('')
    })
    
    constructor(private http: HttpClient, private router:Router){}

    ngOnInit() {                        
    }


    public submit = () => {
        const name = this.form.get('name')?.value;  
        const lastName = this.form.get('lastName')?.value; 
        const pseudonym = this.form.get('pseudonym')?.value; 
        const authorForm : AuthorForm = 
            {
                name: name,
                lastName: lastName,
                pseudonym: pseudonym
            };

        this.addAuthor(authorForm)
        .subscribe(            
            () => this.router.navigate(['/app/library/author/list'])
        );
       
    }

     //TODO:Abstrair
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


    private addAuthor(authorForm: AuthorForm): Observable<any> {
        const headers = { 'content-type': 'application/json'}  
        const body=JSON.stringify(authorForm);                
        return this.http.post<AuthorForm>(`${environment.apiUrl}/api/author/add`, body,{'headers':headers})
                        .pipe(catchError(this.handleError));                        
    }

}    