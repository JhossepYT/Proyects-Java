import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  baseurl = "http://localhost:8000";
  httpHeaders = new HttpHeaders({'Content-Type':'application/json'});

  constructor(private http:HttpClient) { }

  getAllMovies():Observable<any>{
    return this.http.get(this.baseurl+'/movie/', 
    {headers: this.httpHeaders});
  }

  getPremieres(): Observable<any> {
    return this.http.get(this.baseurl + '/movie/', { headers: this.httpHeaders })
      .pipe(
        map((response: any) => response.filter((movie: any) => movie.is_premiere))
      );
  }

  getNoPremieres(): Observable<any> {
    return this.http.get(this.baseurl + '/movie/', { headers: this.httpHeaders })
      .pipe(
        map((response: any) => response.filter((movie: any) => !movie.is_premiere))
      );
  }

  getMovieById(id: string): Observable<any> {
    return this.http.get(`${this.baseurl}/movie/${id}/`, { headers: this.httpHeaders });
  }

  getAllShowtimes(): Observable<any> {
    return this.http.get(this.baseurl + '/showtime/', { headers: this.httpHeaders });
  }

  getShowtimesByMovieId(movieId: string): Observable<any> {
    return this.http.get(this.baseurl + '/showtime/', { headers: this.httpHeaders })
      .pipe(
        map((response: any) => response.filter((showtime: any) => showtime.movie == movieId))
      );
  }

  getSeatsByHall(hallId: string): Observable<any> {
    return this.http.get(this.baseurl + '/seat/', { headers: this.httpHeaders })
      .pipe(
        map((response: any) => response.filter((seat: any) => seat.hall == hallId))
      );
  }

  getShowtimeById(showtimeId: string): Observable<any> {
    return this.http.get(`${this.baseurl}/showtime/${showtimeId}/`, { headers: this.httpHeaders });
  }
}
