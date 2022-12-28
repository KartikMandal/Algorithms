package com.kartik.org;

import java.io.Serializable;

public class JdbcSingleton implements Serializable{
	
	//Step 1  
    // create a JDBCSingleton class.  
   //static member holds only one instance of the JDBCSingleton class.  
           
	private static final long serialVersionUID = 1L;
	private static JdbcSingleton jdbc;  
         
   //JDBCSingleton prevents the instantiation from any other class.  
     private JdbcSingleton() {  }  
      
  //Now we are providing gloabal point of access.  
       public static JdbcSingleton getInstance() {    
    	   if (jdbc == null){  
    		      synchronized(JdbcSingleton.class){  
    		        if (jdbc == null){  
    		        	jdbc = new JdbcSingleton();//instance will be created at request time  
    		        }
    		      }
    	   		}
    		      return jdbc;
           }  

	/**
	 * Significance of Serialization in Singleton Pattern If singleton class is
	 * Serializable, you can serialize the singleton instance. Once it is
	 * serialized, you can deserialize it but it will not return the singleton
	 * object.
	 * 
	 * 
	 * To resolve this issue, you need to override the readResolve() method that
	 * enforces the singleton. It is called just after the object is
	 * deserialized. It returns the singleton object.
	 * 
	 * @return
	 */
	protected Object readResolve() {  
        return getInstance();  
    } 

}
