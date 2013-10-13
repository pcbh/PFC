package jquery.datatables.controller;

import java.io.IOException;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import jquery.datatables.model.Usuario;
import jquery.datatables.model.DataRepository;
import jquery.datatables.model.JQueryDataTableParamModel;

/**
 * CompanyServlet provides data to the JQuery DataTables
 */
public class CompanyGsonObjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CompanyGsonObjectsServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JQueryDataTableParamModel param = DataTablesParamUtility.getParam(request);
		
		String sEcho = param.sEcho;
		int iTotalRecords; // total number of records (unfiltered)
		int iTotalDisplayRecords; //value will be set when code filters companies by keyword

		iTotalRecords = DataRepository.GetUsuarios().size();
		List<Usuario> usuarios = new LinkedList<Usuario>();
		for(Usuario u : DataRepository.GetUsuarios()){
			if(	u.getIdUsuario().equals(param.sSearch)
				||
				u.getAlias().toLowerCase().contains(param.sSearch.toLowerCase())
				||
				u.getNombre().toLowerCase().contains(param.sSearch.toLowerCase()))
			{
				usuarios.add(u); // add company that matches given search criterion
			}
		}
		iTotalDisplayRecords = usuarios.size();// number of companies that match search criterion should be returned
		
		final int sortColumnIndex = param.iSortColumnIndex;
		final int sortDirection = param.sSortDirection.equals("asc") ? -1 : 1;
		
		Collections.sort(usuarios, new Comparator<Usuario>(){
			@Override
			public int compare(Usuario u1, Usuario u2) {	
				switch(sortColumnIndex){
				case 0:
					return u1.getIdUsuario().compareTo(u2.getIdUsuario()) * sortDirection;
				case 1:
					return u1.getAlias().compareTo(u2.getAlias()) * sortDirection;
				case 2:
					return u1.getNombre().compareTo(u2.getNombre()) * sortDirection;
				}
				return 0;
			}
		});
		
		if(usuarios.size()< param.iDisplayStart + param.iDisplayLength) {
			usuarios = usuarios.subList(param.iDisplayStart, usuarios.size());
		} else {
			usuarios = usuarios.subList(param.iDisplayStart, param.iDisplayStart + param.iDisplayLength);
		}
	
		try {	
			JsonObject jsonResponse = new JsonObject();		
			jsonResponse.addProperty("sEcho", sEcho);
			jsonResponse.addProperty("iTotalRecords", iTotalRecords);
			jsonResponse.addProperty("iTotalDisplayRecords", iTotalDisplayRecords);			
			Gson gson = new Gson();
			jsonResponse.add("aaData", gson.toJsonTree(usuarios));
			
			response.setContentType("application/Json");
			response.getWriter().print(jsonResponse.toString());
			
		} catch (JsonIOException e) {
			e.printStackTrace();
			response.setContentType("text/html");
			response.getWriter().print(e.getMessage());
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}