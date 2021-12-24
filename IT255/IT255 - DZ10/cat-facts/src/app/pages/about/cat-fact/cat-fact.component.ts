import {Component, Input, OnInit} from '@angular/core';
import {CatFactsService} from "../../../../services/cat-facts.service";
import {CatFacts} from "../../../../models/catFacts";

@Component({
  selector: 'app-cat-fact',
  templateUrl: './cat-fact.component.html',
  styleUrls: ['./cat-fact.component.scss']
})
export class CatFactComponent implements OnInit {

  @Input() num: number = 0;
  catFacts: CatFacts[] = [];

  constructor(private service: CatFactsService) {
  }

  ngOnInit(): void {
    this.get();
  }

  get(): void {
    this.service.get("cat", this.num).toPromise().then(data => {
      this.catFacts = data;
    });
  }
}
