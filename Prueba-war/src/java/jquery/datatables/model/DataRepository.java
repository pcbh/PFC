package jquery.datatables.model;

import java.util.LinkedList;
import java.util.List;

public class DataRepository {
	
	/// <summary>
    /// Singleton collection of companies
    /// </summary>
    private static List<Usuario> UserList = null;

    /// <summary>
    /// Method that returns all companies used in this example
    /// </summary>
    /// <returns>List of companies</returns>
    public static List<Usuario> GetUsuarios()
    {
        if (UserList == null)
        {
            
    
            UserList = new LinkedList<Usuario>();
            UserList.add(new Usuario(new Integer(1),"1", "1", "1","1",0,"1","1",1 ));
            UserList.add(new Usuario(new Integer(2),"1", "1", "1","1",0,"1","1",1 ));
            UserList.add(new Usuario(new Integer(3),"1", "1", "1","1",0,"1","1",1 ));
            UserList.add(new Usuario(new Integer(4),"1", "1", "1","1",0,"1","1",1 ));
            
        }
        return UserList;
    }

}
