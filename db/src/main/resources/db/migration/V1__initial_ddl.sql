CREATE TABLE pessoa(
	email VARCHAR (255),
	nome VARCHAR (255) NOT NULL,
    senha VARCHAR (255) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    ddi_celular INTEGER NOT NULL,
    ddd_celular INTEGER NOT NULL,
    numero_celular INTEGER NOT NULL,
    data_de_nascimento DATE NOT NULL,

	PRIMARY KEY (email)
);

CREATE TABLE passageiro(
	email VARCHAR (255),

    PRIMARY KEY (email),
	CONSTRAINT  passageiro_pessoa_email FOREIGN KEY (email) REFERENCES pessoa(email)
);

CREATE TABLE motorista(
    email VARCHAR (255),
    cnh VARCHAR (128),

    PRIMARY KEY (email),
	CONSTRAINT  motorista_pessoa_email FOREIGN KEY (email) REFERENCES pessoa(email)
);

CREATE TABLE carro(
    cidade VARCHAR (255),
    placa VARCHAR (128),
    email_motorista VARCHAR (255),
    modelo VARCHAR (128) NOT NULL,
	cor VARCHAR (128) NOT NULL,

    PRIMARY KEY (cidade, placa, email_motorista),
	CONSTRAINT  carro_email_motorista FOREIGN KEY (email_motorista) REFERENCES motorista(email)
);

CREATE TABLE viagem(
	cidade VARCHAR (255),
	placa VARCHAR (128),
	email_motorista VARCHAR (255),
    data DATE,
    horario_de_saida TIME,
	vagas INTEGER NOT NULL,

    PRIMARY KEY (cidade, placa, email_motorista, data, horario_de_saida),
	CONSTRAINT viagem_carro FOREIGN KEY (cidade, placa, email_motorista) REFERENCES carro(cidade, placa, email_motorista)
);

CREATE TABLE local(
	latitude INTEGER,
	longitude INTEGER,
	descricao VARCHAR (512),

	PRIMARY KEY (latitude, longitude)
);

CREATE TABLE trajeto(
    latitude INTEGER,
    longitude INTEGER,
	data DATE,
	horario_de_saida TIME,
	cidade VARCHAR(255),
	placa VARCHAR(128),
	email_motorista VARCHAR(255),
    ordem INTEGER NOT NULL,

	PRIMARY KEY (latitude, longitude, data, horario_de_saida, cidade, placa, email_motorista),
    CONSTRAINT trajeto_viagem FOREIGN KEY (data, horario_de_saida, cidade, placa, email_motorista) REFERENCES viagem(data, horario_de_saida, cidade, placa, email_motorista),
    CONSTRAINT trajeto_local FOREIGN KEY (latitude, longitude) REFERENCES local(latitude, longitude)
);

CREATE TABLE carona(
    email_passageiro VARCHAR (255),
	data DATE,
	horario_de_saida TIME,
    cidade VARCHAR(255),
    placa VARCHAR(128),
    email_motorista VARCHAR(255),

	PRIMARY KEY (email_passageiro, data, horario_de_saida, cidade, placa, email_motorista),
	CONSTRAINT carona_viagem FOREIGN KEY (data, horario_de_saida, cidade, placa, email_motorista) REFERENCES viagem(data, horario_de_saida, cidade, placa, email_motorista),
    CONSTRAINT carona_email_passageiro FOREIGN KEY (email_passageiro) REFERENCES passageiro(email)
);

CREATE TABLE mensagem(
    id bigserial,
	email_remetente VARCHAR (255) NOT NULL,
    email_destinatario VARCHAR (255) NOT NULL,
    conteudo VARCHAR (255) NOT NULL,
    data DATE NOT NULL,

	PRIMARY KEY (id, email_remetente, email_destinatario),
	CONSTRAINT mensagem_pessoa_remetente FOREIGN KEY (email_remetente) REFERENCES pessoa(email),
    CONSTRAINT mensagem_pessoa_destinatario FOREIGN KEY (email_destinatario) REFERENCES pessoa(email)
);

CREATE TABLE bloqueio(
	email_bloqueador VARCHAR (255),
    email_bloqueado VARCHAR (255),

	PRIMARY KEY (email_bloqueador, email_bloqueado),
    CONSTRAINT bloqueio_pessoa_bloqueador FOREIGN KEY (email_bloqueador) REFERENCES pessoa(email),
	CONSTRAINT bloqueio_pessoa_bloqueado FOREIGN KEY (email_bloqueado) REFERENCES pessoa(email)
);

CREATE TABLE avaliacao(
    email_avaliador VARCHAR (255),
	data DATE,
	horario_de_saida TIME,
    cidade VARCHAR (255),
    placa VARCHAR (128),
    email_motorista VARCHAR (255),
    nota REAL NOT NULL,
    comentarios VARCHAR (512) NOT NULL,

	PRIMARY KEY (email_avaliador, data, horario_de_saida, cidade, placa, email_motorista),
	CONSTRAINT avaliacao_viagem FOREIGN KEY (data, horario_de_saida, cidade, placa, email_motorista) REFERENCES viagem(data, horario_de_saida, cidade, placa, email_motorista),
    CONSTRAINT avaliacao_pessoa_email_avaliador FOREIGN KEY (email_avaliador) REFERENCES pessoa(email)
);