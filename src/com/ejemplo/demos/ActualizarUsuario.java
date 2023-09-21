package com.ejemplo.demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ejemplo.entidades.Usuario;

public class ActualizarUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//Creamoos método SessionFactory
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class)
				.buildSessionFactory();
		
		// creación de la session a partir del Session factory
		Session session= factory.getCurrentSession();
		
		// Creamos bloque try finally para insertar la logica y cerrrar la fábrica
		try {
			
			// Ahora se puede usar el objeto session para la manipulación de la BD
			session.beginTransaction();
//utilizamos la Entidad Usuario y hacemos una consulta a través del objeto Session, y el método “get” 
			//mapeando la clase Usuario, y el Id del registro que queremos actualizar
			
			Usuario per= session.get(Usuario.class, 12);
			per.setNombres("CAMILO ANDRES");				
			
			
			session.update(per);
			
					
			
// En esta manera utilizamos directamente HQL				
			session.createQuery("update Usuario u set u.rol = 'Cliente' where u.rol= 'Cajero (a)' ").executeUpdate();
			
			session.getTransaction().commit();
			
			// Una vez realizada la transacción imprimimos un mensaje					
			System.out.println("Proceso finalizado!!");
			
		} finally {
			factory.close();
		}	
		
		
	}
	

}
