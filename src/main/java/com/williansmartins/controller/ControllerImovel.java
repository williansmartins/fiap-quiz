package com.williansmartins.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.williansmartins.entity.FotoEntity;
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

	private Part fotoGrande;
	private Part fotoCarousel;
	private Part fotoQuadrante;
	
	private Part thumb1;
	private Part thumb2;
	private Part thumb3;
	private Part thumb4;
	private Part thumb5;
	private Part thumb6;
	private Part thumb7;
	private Part thumb8;
	private Part thumb9;
	private Part thumb10;
	
	private String statusMessage;
	
	private List<FotoEntity> galeriaDeThumbs; 

	public ControllerImovel(){
		entity = new ImovelEntity();
		lista = dao.findAll();
		galeriaDeThumbs = new ArrayList<FotoEntity>();
	}
	
	@PostConstruct
	public void init() {
	
	}
	
	public String uploadFile() throws IOException {

		// Extract file name from content-disposition header of file part
		String SfotoGrande = getFileName(fotoGrande);
		String SfotoCarousel = getFileName(fotoCarousel);
		String SfotoQuadrante = getFileName(fotoQuadrante);
		
		String SThumb1 = getFileName( thumb1 );
		String SThumb2 = getFileName( thumb2 );
		String SThumb3 = getFileName( thumb3 );
		String SThumb4 = getFileName( thumb4 );
		String SThumb5 = getFileName( thumb5 );
		String SThumb6 = getFileName( thumb6 );
		String SThumb7 = getFileName( thumb7 );
		String SThumb8 = getFileName( thumb8 );
		String SThumb9 = getFileName( thumb9 );
		String SThumb10 = getFileName( thumb10 );
		
		
		String basePath2 = File.separator + "Users" + File.separator + "will" + File.separator + "dev" + File.separator;
		String basePath = File.separator + "Users"+File.separator + "will"+File.separator + "dev"+File.separator + "servers"+File.separator + "apache-tomcat-7.0.55"+File.separator + "8080"+File.separator + "wtpwebapps"+File.separator + "imobiliaria-hibernate" + File.separator + "img" + File.separator + "imoveis" + File.separator;
		
		
		File outputFilePathfotoGrande = new File(basePath + SfotoGrande);
		File outputFilePathfotoCarousel = new File(basePath + SfotoCarousel);
		File outputFilePathfotoQuadrante = new File(basePath + SfotoQuadrante);
		
		File outputFilePathThumb1 = new File(basePath + SThumb1);
		File outputFilePathThumb2 = new File(basePath + SThumb2);
		File outputFilePathThumb3 = new File(basePath + SThumb3);
		File outputFilePathThumb4 = new File(basePath + SThumb4);
		File outputFilePathThumb5 = new File(basePath + SThumb5);
		File outputFilePathThumb6 = new File(basePath + SThumb6);
		File outputFilePathThumb7 = new File(basePath + SThumb7);
		File outputFilePathThumb8 = new File(basePath + SThumb8);
		File outputFilePathThumb9 = new File(basePath + SThumb9);
		File outputFilePathThumb10 = new File(basePath + SThumb10);

		// Copy uploaded file to destination path
		InputStream inputStream1 = null;
		InputStream inputStream2 = null;
		InputStream inputStream3 = null;
		
		InputStream inputStreamt1 = null;
		InputStream inputStreamt2 = null;
		InputStream inputStreamt3 = null;
		InputStream inputStreamt4 = null;
		InputStream inputStreamt5 = null;
		InputStream inputStreamt6 = null;
		InputStream inputStreamt7 = null;
		InputStream inputStreamt8 = null;
		InputStream inputStreamt9 = null;
		InputStream inputStreamt10 = null;
		
		OutputStream outputStream1 = null;
		OutputStream outputStream2 = null;
		OutputStream outputStream3 = null;

		OutputStream outputStreamt1 = null;
		OutputStream outputStreamt2 = null;
		OutputStream outputStreamt3 = null;
		OutputStream outputStreamt4 = null;
		OutputStream outputStreamt5 = null;
		OutputStream outputStreamt6 = null;
		OutputStream outputStreamt7 = null;
		OutputStream outputStreamt8 = null;
		OutputStream outputStreamt9 = null;
		OutputStream outputStreamt10 = null;
		
		try {
			inputStream1 = fotoGrande.getInputStream();
			inputStream2 = fotoCarousel.getInputStream();
			inputStream3 = fotoQuadrante.getInputStream();
			
			inputStreamt1 = thumb1.getInputStream();
			inputStreamt2 = thumb1.getInputStream();
			inputStreamt3 = thumb1.getInputStream();
			inputStreamt4 = thumb1.getInputStream();
			inputStreamt5 = thumb1.getInputStream();
			inputStreamt6 = thumb1.getInputStream();
			inputStreamt7 = thumb1.getInputStream();
			inputStreamt8 = thumb1.getInputStream();
			inputStreamt9 = thumb1.getInputStream();
			inputStreamt10 = thumb1.getInputStream();
			
			outputStream1 = new FileOutputStream(outputFilePathfotoGrande);
			outputStream2 = new FileOutputStream(outputFilePathfotoCarousel);
			outputStream3 = new FileOutputStream(outputFilePathfotoQuadrante);
			outputStreamt1 = new FileOutputStream(outputFilePathThumb1);
			outputStreamt2 = new FileOutputStream(outputFilePathThumb2);
			outputStreamt3 = new FileOutputStream(outputFilePathThumb3);
			outputStreamt4 = new FileOutputStream(outputFilePathThumb4);
			outputStreamt5 = new FileOutputStream(outputFilePathThumb5);
			outputStreamt6 = new FileOutputStream(outputFilePathThumb6);
			outputStreamt7 = new FileOutputStream(outputFilePathThumb7);
			outputStreamt8 = new FileOutputStream(outputFilePathThumb8);
			outputStreamt9 = new FileOutputStream(outputFilePathThumb9);
			outputStreamt10 = new FileOutputStream(outputFilePathThumb10);
			
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
			
			while ((read = inputStreamt1.read(bytes)) != -1) {
				outputStreamt1.write(bytes, 0, read);
			}
			
			while ((read = inputStreamt2.read(bytes)) != -1) {
				outputStreamt2.write(bytes, 0, read);
			}
			
			while ((read = inputStreamt3.read(bytes)) != -1) {
				outputStreamt3.write(bytes, 0, read);
			}
			
			while ((read = inputStreamt4.read(bytes)) != -1) {
				outputStreamt4.write(bytes, 0, read);
			}
			
			while ((read = inputStreamt5.read(bytes)) != -1) {
				outputStreamt5.write(bytes, 0, read);
			}
			
			while ((read = inputStreamt6.read(bytes)) != -1) {
				outputStreamt6.write(bytes, 0, read);
			}
			
			while ((read = inputStreamt7.read(bytes)) != -1) {
				outputStreamt7.write(bytes, 0, read);
			}
			
			while ((read = inputStreamt8.read(bytes)) != -1) {
				outputStreamt8.write(bytes, 0, read);
			}
			
			while ((read = inputStreamt9.read(bytes)) != -1) {
				outputStreamt9.write(bytes, 0, read);
			}
			
			while ((read = inputStreamt10.read(bytes)) != -1) {
				outputStreamt10.write(bytes, 0, read);
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
			
			if (outputStreamt1 != null) {
				outputStreamt1.close();
			}
			if (inputStreamt1 != null) {
				inputStreamt1.close();
			}
			if (outputStreamt2 != null) {
				outputStreamt2.close();
			}
			if (inputStreamt2 != null) {
				inputStreamt2.close();
			}
			if (outputStreamt3 != null) {
				outputStreamt3.close();
			}
			if (inputStreamt3 != null) {
				inputStreamt3.close();
			}
			if (outputStreamt4 != null) {
				outputStreamt4.close();
			}
			if (inputStreamt4 != null) {
				inputStreamt4.close();
			}
			if (outputStreamt5 != null) {
				outputStreamt5.close();
			}
			if (inputStreamt5 != null) {
				inputStreamt5.close();
			}
			if (outputStreamt6 != null) {
				outputStreamt6.close();
			}
			if (inputStreamt6 != null) {
				inputStreamt6.close();
			}
			if (outputStreamt7 != null) {
				outputStreamt7.close();
			}
			if (inputStreamt7 != null) {
				inputStreamt7.close();
			}
			if (outputStreamt8 != null) {
				outputStreamt8.close();
			}
			if (inputStreamt8 != null) {
				inputStreamt8.close();
			}
			if (outputStreamt9 != null) {
				outputStreamt9.close();
			}
			if (inputStreamt9 != null) {
				inputStreamt9.close();
			}
			if (outputStreamt10 != null) {
				outputStreamt10.close();
			}
			if (inputStreamt10 != null) {
				inputStreamt10.close();
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
			galeriaDeThumbs = new ArrayList<FotoEntity>();
			
			if( !getFileName(fotoCarousel).equals("")){
				entity.setFotoCarousel(getFileName(fotoCarousel));
			} 
			
			if( !getFileName(fotoGrande).equals("")){
				entity.setFotoGrande(getFileName(fotoGrande));
			} 
			
			if( !getFileName(fotoQuadrante).equals("")){
				entity.setFotoQuadrante(getFileName(fotoQuadrante));
			} 
			
			if( !getFileName(thumb1).equals("")){
				galeriaDeThumbs.add( new FotoEntity( getFileName(thumb1), getFileName(thumb1)) );
				
			} 
			
			if( !getFileName(thumb2).equals("")){
				galeriaDeThumbs.add( new FotoEntity( getFileName(thumb2), getFileName(thumb2)) );
				
			} 
			
			if( !getFileName(thumb3).equals("")){
				galeriaDeThumbs.add( new FotoEntity( getFileName(thumb3), getFileName(thumb3)) );
				
			} 
			
			if( !getFileName(thumb4).equals("")){
				galeriaDeThumbs.add( new FotoEntity( getFileName(thumb4), getFileName(thumb4)) );
				
			} 
			
			if( !getFileName(thumb5).equals("")){
				galeriaDeThumbs.add( new FotoEntity( getFileName(thumb5), getFileName(thumb5)) );
				
			} 
			
			if( !getFileName(thumb6).equals("")){
				galeriaDeThumbs.add( new FotoEntity( getFileName(thumb6), getFileName(thumb6)) );
				
			} 
			
			if( !getFileName(thumb7).equals("")){
				galeriaDeThumbs.add( new FotoEntity( getFileName(thumb7), getFileName(thumb7)) );
				
			} 
			
			if( !getFileName(thumb8).equals("")){
				galeriaDeThumbs.add( new FotoEntity( getFileName(thumb8), getFileName(thumb8)) );
				
			} 
			
			if( !getFileName(thumb9).equals("")){
				galeriaDeThumbs.add( new FotoEntity( getFileName(thumb9), getFileName(thumb9)) );
				
			} 
			
			if( !getFileName(thumb10).equals("")){
				galeriaDeThumbs.add( new FotoEntity( getFileName(thumb10), getFileName(thumb10)) );
			} 
			entity.setFotos( galeriaDeThumbs );
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

	


	public List<FotoEntity> getGaleriaDeThumbs() {
		return galeriaDeThumbs;
	}

	public void setGaleriaDeThumbs(List<FotoEntity> galeriaDeThumbs) {
		this.galeriaDeThumbs = galeriaDeThumbs;
	}

	public Part getThumb1() {
		return thumb1;
	}

	public void setThumb1(Part thumb1) {
		this.thumb1 = thumb1;
	}

	public Part getThumb2() {
		return thumb2;
	}

	public void setThumb2(Part thumb2) {
		this.thumb2 = thumb2;
	}

	public Part getThumb3() {
		return thumb3;
	}

	public void setThumb3(Part thumb3) {
		this.thumb3 = thumb3;
	}

	public Part getThumb4() {
		return thumb4;
	}

	public void setThumb4(Part thumb4) {
		this.thumb4 = thumb4;
	}

	public Part getThumb5() {
		return thumb5;
	}

	public void setThumb5(Part thumb5) {
		this.thumb5 = thumb5;
	}

	public Part getThumb6() {
		return thumb6;
	}

	public void setThumb6(Part thumb6) {
		this.thumb6 = thumb6;
	}

	public Part getThumb7() {
		return thumb7;
	}

	public void setThumb7(Part thumb7) {
		this.thumb7 = thumb7;
	}

	public Part getThumb8() {
		return thumb8;
	}

	public void setThumb8(Part thumb8) {
		this.thumb8 = thumb8;
	}

	public Part getThumb9() {
		return thumb9;
	}

	public void setThumb9(Part thumb9) {
		this.thumb9 = thumb9;
	}

	public Part getThumb10() {
		return thumb10;
	}

	public void setThumb10(Part thumb10) {
		this.thumb10 = thumb10;
	}
	
	
}
