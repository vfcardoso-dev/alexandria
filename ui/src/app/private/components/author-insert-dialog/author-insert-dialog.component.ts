import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Component, Inject, OnInit } from "@angular/core";
import { FormBuilder, Validators } from "@angular/forms";
import { MAT_DIALOG_DATA, MatDialogRef } from "@angular/material/dialog";
import { MatSnackBar } from "@angular/material/snack-bar";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";

@Component({
    selector: 'author-insert-dialog',
    templateUrl: 'author-insert-dialog.component.html',
    styleUrls: ['author-insert-dialog.component.scss'],
  })
  export class AuthorInsertDialog implements OnInit{

  public form = this.formBuilder.group({
        id:[null],
        name: [null, Validators.required],
        lastName:[null],
        pseudonym: [null]
    });


    public isNew: boolean = true;
    
    constructor(@Inject(MAT_DIALOG_DATA) public data: any,
        public dialogRef: MatDialogRef<AuthorInsertDialog>,
        private formBuilder: FormBuilder, 
        private http: HttpClient,
        private snackbar: MatSnackBar
    ) {}
    
    
    ngOnInit(): void {
        this.isNew = this.data?.id ? false : true;
        
        if(!this.isNew){
            
            const headers = new HttpHeaders().append('Content-Type', 'application/json');
            const params = new HttpParams().append('id', this.data.id );
            this.http
                .get(
                    `${environment.apiUrl}/api/author/get-by-id`, 
                    {headers, params})
                    .subscribe((data: any) => { 
                        
                        this.form.setValue({
                            id: data.id,
                            name: data.name,
                            lastName: data.lastName,
                            pseudonym: data.pseudonym
                        });
                        
                });
        }
        
        
    }    

    
    public submit = () => {
        
        const cmd = { ...this.form.getRawValue() };
                
        this.persistAuthor(cmd)
        .subscribe({
            next: (v) => {
                this.snackbar.open('Autor salvo com sucesso');
                this.dialogRef.close();
        },
            error: (e) => this.snackbar.open("Não foi possível salvar o autor"),
            complete: () => {}
        });
                               
    }
    
    
    private persistAuthor(authorForm: any): Observable<any> {
        const headers = { 'content-type': 'application/json'}  
        const body=JSON.stringify(authorForm); 
        const url = this.isNew ? '/api/author/add' : '/api/author/update';                
        return this.http.post(`${environment.apiUrl}${url}`, body,{'headers':headers});                        
    }
      
  }   