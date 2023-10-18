create table alunos(

    id bigint not null auto_increment,
    nome varchar(50) not null,
    idade varchar(3) not null,
    nota1 varchar(3) not null,
    nota2 varchar(3) not null,
    professor varchar(50) not null,
    sala varchar(6) not null,

    primary key(id)

);