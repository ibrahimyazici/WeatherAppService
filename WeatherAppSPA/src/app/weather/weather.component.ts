import { Component, OnInit } from '@angular/core';
import { CityService } from '../services/city.service';
import { OpenweatherService} from '../services/openweather.service';


@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.css']
})
export class WeatherComponent implements OnInit {
  errorMessage;
  ipAddress;
  selectedCityName;
  temperature;
  weatherData;
  selectedCity;
  headers = ['id', 'cityName'];
  cities: any = [];
  constructor(private api: CityService,
              private apiOpenWeather: OpenweatherService) { }

  ngOnInit() {
    this.getAllCities();
  }
  getAllCities() {
    this.api.getAllCities()
      .subscribe(data => this.cities = data);
  }
  getTemperature() {
    this.getSelectedCityName();
    this.apiOpenWeather.getTemperatureByCity(-1, this.selectedCityName)
      .subscribe(data => {
        this.weatherData = data;
        this.temperature = this.weatherData.temperature;
      });
  }
  getSelectedCityName() {
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.cities.length; ++i) {
      // tslint:disable-next-line:triple-equals
      if (this.cities[i] && this.cities[i].id == this.selectedCity) {
        this.selectedCityName = this.cities[i].cityName;
      }
    }
  }
}
