import { CommonModule } from '@angular/common';
import { HTTP_INTERCEPTORS, provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './shared/material.module';
import { InvalidAuthInterceptor } from './shared/interceptors/invalid-auth.interceptor';
import { TokenInterceptor } from './shared/interceptors/token.interceptor';
import { PrivateGuard } from './shared/guards/private.guard';

@NgModule({ 
    declarations: [
        AppComponent
    ],
    bootstrap: [
        AppComponent
    ], 
    imports: [
        CommonModule,
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MaterialModule
    ], 
    providers: [
        PrivateGuard,
        { provide: HTTP_INTERCEPTORS, useClass: InvalidAuthInterceptor, multi: true },
        { provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true },
        provideHttpClient(withInterceptorsFromDi())
    ] 
})
export class AppModule { }
