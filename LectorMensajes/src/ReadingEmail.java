

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import javax.mail.*;

public class ReadingEmail {
    public static void main(String[] args) throws Exception {
    	/*Archivo de Propiedades de lectura de credenciales*/
    	String correoDeBusqueda="";
    	String asuntoDeBusqueda="";
    	String FolderLectura="";
    	String FolderDestino="";
    	String servidorCorreo="";
    	String correoLectura="";
    	String contrasenia="";
    	try {
 		   
    		/**Creamos un Objeto de tipo Properties*/
    		   Properties propiedades = new Properties();
    		    
    		   String rutaArchivo = ReadingEmail.class.getProtectionDomain().getCodeSource()
    					.getLocation().getPath();
    		   rutaArchivo=rutaArchivo.replace("ReadingEmail.class", "");
    		   String rutaRelativaArchivo="config.properties";
    		   rutaArchivo=rutaArchivo+rutaRelativaArchivo;
    		   
    		   /**Cargamos el archivo desde la ruta especificada*/
    		   propiedades
    		     .load(new FileInputStream(rutaArchivo));
    		 
    		   /**Obtenemos los parametros definidos en el archivo*/
    		   correoDeBusqueda = propiedades.getProperty("correoDeBusqueda");
    		   asuntoDeBusqueda = propiedades.getProperty("asuntoDeBusqueda");
    		   FolderLectura = propiedades.getProperty("FolderLectura");
    		   FolderDestino = propiedades.getProperty("FolderDestino");
    		   servidorCorreo = propiedades.getProperty("servidorCorreo");
    		   correoLectura = propiedades.getProperty("correoLectura");
    		   contrasenia = propiedades.getProperty("contrasenia");
    		 
		  } catch (FileNotFoundException e) {
			 throw new Exception("Error el Archivo de configuracion no existe");
		  } catch (IOException e) {
			  throw new Exception("Error el Archivo de configuracion no se puede leer");
		  }
    	
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        int start = -1;
        int end = -1;
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect(servidorCorreo,correoLectura,contrasenia);//conectamos al servidor de correos
            Folder inbox = store.getFolder(FolderLectura);//tomamos la carpeta de lectura de correos
            inbox.open(Folder.READ_WRITE);//damos permisos de escritura y lectura
            Message[] msg = inbox.getMessages();
            System.out.println("messages.length---" + msg.length);
            busqueda: for (int i = 0, n = msg.length; i < n; i++) {
            	
            	try{
	            	Message message = msg[i];
	            	//decodificamos el correo electronico para poder enviarlo por WS
	                String correoCompleto=message.getFrom()[0].toString();
			        String correo=correoCompleto.replace(">", "");
			        String []correoSeparado= correo.split("<");
			        String asunto=message.getSubject();
			        try{
			        	 correo=correoSeparado[1].replace("<", "");
			        }catch(Exception e){
			        	 System.out.println("error no es correo");
			        }
			        try{
				        System.out.println("Correo : "+correo);
				         //if(correo.equals(correoDeBusqueda)){
				         //if(asunto.equals(asuntoDeBusqueda)){
			         	 System.out.println("---------------------------------");
				         System.out.println("Email Number " + (i + 1));
				         System.out.println("Subject: " + message.getSubject());
				         System.out.println("From: " + message.getFrom()[0]);
				         String CorreosAdjunto="";
				         //verificamos si es que tiene copias a otros correos
				         try{
				        	 List<String> toAddresses = new ArrayList<String>();
				        	 Address[] recipients = message.getRecipients(Message.RecipientType.CC);
				        	 for (Address address : recipients) {
				        	     toAddresses.add(address.toString());
				        	 }
				        	 for(String lecturaCopias: toAddresses){
				        		 System.out.println("Correo Copias : "+lecturaCopias);
				        		 CorreosAdjunto=CorreosAdjunto+","+lecturaCopias;
				        	 }
				        	 CorreosAdjunto=CorreosAdjunto.substring(1, CorreosAdjunto.length()); 
				         }catch(Exception e){
				        	 System.out.println("no se pudo leer los adjunto error "+ e.getMessage());
				         }
				         
				         System.out.println("Text: " + message.getContent().toString());
				         System.out.println("DESDE: " + correo);
				         List<InputStream> listaAdjuntos= getAttachments(message);
				        
			        	 for(InputStream archivo :listaAdjuntos){
			        		 System.out.println("Existe Adjustos : " + listaAdjuntos.size());
			        		 try{
				        		 File archivoLeido= File.createTempFile("mificherotemporal",null);
				        		 FileUtils.copyInputStreamToFile(archivo,archivoLeido);
					        	 String textoJson="";
					        	 textoJson = Files.toString(archivoLeido, Charsets.UTF_8);//desencriptamos 
					        	 archivoLeido.deleteOnExit();
					        	 ArchivoPlanoCotizaciones envioEncrptado = new ArchivoPlanoCotizaciones();
					        	 try{
					        		 envioEncrptado.notificacion(textoJson,correo,CorreosAdjunto);
					        		 start=message.getMessageNumber();
						        	 end=message.getMessageNumber();
						        	 break busqueda;
					        	 }catch(Exception e){
					        		 System.out.println("Error con el servicio");
					        	 }
			        		 }catch(Exception e){
			        			 System.out.println("Error no es un archivo JSON");
			        		 }
			        	 }
				        	 
				         }catch(Exception e){
				        	 System.out.println("No tiene adjuntos");
				         }
				        	 //}
			         //}
			        
            	}catch(Exception e){
            		e.printStackTrace();
            	}
                
            }
            int tamañoTotal=msg.length-1;
            
            if(start!=-1){
	            msg = inbox.getMessages(start,end);
	            
	            Message message=msg[0];
	            
	            Folder folder = store.getFolder(FolderDestino);
	    	    folder.open(Folder.READ_WRITE);
	    	    inbox.copyMessages(msg, folder);
	    	    
	    	    //tomamos el correo lo cambiamos de carpeta y luego lo eliminamos
	    	    message.setFlag(Flags.Flag.DELETED, true);
	    	    
	    	    for (int i = 0; i < msg.length; i++) {
	    	          if (!msg[i].isSet(Flags.Flag.DELETED))
	    	            System.out.println("Message # " + msg[i] + " not deleted");
	    	    }
	    	    
	    	    folder.close(false);
	    	    inbox.close(true); 
	            store.close();
            }else{
            	System.out.println("No existes archivos con cotizaciones");
            }
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }
    
