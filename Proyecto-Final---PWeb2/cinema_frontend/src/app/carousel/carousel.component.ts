import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css'],
  providers: [MovieService]
})
export class CarouselComponent implements OnInit {
  title = 'cinema_frontend';
  movies: any[] = [];

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
