import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { ReportComponent } from './report/report.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { LogService } from './services/log.service';
import { LocationComponent } from './location/location.component';
import {CityService} from './services/city.service';
import { UserComponent } from './user/user.component';
import {UserService} from './services/user.service';
import { AppRoutingModule } from './app-routing.module';
import { WeatherComponent } from './weather/weather.component';
import {OpenweatherService} from './services/openweather.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatNativeDateModule} from '@angular/material/core';
import { LogComponent } from './log/log.component';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import {MatFormFieldModule} from '@angular/material';
import { MatInputModule } from '@angular/material';
import { LoginComponent } from './login/login.component';
import {TokenInterceptor} from './TokenInterceptor';
import { LogoutComponent } from './logout/logout.component';
@NgModule({
  declarations: [
    AppComponent,
    ReportComponent,
    NotFoundComponent,
    LocationComponent,
    UserComponent,
    WeatherComponent,
    LogComponent,
    LoginComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatNativeDateModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatFormFieldModule,
    MatInputModule
  ],
  providers: [
    LogService,
    CityService,
    UserService,
    OpenweatherService,
    { provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
