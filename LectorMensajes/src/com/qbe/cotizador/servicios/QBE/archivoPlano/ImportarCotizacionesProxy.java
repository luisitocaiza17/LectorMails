package com.qbe.cotizador.servicios.QBE.archivoPlano;

public class ImportarCotizacionesProxy implements com.qbe.cotizador.servicios.QBE.archivoPlano.ImportarCotizaciones {
  private String _endpoint = null;
  private com.qbe.cotizador.servicios.QBE.archivoPlano.ImportarCotizaciones importarCotizaciones = null;
  
  public ImportarCotizacionesProxy() {
    _initImportarCotizacionesProxy();
  }
  
  public ImportarCotizacionesProxy(String endpoint) {
    _endpoint = endpoint;
    _initImportarCotizacionesProxy();
  }
  
  private void _initImportarCotizacionesProxy() {
    try {
      importarCotizaciones = (new com.qbe.cotizador.servicios.QBE.archivoPlano.ImportarCotizacionesServiceLocator()).getImportarCotizaciones();
      if (importarCotizaciones != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)importarCotizaciones)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)importarCotizaciones)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (importarCotizaciones != null)
      ((javax.xml.rpc.Stub)importarCotizaciones)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.qbe.cotizador.servicios.QBE.archivoPlano.ImportarCotizaciones getImportarCotizaciones() {
    if (importarCotizaciones == null)
      _initImportarCotizacionesProxy();
    return importarCotizaciones;
  }
  
  public com.qbe.cotizador.servicios.QBE.archivoPlano.ObjetosRespuesta[] importarCotizaciones(java.lang.String textoJson, java.lang.String correo, java.lang.String CCCorreos) throws java.rmi.RemoteException{
    if (importarCotizaciones == null)
      _initImportarCotizacionesProxy();
    return importarCotizaciones.importarCotizaciones(textoJson, correo, CCCorreos);
  }
  
  
}