    public static List<InputStream> getAttachments(Message message) throws Exception {
	    Object content = message.getContent();
	    if (content instanceof String)
	        return null;        

	    if (content instanceof Multipart) {
	        Multipart multipart = (Multipart) content;
	        List<InputStream> result = new ArrayList<InputStream>();

	        for (int i = 0; i < multipart.getCount(); i++) {
	            result.addAll(getAttachments(multipart.getBodyPart(i)));
	        }
	        return result;

	    }
	    return null;
	}
	private static List<InputStream> getAttachments(BodyPart part) throws Exception {
	    List<InputStream> result = new ArrayList<InputStream>();
	    Object content = part.getContent();
	    if (content instanceof InputStream || content instanceof String) {
	        if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition()) || StringUtils.isNotBlank(part.getFileName())) {
	            result.add(part.getInputStream());
	            return result;
	        } else {
	            return new ArrayList<InputStream>();
	        }
	    }

	    if (content instanceof Multipart) {
	            Multipart multipart = (Multipart) content;
	            for (int i = 0; i < multipart.getCount(); i++) {
	                BodyPart bodyPart = multipart.getBodyPart(i);
	                result.addAll(getAttachments(bodyPart));
	            }
	    }
	    return result;
	}
    
	private void leerArchivo() {
		  try {
		   
		/**Creamos un Objeto de tipo Properties*/
		   Properties propiedades = new Properties();
		    
		   String rutaArchivo = ReadingEmail.class.getProtectionDomain().getCodeSource()
					.getLocation().getPath();
		   rutaArchivo=rutaArchivo.replace("ReadingEmail.class", "");
		   String rutaRelativaArchivo="config.properties";
		   rutaArchivo=rutaArchivo+rutaRelativaArchivo;
		   
		   /**Cargamos el archivo desde la ruta especificada*/
		   propiedades
		     .load(new FileInputStream(rutaArchivo));
		 
		   /**Obtenemos los parametros definidos en el archivo*/
		   String nombre = propiedades.getProperty("nombre");
		   String pagina = propiedades.getProperty("pagina");
		 
		   /**Imprimimos los valores*/
		   System.out.println("Nombre: "+nombre + "\n" +"Pagina: "+ pagina);
		       
		    
		  } catch (FileNotFoundException e) {
		   System.out.println("Error, El archivo no exite");
		  } catch (IOException e) {
		   System.out.println("Error, No se puede leer el archivo");
		  }
		 }
}