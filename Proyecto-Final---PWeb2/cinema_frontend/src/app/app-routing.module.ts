import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MoviesComponent } from './movies/movies.component';
import { EstrenosComponent } from './estrenos/estrenos.component';
import { ContactComponent } from './contact/contact.component';
import { MovieDetailComponent } from './movie-detail/movie-detail.component';
import { HomeComponent } from './home/home.component';
import { AllMoviesComponent } from './all-movies/all-movies.component';
import { SeatsComponent } from './seats/seats.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'peliculas', component : AllMoviesComponent },
  { path: 'estrenos', component: EstrenosComponent },
  { path: 'contacto', component: ContactComponent },
  { path: 'pelicula/:id', component: MovieDetailComponent },  // Ruta para detalles de película
  { path: ':showtimeId/asientos', component: SeatsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
