import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { Router } from "@angular/router";
import { environment } from "src/environments/environment";
import { PaymentInsertDialog } from "../payment-insert-dialog/payment-insert-dialog.component";

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
    
    constructor(private http: HttpClient, private router:Router, public dialog: MatDialog){}

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

    openDialog(): void {
        const dialogRef = this.dialog.open(PaymentInsertDialog);

        dialogRef.afterClosed().subscribe(result => {
            console.log(`Dialog result: ${result}`);
        });        
    }

}