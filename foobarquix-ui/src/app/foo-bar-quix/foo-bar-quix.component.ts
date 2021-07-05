import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { FooBarQuixService } from '../foo-bar-quix.service';

@Component({
  selector: 'app-foo-bar-quix',
  templateUrl: './foo-bar-quix.component.html'
})

export class FooBarQuixComponent implements OnInit, OnDestroy {

  convertedNumbers: NumberConverted[] = [];

  constructor(private fooBarQuixService: FooBarQuixService) { }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
  }

  convertNumber(inputNumber: number): void {
    this.fooBarQuixService.convertNumber(inputNumber).toPromise()
      .then(data => {
        console.log(data);
        this.convertedNumbers.push({ numberToConvert: inputNumber, result: data.value });
        console.log(this.convertedNumbers);
      })
      .catch(error => console.log(error));
  }

}

interface NumberConverted {
  numberToConvert: number;
  result: string;
}
