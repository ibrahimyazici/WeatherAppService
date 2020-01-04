import {HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const jwt = sessionStorage.getItem('token');
    const username = sessionStorage.getItem('username')
    const modifiedReq = req.clone({
      headers: req.headers.set('Authorization', 'Bearer ' + jwt)
        .set('username', username),
      // headers: new HttpHeaders({
      //   'Authorization': 'Bearer ' + jwt,
      //   'username': username
      // })
    });
    return next.handle(modifiedReq);
  }
}
