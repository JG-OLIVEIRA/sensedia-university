create database if not exists sensedia_university;

use sensedia_university;

create table disciplina (
	id int AUTO_INCREMENT PRIMARY KEY,
	nome varchar(50),
	turno varchar(2),
	sala int
);

create table aluno (
	id int AUTO_INCREMENT PRIMARY KEY,
	nome varchar(25),
	sobrenome varchar(50),
	matricula varchar(50),
	ano int
);

create table docente (
	id int AUTO_INCREMENT PRIMARY KEY,
	nome varchar(25),
	sobrenome varchar(50),
	matricula varchar(50),
	ano int
);

create table curso (
	id int AUTO_INCREMENT PRIMARY KEY,
	nome varchar(50)
);


create table aluno_curso (
	id int AUTO_INCREMENT PRIMARY KEY,
	aluno_id int,
	curso_id int
);

ALTER TABLE aluno_curso ADD FOREIGN KEY (aluno_id) REFERENCES aluno(id);
ALTER TABLE aluno_curso ADD FOREIGN KEY (curso_id) REFERENCES curso(id); 

create table aluno_disciplina (
	id int AUTO_INCREMENT PRIMARY KEY,
	aluno_id int,
	disciplina_id int 
);

ALTER TABLE aluno_disciplina ADD FOREIGN KEY (aluno_id) REFERENCES aluno(id); 
ALTER TABLE aluno_disciplina ADD FOREIGN KEY (disciplina_id) REFERENCES disciplina(id); 

create table curso_disciplina (
	id int AUTO_INCREMENT PRIMARY KEY,
	curso_id int,
	disciplina_id
);

ALTER TABLE curso_disciplina ADD FOREIGN KEY (curso_id) REFERENCES curso(id);
ALTER TABLE curso_disciplina ADD FOREIGN KEY (disciplina_id) REFERENCES disciplina(id); 

create table docente_disciplina  (
	id int AUTO_INCREMENT PRIMARY KEY,
	docente_id int,
	disciplina_id int
);

ALTER TABLE docente_disciplina ADD FOREIGN KEY (docente_id) REFERENCES docente(id);  
ALTER TABLE docente_disciplina ADD FOREIGN KEY (disciplina_id) REFERENCES disciplina(id);  

