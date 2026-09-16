import { Component, OnDestroy, OnInit } from "@angular/core";
import { BreakpointObserver, Breakpoints } from "@angular/cdk/layout";
import { Subscription } from "rxjs";

@Component({
    selector: 'private-root-component',
    templateUrl: './private.component.html',
    styleUrls: ['./private.component.scss'],
    standalone: false
})
export class PrivateRootComponent implements OnInit, OnDestroy {
    public isMobile = false;

    private subscription?: Subscription;

    constructor(private breakpointObserver: BreakpointObserver) {}

    ngOnInit(): void {
        this.subscription = this.breakpointObserver
            .observe(Breakpoints.Handset)
            .subscribe(result => this.isMobile = result.matches);
    }

    ngOnDestroy(): void {
        this.subscription?.unsubscribe();
    }
}
