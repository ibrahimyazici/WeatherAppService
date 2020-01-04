import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
const localUrl = 'http://localhost:9090/';
@Injectable()
export class OpenweatherService {
  constructor(private http: HttpClient) { }
  getTemperatureByCity(id, cityName) {
    return this.http.get(localUrl + 'user/' + id + '/getTemperature/' + cityName);
  }

}
