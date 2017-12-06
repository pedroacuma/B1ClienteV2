package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conexion {
   
	private Connection conn = null;
      
    public Conexion(){
      try{
        //obtenemos el driver de para DERBY
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        //obtenemos la conexión
        conn = DriverManager.getConnection("jdbc:derby:.\\Database");
        
     }catch(SQLException e){
    	 e.printStackTrace();
     }catch(ClassNotFoundException e){
    	 e.printStackTrace();
     }
      System.out.println("Carga exitosa");
 
  }
     
     
 	public Object SelectEscalar(String sel)
 	{
 		ResultSet rset;
 		Object res = null;
 		try
 		{
 			Statement stmt = conn.createStatement();
 			rset = stmt.executeQuery(sel);
 			rset.next();
 			res = rset.getObject(1);
 			rset.close();
 			stmt.close();
 		}
 		catch (SQLException ex)
 		{
 			throw new Error("Error en el SELECT: " + sel + ". " + ex.getMessage());
 		}		
 		
 		return res;
 	}
 	
 	public List<Object[]> Select(String sel)
 	{
 		ResultSet rset;
 		List<Object[]> lista = new ArrayList<Object[]>();
 		try
 		{
 			Statement stmt = conn.createStatement();
 			rset = stmt.executeQuery(sel);
 			ResultSetMetaData meta = rset.getMetaData();
 			int numCol = meta.getColumnCount();
 			while (rset.next())
 			{
 				Object[] tupla = new Object[numCol];
 				for(int i=0; i<numCol;++i)
 				{
 					tupla[i] = rset.getObject(i+1);
 				}
 				lista.add(tupla);
 			}
 			rset.close();
 			stmt.close();
 		}
 		catch (SQLException ex)
 		{
 			throw new Error("Error en el SELECT: " + sel+ ". " + ex.getMessage());
 		}		
 		
 		return lista;
 	}
 	
 	public void Insert(String ins)
 	{
 		try
 		{
 			Statement stmt = conn.createStatement();
 			stmt.execute(ins);
 			stmt.close();
 		}
 		catch (SQLException ex)
 		{
 			throw new Error("Error en el INSERT: " + ins+ ". " + ex.getMessage());
 		}
 	}

 	public void Delete(String del)
 	{
 		try
 		{
 			Statement stmt = conn.createStatement();
 			stmt.execute(del);
 			stmt.close();
 		}
 		catch (SQLException ex)
 		{
 			throw new Error("Error en el DELETE: " + del+ ". " + ex.getMessage());
 		}
 	}

 	public void Update(String up)
 	{
 		try
 		{
 			Statement stmt = conn.createStatement();
 			stmt.execute(up);
 			stmt.close();
 		}
 		catch (SQLException ex)
 		{
 			throw new Error("Error en el UPDATE: " + up+ ". " + ex.getMessage());
 		}
 	}   
}