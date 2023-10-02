/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  JuanAndres
 * Created: 30/09/2023
 */

alter table medicos 
add codigoPostal varchar(9) not null,
add urbanización varchar(100) not null,
add provincia varchar(100) not null;

alter table pacientes
add alle varchar(100) not null;