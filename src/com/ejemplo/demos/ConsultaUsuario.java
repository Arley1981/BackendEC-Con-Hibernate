package com.ejemplo.demos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.ejemplo.entidades.Usuario;

public class ConsultaUsuario {

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
					
					//Definimos objeto de respuesta a la entidad que refleja la tabla
					Usuario resultado = session.get(Usuario.class, 12);
					
					// Imprimimos en consola el mensaje
					System.out.println("Registro obtenido" + resultado);
					
					
					List<Usuario> resultados = session.createQuery("from Usuario").list(); 
					System.out.println("n/Consulta general");
					//Hacemos recorrido utilizando forech para imprimir los objetos que encuentre su respectiva información
					for (Usuario u : resultados) {
						System.out.println(u);
					} 
						
					
					session.getTransaction().commit();
					
					// Una vez realizada la transacción imprimimos un mensaje
					
					System.out.println("Proceso finalizado!!");
					
				} finally {
					factory.close();
				}
			}
		
	}


