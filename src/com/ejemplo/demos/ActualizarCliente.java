package com.ejemplo.demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ejemplo.entidades.Cliente;
import com.ejemplo.entidades.CuentaCredito;


public class ActualizarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creamoos método SessionFactory
				SessionFactory factory= new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Cliente.class)
						.addAnnotatedClass(CuentaCredito.class)
						.buildSessionFactory();
				
				// creación de la session a partir del Session factory
				Session session= factory.getCurrentSession();
				
				// Creamos bloque try finally para insertar la logica y cerrrar la fábrica
				try {
					
					// Ahora se puede usar el objeto session para la manipulación de la BD
					session.beginTransaction();
		//utilizamos la Entidad Usuario y hacemos una consulta a través del objeto Session, y el método “get” 
					//mapeando la clase Usuario, y el Id del registro que queremos actualizar
					
					Cliente per= session.get(Cliente.class, 15);
					per.setNombres("SANDRA MILENA");				
					
					
					session.update(per);
					
							
					
		// En esta manera utilizamos directamente HQL				
					session.createQuery("update Cliente Cl set Cl.contraseña = '005*' where Cl.contraseña= '003*' ").executeUpdate();
					
					session.getTransaction().commit();
					
					// Una vez realizada la transacción imprimimos un mensaje					
					System.out.println("Proceso finalizado!!");
					
				} finally {
					factory.close();
				}	
		
	}

}
