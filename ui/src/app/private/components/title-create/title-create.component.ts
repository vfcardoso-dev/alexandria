import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { catchError, Observable, throwError } from "rxjs";
import { environment } from "src/environments/environment";


export interface TitleForm {
    name: FormControl<string | null>,
    authors: FormControl<string[] | null>
}


@Component({
    selector: 'title-create',
    templateUrl: './title-create.component.html',
    styleUrls: ['./title-create.component.scss']
})

export class TitleCreateComponent implements OnInit{

    
    public authors = Array();

    public form: FormGroup = new FormGroup<TitleForm>({ 
        name: new FormControl('',[Validators.required]),
        authors: new FormControl(this.authors,[Validators.required])
    })

    
    constructor(private http: HttpClient, private router:Router){}

    ngOnInit() {      
       //TODO: Create Api classes        
       this.http.post<any[]>(`${environment.apiUrl}/api/author/grid/list.json`, {  }).subscribe(data => {                                              
        this.authors = data;
      });
       
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
    

    private addTitle(titleForm: TitleForm): Observable<any> {
        const headers = { 'content-type': 'application/json'}  
        const body=JSON.stringify(titleForm);                
        return this.http.post<TitleForm>(`${environment.apiUrl}/api/title/add`, body,{'headers':headers})
                        .pipe(catchError(this.handleError));                        
    }

    public submit = () => {
        const name = this.form.get('name')?.value;
        const authorIds = this.form.get('authors')?.value; 
        const titleForm : TitleForm = {name:name, authors: authorIds.map((x:string)=> { return { id:x } })};      
    
        this.addTitle(titleForm)
        .subscribe(            
                () => this.router.navigate(['/app/library/titles/list'])
        );
           
    }

}