import {Component, Input, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.scss']
})
export class AboutComponent implements OnInit {
  @Input() num: number = 0;
  show = false;
  facts: number[] = [];

  form = new FormGroup({
    facts: new FormControl(0, Validators.required)
  });

  constructor() {
  }

  ngOnInit(): void {
  }

  check(value: any) {
    if (value > 0) {
      this.num = value;
      this.show = true;
      this.facts.length = this.num;
    }
  }
}
