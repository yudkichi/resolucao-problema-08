package com.example.ResolucaoProblema8;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@SpringBootApplication
public class ResolucaoProblema8Application {

	public static void main(String[] args) {
		SpringApplication.run(ResolucaoProblema8Application.class, args);
	}
}

@Data
class Funcionario {

		//@Id
		//@GeneratedValue gerava chave null
		private UUID id;
		private String name;
		private int age;
		private float salary;
		
}
	
@RestController
class FuncionarioController {
		
		private ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
		
		@GetMapping("/funcionario")
		public @ResponseBody ArrayList<Funcionario> listar(){
			return lista;	
		} 
		
		@PostMapping("/funcionario")
		public String create(@RequestBody Funcionario func) {
			Funcionario f = new Funcionario();
			func.setId(UUID.randomUUID());
			f.setId(func.getId());
			f.setName(func.getName());
			f.setAge(func.getAge());
			f.setSalary(func.getSalary());
			lista.add(f);
			return "Adicionado";
			
		}
		
		@DeleteMapping("/funcionario")
		public String delete(@RequestBody Funcionario func) {
			for(Funcionario f : lista) {
				if(f.getId().equals(func.getId())) {
					lista.remove(f);
					return "Deletado";
				}
			}			
			return "Não encontrado";
		}
		
		@PutMapping("/funcionario")
		public Funcionario update(@RequestBody Funcionario func) {
			for(Funcionario f : lista) {
				if(f.getId().equals(func.getId())) {
					f.setName(func.getName());
					f.setAge(func.getAge());
					f.setSalary(func.getSalary());
					return f;
				}
			}
			return null;
		}
	
}