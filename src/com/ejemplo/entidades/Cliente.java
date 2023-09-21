package com.ejemplo.entidades;




import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name= "cliente")
public class Cliente {

	// Definimos los atributos para reflejar las columnas de la tabla usuario/
	
		//creamos notaciones para cada atributo
		   
		   @Id
		   @GeneratedValue(strategy = GenerationType.IDENTITY)
		   @Column(name= "id_cliente")
		   private int idcliente;
		   @Column(name= "nombres")
		   private String nombres;
		   @Column(name= "apellidos")
		   private String apellidos;
		   @Column(name= "identificación")
		   private String identificación;
		   @Column(name= "contraseña")
		   private String contraseña;
		   @Column(name= "telefono")
		   private String telefono;
		   @Column(name= "email")
		   private String email;
		   @Column(name= "dirección")
		   private String dirección;
		   @Column(name= "edad")
		   private int edad;
		   
		   @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
		  private CuentaCredito cuentaCredito;
		   
		// creamos un constructor vacío
		   public Cliente() {		   
		   }

		public Cliente(String nombres, String apellidos, String identificación, String contraseña,
				String telefono, String email, String dirección, int edad) {
			
			this.nombres = nombres;
			this.apellidos = apellidos;
			this.identificación = identificación;
			this.contraseña = contraseña;
			this.telefono = telefono;
			this.email = email;
			this.dirección = dirección;
			this.edad = edad;
		}

		// Generamos los getters and setters para todos los atributos 
		
		public int getIdcliente() {
			return idcliente;
		}

		public void setIdcliente(int idcliente) {
			this.idcliente = idcliente;
		}

		public String getNombres() {
			return nombres;
		}

		
		public void setNombres(String nombres) {
			this.nombres = nombres;
		}

		public String getApellidos() {
			return apellidos;
		}

		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}

		public String getIdentificación() {
			return identificación;
		}

		public void setIdentificación(String identificación) {
			this.identificación = identificación;
		}

		public String getContraseña() {
			return contraseña;
		}

		public void setContraseña(String contraseña) {
			this.contraseña = contraseña;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getDirección() {
			return dirección;
		}

		public void setDirección(String dirección) {
			this.dirección = dirección;
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public CuentaCredito getCuentaCredito() {
			return cuentaCredito;
		}

		public void setCuentaCredito(CuentaCredito cuentaCredito) {
			this.cuentaCredito = cuentaCredito;
		}

		@Override
		public String toString() {
			return "Cliente [idcliente=" + idcliente + ", nombres=" + nombres + ", apellidos=" + apellidos
					+ ", identificación=" + identificación + ", contraseña=" + contraseña + ", telefono=" + telefono
					+ ", email=" + email + ", dirección=" + dirección + ", edad=" + edad + ", cuentaCredito="
					+ cuentaCredito + "]";
		}

		
				
		
		
}

		