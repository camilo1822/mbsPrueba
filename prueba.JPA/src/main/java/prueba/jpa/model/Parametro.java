package prueba.jpa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import prueba.jpa.util.ConstantJPA;


/**
 * The persistent class for the PARAMETRO database table.
 * 
 */
@Entity
@Table(name = ConstantJPA.COMMON_STRING_ENTITY_PARAMETRO, schema = ConstantJPA.COMMON_STRING_SHBANCA_DIGITAL)
@NamedQuery(name=ConstantJPA.QUERY_PARAMETER_BY_REGION, query=ConstantJPA.NAMED_QUERY_PARAMETRO_GET_PARAMETER_BY_REGION)
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PARAMETRO_ID")
	private long parametroId;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	@Column(name="FECHA_MODIFICACION")
	private Timestamp fechaModificacion;

	private String nombre;

	private BigDecimal orden;

	@Column(name="USR_CREACION")
	private String usrCreacion;

	@Column(name="USR_MODIFICACION")
	private String usrModificacion;

	@Lob
	private String valor;

	//bi-directional many-to-one association to TipoParametro
	@ManyToOne
	@JoinColumn(name="TIPO_PARAMETRO_ID")
	private TipoParametro tipoParametro;

	//bi-directional many-to-one association to DivisionGeografica
	@ManyToOne
	@JoinColumn(name="PAIS_ID")
	private DivisionGeografica divisionGeografica;

	public Parametro() {
	}

	public long getParametroId() {
		return this.parametroId;
	}

	public void setParametroId(long parametroId) {
		this.parametroId = parametroId;
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

	public BigDecimal getOrden() {
		return this.orden;
	}

	public void setOrden(BigDecimal orden) {
		this.orden = orden;
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

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public TipoParametro getTipoParametro() {
		return this.tipoParametro;
	}

	public void setTipoParametro(TipoParametro tipoParametro) {
		this.tipoParametro = tipoParametro;
	}

	public DivisionGeografica getDivisionGeografica() {
		return this.divisionGeografica;
	}

	public void setDivisionGeografica(DivisionGeografica divisionGeografica) {
		this.divisionGeografica = divisionGeografica;
	}

}