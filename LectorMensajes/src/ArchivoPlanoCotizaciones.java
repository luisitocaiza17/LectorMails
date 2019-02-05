import java.rmi.RemoteException;

import com.qbe.cotizador.servicios.QBE.archivoPlano.ImportarCotizaciones;
import com.qbe.cotizador.servicios.QBE.archivoPlano.ImportarCotizacionesProxy;
import com.qbe.cotizador.servicios.QBE.archivoPlano.ObjetosRespuesta;


public class ArchivoPlanoCotizaciones {

	public void notificacion(String encriptado, String correo,String CCCorreos) throws RemoteException{
		ImportarCotizaciones cotizaciones = new ImportarCotizacionesProxy();
		ObjetosRespuesta[] respuesta= cotizaciones.importarCotizaciones(encriptado, correo, CCCorreos);
		System.out.println("Proceso Finalizado");
	}
}
