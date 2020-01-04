import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {WeatherComponent} from './weather/weather.component';
import {LocationComponent} from './location/location.component';
import {UserComponent} from './user/user.component';
import {ReportComponent} from './report/report.component';
import {LogComponent} from './log/log.component';
import {LoginComponent} from './login/login.component';
import {LogoutComponent} from './logout/logout.component';

const appRoutes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full'},
  { path: 'location', component: LocationComponent},
  { path: 'weather', component: WeatherComponent},
  { path: 'user', component: UserComponent},
  { path: 'logs', component: LogComponent},
  { path: 'report', component: ReportComponent},
  { path: 'login', component: LoginComponent},
  { path: 'logout', component: LogoutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule {}
