import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-foo-bar-quix-form',
  templateUrl: './foo-bar-quix-form.component.html'
})
export class FooBarQuixFormComponent implements OnInit {

  chosenNumber : number ;
  @Output() submitNumberOutput: EventEmitter<any> = new EventEmitter();

  constructor() {
  }

  ngOnInit(): void {
  }

  submitNumber(): void {
    if( Math.abs(this.chosenNumber) > 2147483647 ) {
      alert("The absolute value of the number should be less than 2147483647");
      return
    }

    if( this.chosenNumber == null ) {
      alert(" You should set a value ");
      return
    }

    this.submitNumberOutput.emit(this.chosenNumber);
  }

}
