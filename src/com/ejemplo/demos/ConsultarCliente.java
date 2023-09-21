package com.ejemplo.demos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ejemplo.entidades.Cliente;
import com.ejemplo.entidades.CuentaCredito;


public class ConsultarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(CuentaCredito.class)
				.buildSessionFactory();
	
	// creación de la session a partir del Session factory
	Session session = factory.getCurrentSession();
	try {
		
		// Ahora se puede usar el objeto session para la manipulación de la BD
		session.beginTransaction();
		
		 int idCliente = 15; // Reemplaza con el ID del cliente que deseas consultar

		    Cliente cliente = session.get(Cliente.class, idCliente);

		    if (cliente != null) {
		        System.out.println("idcliente: " + cliente.getIdcliente());
		        System.out.println("Nombres: " + cliente.getNombres());
		        System.out.println("Apellidos: " + cliente.getApellidos());
		        // ... otros atributos del cliente

		        CuentaCredito cuentaCredito = cliente.getCuentaCredito();
		        if (cuentaCredito != null) {
		            System.out.println("idcuenta: " + cuentaCredito.getIdcuenta());
		            System.out.println("Saldo: " + cuentaCredito.getSaldo());
		            System.out.println("Estado: " + cuentaCredito.getEstado());
		        } else {
		            System.out.println("Este cliente no tiene una cuenta asociada.");
		        }
		    } else {
		        System.out.println("Cliente no encontrado.");
		    }
		    
		    /*List<Cliente> clientes = session.createQuery("FROM Cliente", Cliente.class).getResultList();

		    
		    for (Cliente cliente : clientes) {
		        System.out.println("idcliente: " + cliente.getIdcliente());
		        System.out.println("Nombres: " + cliente.getNombres());
		        System.out.println("Apellidos: " + cliente.getApellidos());
		        // ... otros atributos del cliente

		        CuentaCredito cuentaCredito = cliente.getCuentaCredito();
		        if (cuentaCredito != null) {
		            System.out.println("idcuenta: " + cuentaCredito.getIdcuenta());
		            System.out.println("Saldo: " + cuentaCredito.getSaldo());
		            System.out.println("Estado: " + cuentaCredito.getEstado());
		        } else {
		            System.out.println("Este cliente no tiene una cuenta asociada.");
		        }*/
		    
		session.getTransaction().commit();
		
		// Una vez realizada la transacción imprimimos un mensaje
		
		System.out.println("Proceso finalizado!!");
		    
	} finally {
		factory.close();
	}

		
	}

}
