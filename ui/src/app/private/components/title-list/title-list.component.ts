import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { environment } from "src/environments/environment";


export interface TitleGridModel{

    id:string;
    nome:string;   
}

@Component({
    selector: 'title-list',
    templateUrl: './title-list.component.html',
    styleUrls: ['./title-list.component.scss'],
})

export class TitleListComponent{

    constructor(private http: HttpClient, private router:Router){}

    titleData: TitleGridModel[] = [];  
    displayedColumns: string[] = ['id', 'nome'];
    dataSource = this.titleData;

    public loadDisplayData = () => {

        this.http.post<TitleGridModel[]>(`${environment.apiUrl}/api/title/grid/list.json`, {  }).subscribe(data => {                                              
          this.titleData = data;
        });
        
      }
  
      ngOnInit() {        
        this.loadDisplayData();                  
      }
    
}