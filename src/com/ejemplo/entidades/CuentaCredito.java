package com.ejemplo.entidades;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "cuenta_credito")
public class CuentaCredito {

	//creamos notaciones para cada atributo
	   
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name= "id_cuenta")
	   private int idcuenta;
	   @Column(name= "estado")
	   private String estado;   
	   @Column(name= "saldo")
	   private double saldo;
	   @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
	   @OneToOne( fetch = FetchType.LAZY)	   
	   private Cliente cliente;
	   
	   
	// creamos un constructor vacío
	   public CuentaCredito() {		   
	   }
	   
	   public CuentaCredito(String estado,  int saldo) {
			
			this.estado = estado;			
			this.saldo = saldo;
			
		}

	public int getIdcuenta() {
		return idcuenta;
	}

	public void setIdcuenta(int idcuenta) {
		this.idcuenta = idcuenta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "CuentaCredito [idcuenta=" + idcuenta + ", estado=" + estado + ", saldo=" + saldo + ", cliente="
				+ cliente + "]";
	}

	
		   
}
