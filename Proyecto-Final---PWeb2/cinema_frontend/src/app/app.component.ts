import { Component } from '@angular/core';
import { MovieService } from './movie.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  providers: [MovieService]
})
export class AppComponent {
  title = 'cinema_frontend';
  movies: any[] = [];

  constructor(private movie: MovieService) {
    this.getMovies();
  }

  getMovies = () => {
    this.movie.getAllMovies().subscribe (
      data => {
        this.movies = data;
        data.results;
      },
      error => {
        console.log(error);
      }    )  } 
}
