import { Component, OnInit } from '@angular/core';
import { CityService } from '../services/city.service';

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.css']
})
export class LocationComponent implements OnInit {
  headers = ['id', 'cityName'];
  newCityName;
  newCity;
  cities: any = [];
  constructor(private api: CityService) { }

  ngOnInit() {
    this.getAllCities();
  }
  getAllCities() {
    this.api.getAllCities()
      .subscribe(data => this.cities = data);
  }
  addCity() {
    this.newCity = {
      cityName: this.newCityName
    };
    this.api.addCity(this.newCity).subscribe(response => {
      this.getAllCities();
    });
  }
  deleteCity(index) {
    this.api.deleteCityById(this.cities[index].id)
      .subscribe(response => {
        this.getAllCities();
      });
  }
}
