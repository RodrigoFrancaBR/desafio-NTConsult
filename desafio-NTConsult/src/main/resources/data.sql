INSERT INTO TB_ASSOCIADO 
	(nome) values
    ('Associado_1'),
    ('Associado_2'),
    ('Associado_3'),
    ('Associado_4'),
    ('Associado_5'),
    ('Associado_6'),
    ('Associado_7'),
    ('Associado_8'),
    ('Associado_9'),
    ('Associado_10');

    INSERT INTO TB_PAUTA 
	(titulo, descricao) values
    ('Titulo_1', 'Descricao_1'),
    ('Titulo_2', 'Descricao_2'),
    ('Titulo_3', 'Descricao_3'),
    ('Titulo_4', 'Descricao_4'),
    ('Titulo_5', 'Descricao_5'),
    ('Titulo_6', 'Descricao_6'),
    ('Titulo_7', 'Descricao_7'),
    ('Titulo_8', 'Descricao_8'),
    ('Titulo_9', 'Descricao_9'),
    ('Titulo_10','Descricao_10');

    UPDATE TB_PAUTA SET 
	dt_abertura_sessao = '2021-02-08T22:07:24.068', qt_duracao_sessao=60;

  INSERT INTO TB_VOTO 
	(pauta_id, associado_id, valor_do_voto) values
    (1, 1, 'Sim'),
    (2, 1, 'Sim'),
    (3, 1, 'Sim'),
    (4, 1, 'Sim'),
    (5, 1, 'Sim'),
    (6, 1, 'Não'),
    (7, 1, 'Não'),
    (8, 1, 'Não'),
    (9, 1, 'Não'),
    (10, 1, 'Não');