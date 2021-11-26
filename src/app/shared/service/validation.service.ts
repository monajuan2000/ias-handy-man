import { Injectable } from '@angular/core';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class ValidationService {

  constructor() { }

  notification(title: string, msn: any, icon: string) {
    Swal.fire({
      title: title,
      html: msn.replaceAll(';', '<br>'),
      imageUrl: `/assets/images/${icon}`,
      imageWidth: 100,
      imageHeight: 100,
    });
}
}