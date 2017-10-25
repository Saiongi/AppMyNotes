import { Component, OnInit } from '@angular/core';
import { ViewEncapsulation } from '@angular/core';

import { DealsService }   from './../../services/deals.service';
import { HttpService }   from './../../services/http.service';
import { Response } from '@angular/http';

import { Deal } from './../../models/deal';

@Component({
	selector: 'app-todo',
	templateUrl: './todo.component.html',
	styleUrls: ['./todo.component.scss'],
	encapsulation: ViewEncapsulation.None,
	providers: [DealsService]
})
export class TodoComponent implements OnInit {

	deals;

	filter: String;   // Фильтр категорий: all | done | undone
	dateSort: String; // Сортировка по датам: asc | desc

	page:   Number;	//Текущая страница
	offset: Number; //Записей на странице
	amount: Number; //Всего записей

	constructor(private dealsService: DealsService) { }

	ngOnInit() {
		this.page = 1;
		this.offset = 5;
		this.filter = 'all';
		this.dateSort = 'desc';
		this.refreshData();
	}

	refreshData() {
		this.dealsService.getDeals(this.page, this.offset, this.filter, this.dateSort).subscribe((data: Response) => this.deals = data);
		this.dealsService.getAmountDeals(this.filter).subscribe((data: Number) => this.amount = data);
	}

	onPaginateChange(paginator) {
		this.page = paginator.pageIndex + 1;
		this.offset = paginator.pageSize;

		this.refreshData();
	}

	addItem(el) {
		this.dealsService.addDeal(el.value).subscribe((res) => {
			el.value = '';
			this.refreshData();
		});
	}

	deleteDeal(id: Number) {
		this.dealsService.deleteDeal(id).subscribe((res) => {
			this.refreshData();
		});
	}

	changeItemStatus(item: Deal) {
		this.dealsService.updateDeal(item).subscribe((res) => {
			// this.refreshData();
		});
	}

	setFilter(filter: String) {
		this.filter = filter;

		this.refreshData();		
	}

	changeDateSort() {
		if (this.dateSort == 'desc') this.dateSort = 'asc';
			else this.dateSort = 'desc';

		this.refreshData();		
	}
}
