import { Component, Inject } from '@angular/core';
import { DialogData } from '../login/login.component';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-modal-login',
  templateUrl: './modal-login.component.html'
})
export class ModalLoginComponent {
  hide = true;
  inputUser: string = "";
  intputPassword: string = "";
  constructor(
    public dialogRef: MatDialogRef<ModalLoginComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
  ){}

  isLoading=false;
  onNoClick( ): void {
    this.dialogRef.close();
  }
  
}
