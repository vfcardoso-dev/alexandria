import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { catchError, Observable, throwError } from "rxjs";
import { environment } from "src/environments/environment";


export interface CopyForm {
    name: FormControl<string | null> 
}


@Component({
    selector: 'member-create',
    templateUrl: './member-create.component.html',
    styleUrls: ['./member-create.component.scss']
})

export class MemberCreateComponent implements OnInit{

    

    public form: FormGroup = new FormGroup<CopyForm>({ 
        name: new FormControl('',[Validators.required])               
    })

    
    constructor(private http: HttpClient, private router:Router){}

    ngOnInit() {      
                          
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

    private addCopy(copyForm: CopyForm): Observable<any> {
        const headers = { 'content-type': 'application/json'}  
        const body=JSON.stringify(copyForm);                
        return this.http.post<CopyForm>(`${environment.apiUrl}/api/copy/add`, body,{'headers':headers})
                        .pipe(catchError(this.handleError));                        
    }

    public submit = () => {
        const name = this.form.get('name')?.value;        
        const copyForm : CopyForm = {name:name};    
       
        this.addCopy(copyForm)
        .subscribe(            
                () => this.router.navigate(['/app/library/copies/list'])
        );
       
    }

}