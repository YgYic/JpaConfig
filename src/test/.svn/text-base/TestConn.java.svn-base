package test;

import   java.sql.*;  

public   class   TestConn   {  
        void   test(){  
          Connection   conn   =   null;  
          Statement   stmt   =   null;  
          ResultSet   rset   =   null;  
          System.out.println(new   java.util.Date());  
    try   {  
        Class.forName("org.sqlite.JDBC");  
        conn   =   DriverManager.getConnection(  
          "jdbc:sqlite:/f:/test.db",   //jdbc:oracle:thin:@hex:1521:ORCL  
          "",    
          "");  
        conn.setAutoCommit(false);  
        stmt   =   conn.createStatement();  
        stmt.executeUpdate("create   table   hehe(id   number,   name   varchar(32))");  
        System.out.println("建表hehe成功!");  
        for   (int   i=0;   i<1000000;   i++)  
        {  
          stmt.executeUpdate("INSERT   INTO   hehe   VALUES("+i+",   '我爱中国"+i+"')");  
           
        }  
         
        conn.commit();  
        System.out.println("不建索引查询:");  
        System.out.println(new   java.util.Date());  
         
        rset   =   stmt.executeQuery("SELECT   id,   name   FROM   hehe   where   id   >   499999   and   name   ='我爱中国500001'");  
        if   (rset.next()){  
            System.out.println(rset.getInt("id"));  
            System.out.println(rset.getString("name"));  
        }  
        if   (rset!=null){   rset.close();   rset   =   null;   }  
         
        System.out.println(new   java.util.Date());  
 
        System.out.println("建索引:");  
        System.out.println(new   java.util.Date());  
        stmt.executeUpdate("CREATE   INDEX   hehe_idx   on   hehe(id)");  
        stmt.executeUpdate("CREATE   INDEX   hehe_idx2   on   hehe(name)");  
        conn.commit();  
        System.out.println(new   java.util.Date());  
         
        System.out.println("建索引后的查询:");  
        System.out.println(new   java.util.Date());  
        rset   =   stmt.executeQuery("SELECT   id,   name   FROM   hehe   where   id   >   499999   and   name   =   '我爱中国500001'");  
        if   (rset.next()){  
            System.out.println(rset.getInt("id"));  
            System.out.println(rset.getString("name"));  
        }  
        System.out.println(new   java.util.Date());  
        stmt.executeUpdate("drop   table   hehe");  
        System.out.println("删除表hehe成功!");  
        conn.commit();  
         
        System.out.println(new   java.util.Date());  
 
    }   catch(ClassNotFoundException   cnfe)   {  
      System.out.println("Can't   find   class   for   driver:   "+cnfe.getMessage());  
      System.exit(-1);  
    }   catch   (SQLException   e){  
            System.out.println(e.getMessage());  
            System.exit(-1);  
    }   finally    
    {  
      try   {  
              if   (rset!=null)   rset.close();  
              stmt.close();  
              conn.close();  
      }   catch   (SQLException   e)   {  
         
      }  
    }  
        }    
 
  public static void main(String[] args)   {  
    TestConn conn = new TestConn();  
    conn.test();  
  }  
}   
