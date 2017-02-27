import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//gli import sono tutti di java.sql

public class SqlInsert {
	
	
	
	public static void main(String[] args) {
		
		String dbUrl = "jdbc:mysql://localhost:3306/js2017"; //connessione all'indirizzo del db
		String username = "root";
		String password = "";
		
		Connection miaConn = null;
		Statement mioStat =	null;
		ResultSet rs = null;

		try { //glielofaccio fare in automatico dopo aver scritto la riga sottostante
			
		//1 ricevi la connessione al databse	
		miaConn = DriverManager.getConnection(dbUrl, username, password);
		
		//2 crea uno statement
		mioStat = miaConn.createStatement();
		
		//3 Inserisco un nuovo record
		System.out.println("inserisco un nuovo record");
		
		
		//4 esegui una Query Sql
		String sql = "INSERT INTO `studenti` (`studente_id`, `nome`, `cognome`, `data_nascita`, `eta`, `sesso`) VALUES (NULL, 'Mauro', 'Bogliaccino', '1964-02-07', NULL, NULL);";
		
		int righeInteressate = mioStat.executeUpdate(sql);
	
		//5 aggiorna elenco studenti
		rs = mioStat.executeQuery("select * from js2017.studenti");
		
		//6 processa il resultSet, il metodo next() sposta il cursore in avanti di una posizione e lo fa fin quando ci sono record
			while(rs.next()){
				System.out.print(rs.getString("nome") + "\t");  //richiamo il tipo del dato 
				System.out.println(rs.getString("cognome"));  
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				miaConn.close();
				mioStat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
