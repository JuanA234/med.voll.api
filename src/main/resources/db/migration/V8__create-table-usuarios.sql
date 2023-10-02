/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  JuanAndres
 * Created: 29/09/2023
 */

create table usuarios(

    id bigint not null auto_increment,
    login varchar(100) not null,
    clave varchar(300) not null ,

    primary key(id)
 );