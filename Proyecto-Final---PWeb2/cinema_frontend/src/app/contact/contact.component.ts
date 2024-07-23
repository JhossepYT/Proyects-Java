import { Component } from '@angular/core';
import { ContactService } from '../contact.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {
  model = {
    name: '',
    email: '',
    message: ''
  };

  constructor(private contactService: ContactService) { }

  onSubmit() {
    this.contactService.sendContactForm(this.model);
    this.model = { name: '', email: '', message: '' }; // Reset form
  }
}
