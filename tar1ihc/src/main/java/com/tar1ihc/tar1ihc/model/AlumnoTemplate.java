package com.tar1ihc.tar1ihc.model;

import lombok.Data;

@Data
public class AlumnoTemplate {
    String idAlumno;
    String idDocente;
    String apellidoPaterno;
    String apellidoMaterno;
    String nombres;
    String correoInst;
    Long numTelef;
    Boolean rol;
    Short grupo;
    Short numMatAnt;
}