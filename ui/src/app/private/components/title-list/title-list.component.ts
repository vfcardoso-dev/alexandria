import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { environment } from "src/environments/environment";


export interface TitleGridModel{

    id:string;
    nome:string;
    sobrenome:string;
    pseudonimo:string;    

}

@Component({
    selector: 'title-list',
    templateUrl: './title-list.component.html',
    styleUrls: ['./title-list.component.scss'],
})

export class TitleListComponent{

    constructor(private http: HttpClient, private router:Router){}

    titleData: TitleGridModel[] = [];  
    displayedColumns: string[] = ['id', 'nome', 'pseudonimo'];
    dataSource = this.titleData;

    public loadDisplayData = () => {

        this.http.post<TitleGridModel[]>(`${environment.apiUrl}/api/author/grid/list.json`, {  }).subscribe(data => {                                              
          this.titleData = data;
        });
        
      }
  
      ngOnInit() {        
        this.loadDisplayData();                  
      }
    
}