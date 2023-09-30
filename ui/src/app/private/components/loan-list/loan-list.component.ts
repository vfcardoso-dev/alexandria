import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

export interface LoanGridModel{
    id: string;
    member: string;
    copy: string;
    date: string;
    expiringDate: string;
    returningDate:string;
}

@Component({
    selector: 'loan-list',
    templateUrl: './loan-list.component.html',
    styleUrls: ['./loan-list.component.scss'],
})
export class LoanListComponent implements OnInit{

    constructor(private http: HttpClient, private router: Router){}

    loanData: LoanGridModel[] = [];  
    displayedColumns: string[] = ['id', 'member', 'copy', 'date', 'expiringDate', 'returningDate'];
    dataSource = this.loanData;
    
    ngOnInit() {        
        //this.loadDisplayData();                  
    }

}    