import { Component, Inject } from "@angular/core";
import { FormBuilder, Validators } from "@angular/forms";
import  {MAT_DIALOG_DATA } from '@angular/material/dialog';


@Component({
    selector: 'payment-insert-dialog',
    templateUrl: 'payment-insert-dialog.component.html',
    styleUrls: ['payment-insert-dialog.component.scss'],
  })
  export class PaymentInsertDialog {
    
    public form = this.formBuilder.group({
        id:[null],
        date: [null],
        status:[null, Validators.required]
    });

    public isNew: boolean = true;
    
    constructor(@Inject(MAT_DIALOG_DATA) public data: any, private formBuilder: FormBuilder) {}
  
    
    
    
  
    
  }
  