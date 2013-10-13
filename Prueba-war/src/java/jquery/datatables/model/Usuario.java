package jquery.datatables.model;

import EJBs.Usuarios;
import javax.ejb.EJB;

public class Usuario {
	
	static int nextID = 17;
        
        @EJB
        private Usuarios ejbRef;

    public Usuario(Integer idUsuario, String alias, String nombre, String password, String mail, int reputacion, String ciudad, String cp, int anyoNacimiento) {
        
        ejbRef = new Usuarios(idUsuario,alias,nombre,password,mail,reputacion,ciudad,cp,anyoNacimiento);
        
    }

    public Integer getIdUsuario() {
        return ejbRef.getIdUsuario();
    }

    public void setIdUsuario(Integer idUsuario) {
        ejbRef.setIdUsuario(idUsuario);
    }

    public String getAlias() {
        return ejbRef.getAlias();
    }

    public void setAlias(String alias) {
        ejbRef.setAlias(alias);
    }

    public String getNombre() {
        return ejbRef.getNombre();
    }

    public void setNombre(String nombre) {
        ejbRef.setNombre(nombre);
    }

    public String getPassword() {
        return ejbRef.getPassword();
    }

    public void setPassword(String password) {
        ejbRef.setPassword(password);
    }

    public String getMail() {
        return ejbRef.getMail();
    }

    public void setMail(String mail) {
        ejbRef.setMail(mail);
    }

    public int getReputacion() {
        return ejbRef.getReputacion();
    }

    public void setReputacion(int reputacion) {
        ejbRef.setReputacion(reputacion);
    }

    public String getCiudad() {
        return ejbRef.getCiudad();
    }

    public void setCiudad(String ciudad) {
        ejbRef.setCiudad(ciudad);
    }

    public String getCalle() {
        return ejbRef.getCalle();
    }

    public void setCalle(String calle) {
        ejbRef.setCalle(calle);
    }

    public String getCp() {
        return ejbRef.getCp();
    }

    public void setCp(String cp) {
        ejbRef.setCp(cp);
    }

    public int getAnyoNacimiento() {
        return ejbRef.getAnyoNacimiento();
    }

    public void setAnyoNacimiento(int anyoNacimiento) {
        ejbRef.setAnyoNacimiento(anyoNacimiento);
    }
}
