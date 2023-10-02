/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  JuanAndres
 * Created: 30/09/2023
 */

alter table medicos add activo tinyint;
update medicos set activo = 1;