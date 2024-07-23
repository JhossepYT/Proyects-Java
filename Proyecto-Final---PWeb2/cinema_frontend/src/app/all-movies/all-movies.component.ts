import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-all-movies',
  templateUrl: './all-movies.component.html',
  styleUrl: './all-movies.component.css'
})
export class AllMoviesComponent implements OnInit {
  title = 'cinema_frontend';
  movies: any[] = [];

  constructor(private movieService: MovieService, private router: Router) {}

  ngOnInit(): void {
    this.getMovies();
  }

  getMovies(): void {
    this.movieService.getAllMovies().subscribe(
      data => {
        this.movies = data; // Suponiendo que `data` es un array de películas
      },
      error => {
        console.log(error);
      }
    );
  }
}
