package com.mballem.curso.jasper.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class JasperReportsSpringApplication {

	public static void main(String[] args) throws SQLException {

//		abrirJrxml("01");
		//exportarParaPDF("01","C:\\Users\\Ednilson\\Desktop\\"+"jasper-" + UUID.randomUUID()+ ".pdf");
//        abrirPontoJasper("01");
//
		SpringApplication.run(JasperReportsSpringApplication.class, args);
	}

	private static void abrirPontoJasper(String numero) throws SQLException {
		Connection connection = JdbcConnection.connection();
		JasperService service = new JasperService();
		service.abrirPontoJasper("jasper/produtos-" +numero+ ".jasper",connection);
		connection.close();
	}

	private static void exportarParaPDF(String numero, String saida) throws SQLException {
		Connection connection = JdbcConnection.connection();
		JasperService service = new JasperService();
		service.exportarParaPDF("relatorios/jrxml/produtos-"+numero+ ".jrxml",connection, saida);
		connection.close();

	}

	private static void abrirJrxml(String numero) throws SQLException {
		Connection connection = JdbcConnection.connection();
		JasperService service = new JasperService();
		service.abrirJasperViewer("relatorios/jrxml/funcionarios-"+numero+ ".jrxml",connection);
		connection.close();
	}

}
