import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import emailjs from 'emailjs-com';  // Asegúrate de instalar emailjs-com con `npm install emailjs-com`

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  // URL de la API, si se estuviera usando un backend, se configuraría aquí.
  private apiUrl = 'http://localhost:8000/api/contact/'; 

  constructor(private http: HttpClient) { }

  // Método para enviar correo usando EmailJS
  sendContactForm(data: any): void {
    const templateParams = {
      from_name: data.name,
      from_email: data.email,
      message: data.message
    };

    emailjs.send('service_ewtmmmr', 'template_mztx1qr', templateParams, 'WZf6hIwJdUv1HxMu16Utc')
      .then((response) => {
        console.log('Email sent successfully', response);
      }, (error) => {
        console.error('Error sending email', error);
      });
  }

  // Método para enviar correo usando un backend (opcional)
  // sendContactForm(data: any): Observable<any> {
  //   return this.http.post(this.apiUrl, data);
  // }
}
