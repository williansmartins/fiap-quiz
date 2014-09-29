package com.williansmartins.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.entity.ImovelDaoImpl;
import com.williansmartins.entity.ImovelEntity;
import com.williansmartins.enums.Tipo;

@ManagedBean(name="imovelBean")
@SessionScoped
public class ControllerImovel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ImovelEntity entity;
	private JpaGenericDao<ImovelEntity> dao = new ImovelDaoImpl();
	private List<ImovelEntity> novidades;
	private List<ImovelEntity> lista;
	private int idDoImovel;
	private BigDecimal min;
	private BigDecimal max;
	private String busca;
	
	private Tipo tipo; 
	private List<Tipo> tipos;

	Part fotoGrande;
	Part fotoCarousel;
	Part fotoQuadrante;
	private String statusMessage;

	public ControllerImovel(){
		entity = new ImovelEntity();
		lista = dao.findAll();
	}
	
	@PostConstruct
	public void init() {
	
	}
	
	public String uploadFile() throws IOException {

		// Extract file name from content-disposition header of file part
		String SfotoGrande = getFileName(fotoGrande);
		String SfotoCarousel = getFileName(fotoCarousel);
		String SfotoQuadrante = getFileName(fotoQuadrante);
		
		String basePath2 = File.separator + "Users" + File.separator + "will" + File.separator + "dev" + File.separator;
		String basePath = File.separator + "Users"+File.separator + "will"+File.separator + "dev"+File.separator + "servers"+File.separator + "apache-tomcat-7.0.55"+File.separator + "8080"+File.separator + "wtpwebapps"+File.separator + "imobiliaria-hibernate" + File.separator + "img" + File.separator + "imoveis" + File.separator;
		
		
		File outputFilePathfotoGrande = new File(basePath + SfotoGrande);
		File outputFilePathfotoCarousel = new File(basePath + SfotoCarousel);
		File outputFilePathfotoQuadrante = new File(basePath + SfotoQuadrante);

		// Copy uploaded file to destination path
		InputStream inputStream1 = null;
		InputStream inputStream2 = null;
		InputStream inputStream3 = null;
		
		OutputStream outputStream1 = null;
		OutputStream outputStream2 = null;
		OutputStream outputStream3 = null;
		
		try {
			inputStream1 = fotoGrande.getInputStream();
			inputStream2 = fotoCarousel.getInputStream();
			inputStream3 = fotoQuadrante.getInputStream();
			
			outputStream1 = new FileOutputStream(outputFilePathfotoGrande);System.out.println(outputFilePathfotoGrande);
			outputStream2 = new FileOutputStream(outputFilePathfotoCarousel);System.out.println(outputFilePathfotoCarousel);
			outputStream3 = new FileOutputStream(outputFilePathfotoQuadrante);System.out.println(outputFilePathfotoQuadrante);
			
			int read = 0;
			final byte[] bytes = new byte[1024];
			while ((read = inputStream1.read(bytes)) != -1) {
				outputStream1.write(bytes, 0, read);
			}
			while ((read = inputStream2.read(bytes)) != -1) {
				outputStream2.write(bytes, 0, read);
			}
			while ((read = inputStream3.read(bytes)) != -1) {
				outputStream3.write(bytes, 0, read);
			}

			statusMessage = "File upload successfull !!";
		} catch (IOException e) {
			e.printStackTrace();
			statusMessage = "File upload failed !!";
		} finally {
			if (outputStream1 != null) {
				outputStream1.close();
			}
			if (inputStream1 != null) {
				inputStream1.close();
			}
			if (outputStream2 != null) {
				outputStream2.close();
			}
			if (inputStream2 != null) {
				inputStream2.close();
			}
			if (outputStream3 != null) {
				outputStream3.close();
			}
			if (inputStream3 != null) {
				inputStream3.close();
			}
		}
		return null;    // return to same page
	}

	// Extract file name from content-disposition header of file part
	private String getFileName(Part part) {
		final String partHeader = part.getHeader("content-disposition");
		System.out.println("***** partHeader: " + partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}
	
	public String buscar(){
		lista = dao.find( busca );
		return "resultado2.xhtml?faces-redirect=true&includeViewParams=true";
	}
	
	public void buscarImovel(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		idDoImovel = Integer.parseInt( request.getParameter("imovel_id") );
		entity = dao.findById(idDoImovel);
		System.out.println(">>>" + entity.getTitulo());
	}
	
	public String editar(String id){
		entity = dao.findById(Integer.parseInt(id));
		return "admin-imovel.xhtml";
	}
	
	public void buscarImoveis(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		if( request.getParameter("min") != null && !request.getParameter("min").equalsIgnoreCase("")){
			min = new BigDecimal(request.getParameter("min"));
		}
		if( request.getParameter("max") != null && !request.getParameter("max").equalsIgnoreCase("")){
			max = new BigDecimal(request.getParameter("max"));
		}
		if( request.getParameter("tipo") != null){
			if( request.getParameter("tipo").equalsIgnoreCase("casa") ){
				tipo = Tipo.CASA;
			}
			if( request.getParameter("tipo").equalsIgnoreCase("apartamento") ){
				tipo = Tipo.APARTAMENTO;
			}
			if( request.getParameter("tipo").equalsIgnoreCase("qualquer") || request.getParameter("tipo").equalsIgnoreCase("") ){
				tipo = Tipo.QUALQUER;
			}
			
		}
		
		String cidade = request.getParameter("cidade");
		
		lista = dao.find(tipo, cidade,  min ,  max );
	}
	
	public String salvar(){
		try {
			uploadFile();
			
			if( !getFileName(fotoCarousel).equals("")){
				entity.setFotoCarousel(getFileName(fotoCarousel));
			} 
			
			if( !getFileName(fotoGrande).equals("")){
				entity.setFotoGrande(getFileName(fotoGrande));
			} 
			
			if( !getFileName(fotoQuadrante).equals("")){
				entity.setFotoQuadrante(getFileName(fotoQuadrante));
			} 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(entity.getId() == null){
			dao.insert(entity);
		}else{
			dao.update(entity);
		}
		entity = new ImovelEntity();
		lista = dao.findAll();
		return "admin-imoveis.xhtml?faces-redirect=true";
	}
	
	public String excluir(String id){
		dao.delete(Integer.parseInt(id));
		lista = dao.findAll();
		return "admin-imoveis.xhtml?faces-redirect=true";
	}	

	public String prepararNovo(){
		entity = new ImovelEntity();
		return "admin-imovel.xhtml";
	} 
	
	////// GETTERS AND SETTERS ///////////////
	/////////////////////////////////////////
	
	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<Tipo> getTipos() {
		return Arrays.asList(Tipo.values());
	}

	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}
	
	public List<ImovelEntity> getPedidoList() {
		return dao.findAll();
	}

	public ImovelEntity getEntity() {
		return entity;
	}

	public void setEntity(ImovelEntity entity) {
		this.entity = entity;
	}

	public List<ImovelEntity> getNovidades() {
		return dao.findAll();
	}

	public void setNovidades(List<ImovelEntity> novidades) {
		this.novidades = novidades;
	}

	public List<ImovelEntity> getLista() {
		return lista;
	}

	public void setLista(List<ImovelEntity> lista) {
		this.lista = lista;
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public Part getFotoCarousel() {
		return fotoCarousel;
	}

	public void setFotoCarousel(Part fotoCarousel) {
		this.fotoCarousel = fotoCarousel;
	}

	public Part getFotoGrande() {
		return fotoGrande;
	}

	public void setFotoGrande(Part fotoGrande) {
		this.fotoGrande = fotoGrande;
	}

	public Part getFotoQuadrante() {
		return fotoQuadrante;
	}

	public void setFotoQuadrante(Part fotoQuadrante) {
		this.fotoQuadrante = fotoQuadrante;
	}
	
	
}
