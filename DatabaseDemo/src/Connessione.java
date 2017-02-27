import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//gli import sono tutti di java.sql

public class Connessione {
	
	
	
	public static void main(String[] args) {
		
		String dbUrl = "jdbc:mysql://localhost:3306/js2017"; //connessione all'indirizzo del db
		String username = "root";
		String password = "";

		try { //glielofaccio fare in automatico dopo aver scritto la riga sottostante
			
			Connection miaConn = DriverManager.getConnection(dbUrl, username, password);
			
			Statement mioStat = miaConn.createStatement();
			
			ResultSet rs = mioStat.executeQuery("select * from js2017.studenti");
			
			while(rs.next()){
				System.out.print(rs.getString("nome") + "\t");  //richiamo il tipo del dato 
				System.out.println(rs.getString("cognome"));  
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
