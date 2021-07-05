import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-foo-bar-quix-form',
  templateUrl: './foo-bar-quix-form.component.html'
})
export class FooBarQuixFormComponent implements OnInit {

  fooBarForm: FormGroup;
  newNumber: number = 0;

  @Output() submitNumberOutput = new EventEmitter<number>();

  constructor(private fb: FormBuilder) {
    this.createForm();
  }

  ngOnInit(): void {
  }

  createForm() {
    this.fooBarForm = this.fb.group({
      inputNumber: ['', [Validators.required, Validators.pattern("^[0-9]*$")]],
    });
  }

  submitNumber(inputNumber: number): void {
    this.fooBarForm.reset(inputNumber);
    this.submitNumberOutput.emit(inputNumber);
  }
}
