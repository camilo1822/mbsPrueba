package prueba.jpa.model;

import java.io.Serializable;
import javax.persistence.*;

import prueba.jpa.util.ConstantJPA;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * The persistent class for the TARJETA_VIRTUAL database table.
 * 
 */
@Entity
@Table(name = ConstantJPA.COMMON_STRING_ENTITY_TARJETA_VIRTUAL, schema = ConstantJPA.COMMON_STRING_SHBANCA_DIGITAL)
@NamedQuery(name = ConstantJPA.NAMED_QUERY_TARJETA_VIRTUAL_GET_CARD_NAME, query = ConstantJPA.NAMED_QUERY_TARJETA_VIRTUAL_GET_CARD_QUERY)
public class TarjetaVirtual implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "TARJETA_VIRTUAL_TARJETAVIRTUALID_GENERATOR", sequenceName = "SHBANCA_DIGITAL.TARJETA_VIRTUAL_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TARJETA_VIRTUAL_TARJETAVIRTUALID_GENERATOR")
    @Column(name = "TARJETA_VIRTUAL_ID")
    private long tarjetaVirtualId;

    private BigDecimal color;

    private BigDecimal estado;

    @Column(name = "FECHA_CREACION")
    private Timestamp fechaCreacion;

    @Column(name = "FECHA_MODIFICACION")
    private Timestamp fechaModificacion;

    @Column(name = "TARJETA_ID")
    private String tarjetaId;

    @Column(name = "TIPO_TARJETA")
    private String tipoTarjeta;

    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;

    @Column(name = "USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @Column(name = "VERIFICACION_HASH")
    private String verificacionHash;

    // bi-directional many-to-one association to Cliente
    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;

    public TarjetaVirtual() {
    }

    public long getTarjetaVirtualId() {
        return this.tarjetaVirtualId;
    }

    public void setTarjetaVirtualId(long tarjetaVirtualId) {
        this.tarjetaVirtualId = tarjetaVirtualId;
    }

    public BigDecimal getColor() {
        return this.color;
    }

    public void setColor(BigDecimal color) {
        this.color = color;
    }

    public BigDecimal getEstado() {
        return this.estado;
    }

    public void setEstado(BigDecimal estado) {
        this.estado = estado;
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

    public String getTarjetaId() {
        return this.tarjetaId;
    }

    public void setTarjetaId(String tarjetaId) {
        this.tarjetaId = tarjetaId;
    }

    public String getTipoTarjeta() {
        return this.tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getUsuarioCreacion() {
        return this.usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getUsuarioModificacion() {
        return this.usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getVerificacionHash() {
        return this.verificacionHash;
    }

    public void setVerificacionHash(String verificacionHash) {
        this.verificacionHash = verificacionHash;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}