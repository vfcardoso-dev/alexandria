import { HttpClient } from "@angular/common/http";
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
    }    

    
    public submit = () => {
        
        const cmd = { ...this.form.getRawValue() };
        
        this.addAuthor(cmd)
        .subscribe({
            next: (v) => {
                this.snackbar.open('Autor salvo com sucesso');
                this.dialogRef.close();
            },
            error: (e) => this.snackbar.open(e),
            complete: () => console.info('complete') 
        });
        
    }
            
    private addAuthor(authorForm: any): Observable<any> {
        const headers = { 'content-type': 'application/json'}  
        const body=JSON.stringify(authorForm);                
        return this.http.post(`${environment.apiUrl}/api/author/add`, body,{'headers':headers});                        
    }

  }   