# Projeto Integrador 2º Semetre (Curso Análise e Desenvolvimento de Sistemas)

> Status do Projeto: Finalizado com erros, pendente de correção.

- Projeto de um sistema local(Em Java) com integração com banco de dados (MySQL). 
- CRUD funcional.

```
create table clientes(
    idCliente int primary key auto_increment,
    nome varchar(50),
    cpf varchar(20) unique,
    endereco varchar(150),
    numero varchar(10),
    genero varchar(10),
    estadoCivil varchar(15),
    email varchar(100),
    telefone varchar(15),
    dataNascimento Date,
    complemento varchar(30),
    bairro varchar(30),
    cidade varchar(30),
    cep char(9),
    estado char(2)
    );

insert into clientes (nome,cpf,endereco,numero,genero,estadoCivil,email,telefone,dataNascimento,complemento,bairro,cidade,cep,estado) values
("Fernando","11111111111","Rua Senac","10","Masculino","Solteiro(a)","fernando@senac.com.br","11911111111","1998-05-30","Ap. 20","Itaquera","São Paulo","11111111","SP"),
("Maria","22222222222","Rua Senac","17","Feminino","Solteiro(a)","maria@senac.com.br","11911111111","2000-02-15","","Campo Limpo","São Paulo","11111111","SP"),
("José","33333333333","Rua Senac","20","Masculino","Casado(a)","jose@senac.com.br","11911111111","1987-10-02","","Morumbi","São Paulo","11111111","SP")
;

create table produtos (
    idProduto int primary key auto_increment,
    descricao varchar(100),
    codigo varchar(20) unique,
    modelo varchar(20),
    qtdEstoque int,
    preco double
);

insert into produtos (descricao,codigo,modelo,qtdEstoque,preco) values
("Guitarra Gibson Standard Pro","1","Les Paul",50,5000.00),
("Guitarra Gibson Standard Pro","2","SG",50,4500.00),
("Guitarra Fender","3","Telecaster",50,6000.00)
;

create table vendas (
    idVenda int primary key auto_increment,
    fk_idCliente int,
    dataVenda date not null,
    foreign key (fk_idCliente) references clientes(idCliente)
 );

 create table itensVendas(
    idItemVenda int primary key auto_increment,
    fk_idCliente int not null,
    fk_idVenda int not null,
    fk_idProduto int not null,
    nomeCliente varchar(30),
    descricao varchar(30),
    codigo varchar(30),
    qtdVenda varchar(100) not null,
    troco float,
    valorRecebido float,
    valorProduto float,
    valorTotal float not null,
    foreign key (fk_idProduto) references produtos(idProduto),
    foreign key (fk_idVenda) references vendas (idVenda),
    foreign key (fk_idCliente) references clientes (idCliente)		
 );



-- Trigger que remove itens do estoque --
delimiter $$
create trigger retiraEstoque after insert on itensVendas for each row
begin
update produtos p set qtdEstoque = qtdEstoque - new.qtdVenda 
where p.idProduto = new.fk_idProduto;
end $$

-- Trigger que estorna itens do estoque --
delimiter $$
create trigger estornaEstoque after delete on itensVendas for each row
begin
update produtos p set qtdEstoque = qtdEstoque + old.qtdVenda 
where p.idProduto = old.fk_idProduto;
end $$
```
