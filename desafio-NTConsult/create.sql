create table tb_associado (id bigint not null auto_increment, cpf varchar(255), nome varchar(255), primary key (id)) engine=InnoDB;
create table tb_pauta (id bigint not null auto_increment, dt_abertura_sessao datetime, descricao varchar(255), qt_duracao_sessao bigint, titulo varchar(255), primary key (id)) engine=InnoDB;
create table tb_voto (id bigint not null auto_increment, valor varchar(255), associado_id bigint, pauta_id bigint, primary key (id)) engine=InnoDB;
alter table tb_voto add constraint FKr3qgif8est3ghlp7yjlw618a2 foreign key (associado_id) references tb_associado (id);
alter table tb_voto add constraint FKanmwqa0vm44yh63c86aggl3tq foreign key (pauta_id) references tb_pauta (id);
