package model.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import util.ValidacaoException;

@Entity
@Table(name="TB_PEDIDO")
public class Pedido implements Serializable {
	
	/**
	 * 	
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="NR_PEDIDO")
	private Integer numero;
	
	@ManyToOne
	@JoinColumn(name = "CD_CLIENTE",nullable = false)
	private Cliente cliente;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_PEDIDO")
	private Date dataHora;

	public Pedido() {
		super();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	
	public String getDataHoraString() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataHora); 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	
	public void validar() throws ValidacaoException {
		if (cliente == null) {
			throw new ValidacaoException("Cliente deve ser selecionado");
		}
	}

	
}
