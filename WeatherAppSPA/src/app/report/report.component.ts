import { Component, OnInit } from '@angular/core';
import { LogService } from '../services/log.service';
import {Sort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {
  headers = ['id', 'cityName', 'queryDate', 'ipAddress', 'result', 'timeSpent', 'status'];
  queryLogs: any = [];
  constructor(private api: LogService) {
  }

  ngOnInit() {
    this.getAllLogs();
  }
  getAllLogs() {
    this.api.getAllQueryLogs()
      .subscribe(data => this.queryLogs = data);
  }
}

