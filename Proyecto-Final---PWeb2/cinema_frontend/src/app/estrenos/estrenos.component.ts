import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-estrenos',
  templateUrl: './estrenos.component.html',
  styleUrls: ['./estrenos.component.css']
})
export class EstrenosComponent implements OnInit {
  title = 'cinema_frontend';
  movies: any[] = []

  constructor(private movieService: MovieService) {}

  ngOnInit(): void {
    this.getMovies();
  }

  getMovies(): void {
    this.movieService.getPremieres().subscribe(
      data => {
        this.movies = data; // Suponiendo que `data` es un array de películas
      },
      error => {
        console.log(error);
      }
    );
  }
}
