import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { catchError, Observable, throwError } from "rxjs";
import { environment } from "src/environments/environment";


export interface CopyForm {
    code: FormControl<string | null>, 
    titleId: FormControl<string | null> 
}


@Component({
    selector: 'copy-create',
    templateUrl: './copy-create.component.html',
    styleUrls: ['./copy-create.component.scss']
})

export class CopyCreateComponent implements OnInit{

    
    public titles = Array();

    public form: FormGroup = new FormGroup<CopyForm>({ 
        code: new FormControl('',[Validators.required]),
        titleId: new FormControl('',[Validators.required])
    })

    
    constructor(private http: HttpClient, private router:Router){}

    ngOnInit() {      
        this.http.post<any[]>(`${environment.apiUrl}/api/title/grid/list.json`, {  }).subscribe(data => {                                              
            this.titles = data;
          });                     
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
        const body = JSON.stringify(copyForm);                
        return this.http.post<CopyForm>(`${environment.apiUrl}/api/copy/add`, body,{'headers': headers})
                        .pipe(catchError(this.handleError));                        
    }

    public submit = () => {
        const code = this.form.get('code')?.value;
        const titleId = this.form.get('titleId')?.value;
        const copyForm : CopyForm = {code: code, titleId: titleId};
       
        this.addCopy(copyForm)
        .subscribe(            
                () => this.router.navigate(['/app/library/copies/list'])
        );       
    }

}