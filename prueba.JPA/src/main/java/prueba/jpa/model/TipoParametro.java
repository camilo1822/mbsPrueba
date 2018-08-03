package prueba.jpa.model;

import java.io.Serializable;
import javax.persistence.*;

import prueba.jpa.util.ConstantJPA;

import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the TIPO_PARAMETRO database table.
 * 
 */
@Entity
@Table(name = ConstantJPA.COMMON_STRING_ENTITY_TIPO_PARAMETRO, schema = ConstantJPA.COMMON_STRING_SHBANCA_DIGITAL)
@NamedQuery(name = ConstantJPA.NAMED_QUERY_TIPO_PARAMETRO_FIND_ALL, query = ConstantJPA.NAMED_QUERY_TIPO_PARAMETRO_SELECT_ALL)
public class TipoParametro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TIPO_PARAMETRO_ID")
    private long tipoParametroId;

    private String descripcion;

    @Column(name = "FECHA_CREACION")
    private Timestamp fechaCreacion;

    @Column(name = "FECHA_MODIFICACION")
    private Timestamp fechaModificacion;

    private String nombre;

    private String sistema;

    @Column(name = "USR_CREACION")
    private String usrCreacion;

    @Column(name = "USR_MODIFICACION")
    private String usrModificacion;

    // bi-directional many-to-one association to Parametro
    @OneToMany(mappedBy = "tipoParametro")
    private List<Parametro> parametros;

    public TipoParametro() {
    }

    public long getTipoParametroId() {
        return this.tipoParametroId;
    }

    public void setTipoParametroId(long tipoParametroId) {
        this.tipoParametroId = tipoParametroId;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getSistema() {
        return this.sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
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
        parametro.setTipoParametro(this);

        return parametro;
    }

    public Parametro removeParametro(Parametro parametro) {
        getParametros().remove(parametro);
        parametro.setTipoParametro(null);

        return parametro;
    }

}