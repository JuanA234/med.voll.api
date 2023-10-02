/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  JuanAndres
 * Created: 30/09/2023
 */

create table pacientes(
    id bigint not null auto_increment,
    nombre varchar(100) not null,
    email varchar(100) not null unique,
    documentoIdentidad varchar(14) not null unique,
    telefono varchar(20) not null,
    urbanización varchar(100) not null,
    distrito varchar(100) not null,
    codigoPostal varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    provincia varchar(100) not null,
    ciudad varchar(100) not null,

    primary key(id)

);