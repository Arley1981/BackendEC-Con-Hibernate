package com.ejemplo.demos;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ejemplo.entidades.Cliente;
import com.ejemplo.entidades.CuentaCredito;


public class InsertCliente {

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
					
					// vamos a crear un objeto de tipo cliente para lleanrlo a través del contructor definido con los datos de la tabla
					Cliente cliente = new Cliente("MILENA","LOPEZ","45256897","022*","444589","milena@hotmail.com","Calle 20oeste",32);
					
					CuentaCredito cuentaCredito= new CuentaCredito();
					cuentaCredito.setEstado("debe");
					cuentaCredito.setSaldo(250000);
					
					cliente.setCuentaCredito(cuentaCredito);
					cuentaCredito.setCliente(cliente);
					
					
										
					session.save(cliente);
					session.save(cuentaCredito);
					
					session.getTransaction().commit();
					
					// Una vez realizada la acción imprimimos un mensaje
					
					System.out.println("Cliente fue almacenado!!");
					
				} finally {
					factory.close();
				}
			}
		
		
	

}
