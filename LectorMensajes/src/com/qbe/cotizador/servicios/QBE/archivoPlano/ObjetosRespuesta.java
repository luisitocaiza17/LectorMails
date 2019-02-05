/**
 * ObjetosRespuesta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.qbe.cotizador.servicios.QBE.archivoPlano;

public class ObjetosRespuesta  implements java.io.Serializable {
    private java.lang.String beneficiario;

    private java.lang.String comentario;

    private java.lang.String cotizacionID;

    private int estado;

    private java.lang.String facturaID;

    private java.lang.String objetoCotizacionID;

    public ObjetosRespuesta() {
    }

    public ObjetosRespuesta(
           java.lang.String beneficiario,
           java.lang.String comentario,
           java.lang.String cotizacionID,
           int estado,
           java.lang.String facturaID,
           java.lang.String objetoCotizacionID) {
           this.beneficiario = beneficiario;
           this.comentario = comentario;
           this.cotizacionID = cotizacionID;
           this.estado = estado;
           this.facturaID = facturaID;
           this.objetoCotizacionID = objetoCotizacionID;
    }


    /**
     * Gets the beneficiario value for this ObjetosRespuesta.
     * 
     * @return beneficiario
     */
    public java.lang.String getBeneficiario() {
        return beneficiario;
    }


    /**
     * Sets the beneficiario value for this ObjetosRespuesta.
     * 
     * @param beneficiario
     */
    public void setBeneficiario(java.lang.String beneficiario) {
        this.beneficiario = beneficiario;
    }


    /**
     * Gets the comentario value for this ObjetosRespuesta.
     * 
     * @return comentario
     */
    public java.lang.String getComentario() {
        return comentario;
    }


    /**
     * Sets the comentario value for this ObjetosRespuesta.
     * 
     * @param comentario
     */
    public void setComentario(java.lang.String comentario) {
        this.comentario = comentario;
    }


    /**
     * Gets the cotizacionID value for this ObjetosRespuesta.
     * 
     * @return cotizacionID
     */
    public java.lang.String getCotizacionID() {
        return cotizacionID;
    }


    /**
     * Sets the cotizacionID value for this ObjetosRespuesta.
     * 
     * @param cotizacionID
     */
    public void setCotizacionID(java.lang.String cotizacionID) {
        this.cotizacionID = cotizacionID;
    }


    /**
     * Gets the estado value for this ObjetosRespuesta.
     * 
     * @return estado
     */
    public int getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this ObjetosRespuesta.
     * 
     * @param estado
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }


    /**
     * Gets the facturaID value for this ObjetosRespuesta.
     * 
     * @return facturaID
     */
    public java.lang.String getFacturaID() {
        return facturaID;
    }


    /**
     * Sets the facturaID value for this ObjetosRespuesta.
     * 
     * @param facturaID
     */
    public void setFacturaID(java.lang.String facturaID) {
        this.facturaID = facturaID;
    }


    /**
     * Gets the objetoCotizacionID value for this ObjetosRespuesta.
     * 
     * @return objetoCotizacionID
     */
    public java.lang.String getObjetoCotizacionID() {
        return objetoCotizacionID;
    }


    /**
     * Sets the objetoCotizacionID value for this ObjetosRespuesta.
     * 
     * @param objetoCotizacionID
     */
    public void setObjetoCotizacionID(java.lang.String objetoCotizacionID) {
        this.objetoCotizacionID = objetoCotizacionID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObjetosRespuesta)) return false;
        ObjetosRespuesta other = (ObjetosRespuesta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.beneficiario==null && other.getBeneficiario()==null) || 
             (this.beneficiario!=null &&
              this.beneficiario.equals(other.getBeneficiario()))) &&
            ((this.comentario==null && other.getComentario()==null) || 
             (this.comentario!=null &&
              this.comentario.equals(other.getComentario()))) &&
            ((this.cotizacionID==null && other.getCotizacionID()==null) || 
             (this.cotizacionID!=null &&
              this.cotizacionID.equals(other.getCotizacionID()))) &&
            this.estado == other.getEstado() &&
            ((this.facturaID==null && other.getFacturaID()==null) || 
             (this.facturaID!=null &&
              this.facturaID.equals(other.getFacturaID()))) &&
            ((this.objetoCotizacionID==null && other.getObjetoCotizacionID()==null) || 
             (this.objetoCotizacionID!=null &&
              this.objetoCotizacionID.equals(other.getObjetoCotizacionID())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getBeneficiario() != null) {
            _hashCode += getBeneficiario().hashCode();
        }
        if (getComentario() != null) {
            _hashCode += getComentario().hashCode();
        }
        if (getCotizacionID() != null) {
            _hashCode += getCotizacionID().hashCode();
        }
        _hashCode += getEstado();
        if (getFacturaID() != null) {
            _hashCode += getFacturaID().hashCode();
        }
        if (getObjetoCotizacionID() != null) {
            _hashCode += getObjetoCotizacionID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObjetosRespuesta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://archivoPlano.QBE.servicios.cotizador.qbe.com", "ObjetosRespuesta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("beneficiario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://archivoPlano.QBE.servicios.cotizador.qbe.com", "beneficiario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comentario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://archivoPlano.QBE.servicios.cotizador.qbe.com", "comentario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cotizacionID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://archivoPlano.QBE.servicios.cotizador.qbe.com", "cotizacionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://archivoPlano.QBE.servicios.cotizador.qbe.com", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("facturaID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://archivoPlano.QBE.servicios.cotizador.qbe.com", "facturaID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objetoCotizacionID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://archivoPlano.QBE.servicios.cotizador.qbe.com", "objetoCotizacionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
