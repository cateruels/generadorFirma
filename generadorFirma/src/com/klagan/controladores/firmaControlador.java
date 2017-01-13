package com.klagan.controladores;

import java.io.IOException;

import com.klagan.utilidades.Utilidades;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
		generarFirma(txtNombre.getText(), txtCargo.getText(), txtTelefono.getText(), txtEmail.getText(),
				txtDireccion.getText());
	}

	/**
	 * M�todo que prepara los datos y genera la firma para Outlook
	 * 
	 * @param nombre
	 * @param cargo
	 * @param telefono
	 * @param email
	 * @param direccion
	 */
	private void generarFirma(String nombre, String cargo, String telefono, String email, String direccion) {
		Utilidades.generarQR(nombre, cargo, telefono, email, direccion);
		Utilidades.generarFirmaTXT(nombre, cargo, telefono, email, direccion);
		try {
			Utilidades.generarFirmaRTF(nombre, cargo, telefono, email, direccion);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prepararArchivosFirma();

	}

	/**
	 * Método que copia los archivos necesarios para la firma
	 */
	private void prepararArchivosFirma() {
		// TODO Auto-generated method stub

	}

}