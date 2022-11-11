import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Todo } from './../../models/todo';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  constructor( private router: Router, private service: TodoService) { }

  todo: Todo = {
    titulo: '',
    descricao: '',
    dataParaFinalizar: new Date(),
    finalizado: false
  }

  ngOnInit(): void { }

  //metodo depreciado
  create2(): void {
    this.formataData();
    this.service.create(this.todo).subscribe((resposta) =>{
      this.service.message('To-do criado!')
      this.router.navigate(['']);
    }, err =>{
      this.service.message('falha ao criar to-do!')
      this.router.navigate(['']);
    })
  }

  create(): void {
  this.formataData();
   this.service.create(this.todo).subscribe({
    next: ()=> { 
      this.service.message('Tarefa Criada com sucesso!');
      this.router.navigate([''])
  },
    error: ()=>  this.service.message('Falha ao criar tarefa!')
  });
  }

  cancelar(): void{
    this.router.navigate([''])
  }

  formataData(): void{
    let data = new Date(this.todo.dataParaFinalizar)
    this.todo.dataParaFinalizar = `${data.getDate()}/${data.getMonth()+ 1}/${data.getFullYear()}`
  }
}
