
    create table Categoria (
        id bigint not null auto_increment,
        cargoFijo double precision not null,
        cargoVariable double precision not null,
        consumoMaximo double precision not null,
        consumoMinimo double precision not null,
        nombre varchar(255),
        primary key (id)
    )

    create table Cliente (
        id bigint not null auto_increment,
        ahorroAutomatico bit not null,
        apellido varchar(255),
        domicilio varchar(255),
        fechaAlta date,
        nombre varchar(255),
        nroDocumento bigint not null,
        puntos double precision not null,
        telefono bigint not null,
        tipoDocumento integer,
        categoria_id bigint,
        primary key (id)
    )

    alter table Cliente 
        add constraint FK_svhhh7o13efkdj194w94ppex7 
        foreign key (categoria_id) 
        references Categoria (id)
