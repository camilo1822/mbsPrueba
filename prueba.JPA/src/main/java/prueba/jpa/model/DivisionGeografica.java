package prueba.jpa.model;

import java.io.Serializable;
import javax.persistence.*;

import prueba.jpa.util.ConstantJPA;

import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the DIVISION_GEOGRAFICA database table.
 * 
 */
@Entity
@Table(name = ConstantJPA.COMMON_STRING_ENTITY_DIVISION_GEOGRAFICA, schema = ConstantJPA.COMMON_STRING_SHBANCA_DIGITAL)
@NamedQuery(name = ConstantJPA.NAMED_QUERY_DIVISION_GEOGRAFICA_FIND_ALL, query = ConstantJPA.NAMED_QUERY_DIVISION_GEOGRAFICA_SELECT_ALL)
public class DivisionGeografica implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CODIGO_DIVISION")
    private String codigoDivision;

    private String abreviatura;

    @Column(name = "CIUDAD_CANDIDATA")
    private String ciudadCandidata;

    @Column(name = "CODIGO_POSTAL")
    private String codigoPostal;

    @Column(name = "FECHA_CREACION")
    private Timestamp fechaCreacion;

    @Column(name = "FECHA_MODIFICACION")
    private Timestamp fechaModificacion;

    private String nombre;

    private String padre;

    @Column(name = "TIPO_DIVISION")
    private String tipoDivision;

    @Column(name = "USR_CREACION")
    private String usrCreacion;

    @Column(name = "USR_MODIFICACION")
    private String usrModificacion;

    // bi-directional many-to-one association to Parametro
    @OneToMany(mappedBy = "divisionGeografica")
    private List<Parametro> parametros;

    public DivisionGeografica() {
    }

    public String getCodigoDivision() {
        return this.codigoDivision;
    }

    public void setCodigoDivision(String codigoDivision) {
        this.codigoDivision = codigoDivision;
    }

    public String getAbreviatura() {
        return this.abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getCiudadCandidata() {
        return this.ciudadCandidata;
    }

    public void setCiudadCandidata(String ciudadCandidata) {
        this.ciudadCandidata = ciudadCandidata;
    }

    public String getCodigoPostal() {
        return this.codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Timestamp getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Timestamp getFechaModificacion() {
        return this.fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPadre() {
        return this.padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public String getTipoDivision() {
        return this.tipoDivision;
    }

    public void setTipoDivision(String tipoDivision) {
        this.tipoDivision = tipoDivision;
    }

    public String getUsrCreacion() {
        return this.usrCreacion;
    }

    public void setUsrCreacion(String usrCreacion) {
        this.usrCreacion = usrCreacion;
    }

    public String getUsrModificacion() {
        return this.usrModificacion;
    }

    public void setUsrModificacion(String usrModificacion) {
        this.usrModificacion = usrModificacion;
    }

    public List<Parametro> getParametros() {
        return this.parametros;
    }

    public void setParametros(List<Parametro> parametros) {
        this.parametros = parametros;
    }

    public Parametro addParametro(Parametro parametro) {
        getParametros().add(parametro);
        parametro.setDivisionGeografica(this);

        return parametro;
    }

    public Parametro removeParametro(Parametro parametro) {
        getParametros().remove(parametro);
        parametro.setDivisionGeografica(null);

        return parametro;
    }

}