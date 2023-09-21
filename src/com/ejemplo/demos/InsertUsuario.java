package com.ejemplo.demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ejemplo.entidades.Usuario;

public class InsertUsuario {

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
			
			// vamos a crear un objeto de tipo Usuario para lleanrlo a través del contructor definido con los datos de la tabla
			Usuario user = new Usuario("Cliente","CAMILO","RAMIREZ","123456","001*","3004568796","camilo@hotmail","Calle 250sur",27); 
			session.save(user);
			
			session.getTransaction().commit();
			
			// Una vez realizada la acción imprimimos un mensaje
			
			System.out.println("Registro fue almacenado!!");
			
		} finally {
			factory.close();
		}
	}

}
