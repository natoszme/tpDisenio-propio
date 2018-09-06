
    create table Categoria (
        id bigint not null auto_increment,
        cargoFijo double precision not null,
        cargoVariable double precision not null,
        consumoMaximo double precision not null,
        consumoMinimo double precision not null,
        nombre varchar(255) not null,
        primary key (id)
    )

    create table Cliente (
        id bigint not null auto_increment,
        ahorroAutomatico bit not null,
        apellido varchar(255) not null,
        domicilio varchar(255),
        fechaAlta date,
        nombre varchar(255) not null,
        nroDocumento bigint not null,
        puntos double precision not null,
        telefono bigint not null,
        tipoDocumento varchar(255) not null,
        categoria_id bigint not null,
        primary key (id)
    )

    create table CondicionSobreSensor (
        tipo varchar(31) not null,
        id bigint not null auto_increment,
        factorDeComparacion double precision,
        sensor_id bigint not null,
        idRegla bigint not null,
        primary key (id)
    )

    create table Dispositivo (
        id bigint not null auto_increment,
        kwPorHora double precision not null,
        nombre varchar(255) not null,
        primary key (id)
    )

    create table DispositivoInteligente (
        id bigint not null auto_increment,
        primary key (id)
    )

    create table Regla (
        tipo varchar(31) not null,
        id bigint not null auto_increment,
        dispositivo_id bigint not null,
        primary key (id)
    )

    create table Sensor (
        tipo varchar(31) not null,
        id bigint not null auto_increment,
        primary key (id)
    )

    alter table Categoria 
        add constraint UK_g22h6awq25eaqohosg6icwj8b  unique (nombre)

    alter table Cliente 
        add constraint UK_g7aer5ydwwrpt04p5pt90bh9n  unique (tipoDocumento, nroDocumento)

    alter table Cliente 
        add constraint FK_svhhh7o13efkdj194w94ppex7 
        foreign key (categoria_id) 
        references Categoria (id)

    alter table CondicionSobreSensor 
        add constraint FK_63jph0ldb87wse7wf6t9pt185 
        foreign key (sensor_id) 
        references Sensor (id)

    alter table CondicionSobreSensor 
        add constraint FK_9rna43b6se79ta1gj6kbo0wt9 
        foreign key (idRegla) 
        references Regla (id)

    alter table Regla 
        add constraint FK_jlmnuc7r42qhcrce381jeuofd 
        foreign key (dispositivo_id) 
        references Dispositivo (id)
