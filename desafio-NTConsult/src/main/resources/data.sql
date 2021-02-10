INSERT INTO TB_ASSOCIADO 
    (nome, cpf) values
    ('Associado_1', '11111111111'),
    ('Associado_2', '22222222222'),
    ('Associado_3', '33333333333'),
    ('Associado_4', '44444444444'),
    ('Associado_5', '55555555555'),
    ('Associado_6', '66666666666'),
    ('Associado_7', '77777777777'),
    ('Associado_8', '88888888888'),
    ('Associado_9', '99999999999'),
    ('Associado_10', '9999999991');

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
	(pauta_id, associado_id, valor_voto) values
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