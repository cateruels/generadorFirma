package com.klagan.controladores;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.core.vcard.VCard;
import net.glxn.qrgen.javase.QRCode;

public class firmaControlador {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCargo;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtDireccion;

    @FXML
    private Button btnGenerar;
    
    @FXML
    void handleButtonAction(ActionEvent event) {
    	generarFirma(txtNombre.getText(), txtCargo.getText(), txtTelefono.getText(), txtEmail.getText(), txtDireccion.getText());
    }

    /**
     * M�todo que prepara los datos y genera la firma para Outlook
     * @param nombre
     * @param cargo
     * @param telefono
     * @param email
     * @param direccion
     */
	private void generarFirma(String nombre, String cargo, String telefono, String email, String direccion) {
		generarQR(nombre,cargo,telefono,email,direccion);
		prepararArchivosFirma();
		
	}

	/**
	 * Método que copia los archivos necesarios para la firma
	 */
	private void prepararArchivosFirma() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * M�todo que genera el QR con los datos de la firma
	 * @param nombre
	 * @param cargo
	 * @param telefono
	 * @param email
	 * @param direccion
	 */
	private void generarQR(String nombre, String cargo, String telefono, String email, String direccion) {
		VCard visita = new VCard().setAddress(direccion).setCompany("K-lagan").setEmail(email)
            	.setName(nombre).setPhoneNumber(telefono).setTitle(cargo).setWebsite("www.k-lagan.com");
        ByteArrayOutputStream bout =
            QRCode.from(visita).withSize(25, 25).to(ImageType.PNG).stream();

        try {
        	
            OutputStream out = new FileOutputStream("/tmp/qr-code.png");
            bout.writeTo(out);
            out.flush();
            out.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

}