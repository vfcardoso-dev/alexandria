import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { environment } from "src/environments/environment";

export interface LoanGridModel{
    id: string;
    memberName: string;
    titleName: string;
    copyId: string;
    copyCode: string;
    date: string;
    expiringDate: string;
    returnDate:string;    				
}

@Component({
    selector: 'loan-list',
    templateUrl: './loan-list.component.html',
    styleUrls: ['./loan-list.component.scss'],
})
export class LoanListComponent implements OnInit{

    constructor(private http: HttpClient, private router: Router){}

    loanData: LoanGridModel[] = [];  
    displayedColumns: string[] = ['id', 'memberName', 'titleName', 'copyCode', 'date', 'expiringDate', 'returnDate'];
    dataSource = this.loanData;
    
    
    public loadDisplayData = () => {
        this.http.post<LoanGridModel[]>(`${environment.apiUrl}/api/loan/grid/list.json`, {  }).subscribe(data => {                                              
            this.loanData = data;
          });
    }     
    
    ngOnInit() {        
        this.loadDisplayData();                  
    }

}    