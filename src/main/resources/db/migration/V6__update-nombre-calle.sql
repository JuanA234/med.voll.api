/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  JuanAndres
 * Created: 30/09/2023
 */


ALTER TABLE pacientes
ADD COLUMN calle varchar(100) not null;

UPDATE pacientes
SET calle = alle;


ALTER TABLE pacientes
DROP COLUMN alle;
