package com.tar1ihc.tar1ihc.model;

import lombok.Data;

@Data
public class ReporteNotasTemplate {
    String idReporte;
    String idAlumno;
    Integer evaContinua;
    Integer evaParcial;
    Integer evaFinal;
    String reclamo;
}
