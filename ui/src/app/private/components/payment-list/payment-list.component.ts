import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { environment } from "src/environments/environment";

export interface PaymentGridListModel {

    id: string;
    name: string;    
}

@Component({
    selector: 'payment-list',
    templateUrl: './payment-list.component.html',
    styleUrls: ['./payment-list.component.scss'],
})
export class PaymentListComponent implements OnInit {
    
    constructor(private http: HttpClient, private router:Router){}

    paymentData: PaymentGridListModel[] = [];  
    displayedColumns: string[] = ['id', 'name'];
    
    public loadDisplayData = () => {

        this.http.post<PaymentGridListModel[]>(`${environment.apiUrl}/api/payment/grid/list.json`, {  }).subscribe(data => {                                              
          this.paymentData = data;
        });        
    }
    
    ngOnInit(): void {
        this.loadDisplayData();
    }

}