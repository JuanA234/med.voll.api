/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  JuanAndres
 * Created: 30/09/2023
 */

alter table pacientes add column activo tinyint;
update pacientes set activo = 1;
alter table pacientes modify activo tinyint not null;