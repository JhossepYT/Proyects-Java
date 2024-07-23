import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-seats',
  templateUrl: './seats.component.html',
  styleUrls: ['./seats.component.css']  // Corrección: styleUrls en plural
})
export class SeatsComponent implements OnInit {
  title = 'cinema_frontend';
  seats: any[][] = [];
  movie: any;
  showtime: any;

  constructor(private movieService: MovieService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.getShowtimeById();
  }

  getShowtimeById(): void {
    const id = this.route.snapshot.paramMap.get('showtimeId') as string;  // Aserción de tipo
    this.movieService.getShowtimeById(id).subscribe(
      data => {
        this.showtime = data;
        console.log("Showtime by id " + id + " loaded");
        this.getSeats();
        this.getMovie();
      },
      error => {
        console.error(error);
      }
    );
  }

  getSeats(): void {
    if (this.showtime && this.showtime.hall) {
      this.movieService.getSeatsByHall(this.showtime.hall).subscribe(
        data => {
          this.seats = this.transformSeats(data); // Suponiendo que `data` es un array de asientos
          console.log("Seats loaded");
        },
        error => {
          console.log(error);
        }
      );
    } else {
      console.error('Showtime hall information is missing');
    }
  }

  getMovie(): void {
    if (this.showtime && this.showtime.hall) {
      this.movieService.getMovieById(this.showtime.movie).subscribe(
        data => {
          this.movie = data; // Suponiendo que `data` es un array de asientos
          console.log(this.movie);
        },
        error => {
          console.log(error);
        }
      );
    } else {
    }
  }

  transformSeats(data: any[]): any[][] {
    const rows = 3;
    const cols = 10;
    const transformedSeats = [];
    for (let i = 0; i < rows; i++) {
      transformedSeats[i] = data.slice(i * cols, i * cols + cols);
    }
    return transformedSeats;
  }

  formatTime(time: string): string {
    const [hours, minutes] = time.split(':').map(num => parseInt(num, 10));
    const ampm = hours >= 12 ? 'PM' : 'AM';
    const formattedHours = hours % 12 || 12;
    return `${formattedHours}:${minutes < 10 ? '0' + minutes : minutes} ${ampm}`;
  }

  formatDuration(duration: number): string {
    const hours = Math.floor(duration / 60);
    const minutes = duration % 60;
    return `${hours}h ${minutes}min`;
  }
}
