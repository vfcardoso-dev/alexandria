import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { environment } from "src/environments/environment";
import { AuthorInsertDialog } from "../author-insert-dialog/author-insert-dialog.component";
import { MatDialog } from "@angular/material/dialog";


export interface AuthorGridModel{

    id:string;
    name:string;
    lastName:string;
    pseudonym:string;    

}

@Component({
    selector: 'author-list',
    templateUrl: './author-list.component.html',
    styleUrls: ['./author-list.component.scss'],
})

export class AuthorListComponent{

    constructor(
      private http: HttpClient, 
      private router: Router,
      public dialog: MatDialog
    ){}

    authorData: AuthorGridModel[] = [];  
    displayedColumns: string[] = ['name', 'pseudonym'];
    dataSource = this.authorData;

    public loadDisplayData = () => {

      this.http.post<AuthorGridModel[]>(`${environment.apiUrl}/api/author/grid/list.json`, {  }).subscribe(data => {                                              
        this.authorData = data;
      });
        
    }
  
    ngOnInit() {        
      this.loadDisplayData();                  
    }

    openDialog(id?: string): void {
        const dialogRef = this.dialog.open(AuthorInsertDialog, {            
          data: { id: id },
          height: '400px',
          width: '600px'
        });

        dialogRef.afterClosed().subscribe(result => {
            //console.log(`Dialog result: ${result}`);
        });        
    }

    
    
}