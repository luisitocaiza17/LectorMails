/**
 * ImportarCotizaciones.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.qbe.cotizador.servicios.QBE.archivoPlano;

public interface ImportarCotizaciones extends java.rmi.Remote {
    public com.qbe.cotizador.servicios.QBE.archivoPlano.ObjetosRespuesta[] importarCotizaciones(java.lang.String textoJson, java.lang.String correo, java.lang.String CCCorreos) throws java.rmi.RemoteException;
}
