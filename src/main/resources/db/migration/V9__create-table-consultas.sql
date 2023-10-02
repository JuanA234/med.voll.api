/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  JuanAndres
 * Created: 29/09/2023
 */

create table consultas(

    id bigint not null auto_increment,
    medico_id bigint not null,
    paciente_id bigint not null ,
    date datetime not null,

    primary key(id),

    constraint fk_consultas_medico_id foreign key(medico_id) references medicos(id),
    constraint fk_consultas_paciente_id foreign key(paciente_id) references pacientes(id)
 );