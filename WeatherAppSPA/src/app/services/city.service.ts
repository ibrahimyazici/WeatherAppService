import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const localUrl = 'http://localhost:9090/';

@Injectable()
export class CityService {

  constructor(private http: HttpClient) { }
  getAllCities() {
    return this.http.get(localUrl + 'admin/cities');
  }
  deleteCityById(id) {
    return this.http.delete(localUrl + 'admin/city/' + id);
  }
  addCity(city) {
    return this.http.post(localUrl + 'admin/addCity', city);
  }
}
