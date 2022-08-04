import { Component } from "@angular/core";

@Component({
    selector: 'private-root-component',
    template: '<router-outlet></router-outlet>'
})
export class PrivateRootComponent {
    constructor(){}
}