import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { environment } from "src/environments/environment";
import { TitleGridModel } from "../title-list/title-list.component";
import { AuthorGridModel } from "../author-list/author-list.component";


export interface CopyListModel{

    id: string;
    code: string;    
    titleModel: TitleGridModel;
}

@Component({
    selector: 'copy-list',
    templateUrl: './copy-list.component.html',
    styleUrls: ['./copy-list.component.scss'],
})
export class CopyListComponent implements OnInit{


    constructor(private http: HttpClient, private router:Router){}

    copyData: CopyListModel[] = [];  
    displayedColumns: string[] = ['id', 'number', 'title', 'author'];
    dataSource = this.copyData;

    public loadDisplayData = () => {

        
        this.http.post<CopyListModel[]>(`${environment.apiUrl}/api/copy/grid/list.json`, {  }).subscribe(data => {                                              
          this.copyData = data;
        });
        
    }

    //TODO:Abstrair
    public displayAuthors(authorSet: AuthorGridModel[]): string{
        let authors: string = "";
        authorSet.forEach((author, index) => {            
            
            authors = authors + author.name + ' ' + author.lastName;
            if(author.pseudonym !== null)
              authors = authors + ' (' + author.pseudonym + ')'; 
            
            if(index < authorSet.length-1){
              authors = authors + ',  ';                
            }
        });
        
        return authors;
    }
  
    ngOnInit() {        
      this.loadDisplayData();                  
    }

}    