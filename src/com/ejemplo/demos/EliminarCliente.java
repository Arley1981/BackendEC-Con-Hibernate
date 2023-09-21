package com.ejemplo.demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ejemplo.entidades.Cliente;
import com.ejemplo.entidades.CuentaCredito;


public class EliminarCliente {

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
			
			session.beginTransaction();
		
		    Cliente cliente = session.get(Cliente.class, 15);

		    if (cliente != null) {
		    	CuentaCredito cuentaCredito = cliente.getCuentaCredito();
		        
		     if(cuentaCredito != null) {
		    	 session.delete(cuentaCredito);
		     }
		     	session.delete(cliente);
		    }

		    
		    
		    session.getTransaction().commit();
			
			// Una vez realizada la transacción imprimimos un mensaje					
			System.out.println("Proceso finalizado!!");
			
		} finally {
			factory.close();
		}

		
	}

}
