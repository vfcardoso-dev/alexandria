import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from "@angular/material/form-field";
import { environment } from "src/environments/environment";
import { catchError, map, Observable, throwError } from "rxjs";


export interface UserForm { 
    name: FormControl<string | null>, 
    email: FormControl<string | null>,
    role:  FormControl<string | null>,
    password: FormControl<string | null>
}
  
@Component({
    selector: 'usuario-create',
    templateUrl: './usuario-create.component.html',
    styleUrls: ['./usuario-create.component.scss']

})

export class UsuarioCreateComponent implements OnInit{

    public securityRoles: Array<string> = [];

    public form: FormGroup = new FormGroup<UserForm>({ 
        name: new FormControl('',[Validators.required]),       
        email: new FormControl('', [Validators.required,Validators.email]),
        role: new FormControl('', [Validators.required]),
        password: new FormControl('',[Validators.required])
    })

    constructor(private http: HttpClient, private router:Router){}

    ngOnInit() {                
        this.refreshSecurityRoles();   
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

    
    private refreshSecurityRoles(){
        const headers = { 'content-type': 'application/json'};
        this.http.post<any>(`${environment.apiUrl}/api/user/get-security-roles`, {'headers':headers}).subscribe(data => {
            this.securityRoles = data;
        });
    }
    


    private addUser(userForm:UserForm): Observable<any> {
        const headers = { 'content-type': 'application/json'}  
        const body=JSON.stringify(userForm);
        console.log(body)
        //return this.http.post(`${environment.apiUrl}/api/user/add`, body,{'headers':headers});
        return this.http.post<UserForm>(`${environment.apiUrl}/api/user/add`, body,{'headers':headers})
                        .pipe(catchError(this.handleError));
    }

    public submit = () => {
        const name = this.form.get('name')?.value;
        const email = this.form.get('email')?.value;
        const role = this.form.get('role')?.value;
        const password = this.form.get('password')?.value;
        const userForm : UserForm = {name:name,email:email,role:role,password:password};    
       
        this.addUser(userForm)
       .subscribe(userForm => console.log(userForm));
       
    }
    
}