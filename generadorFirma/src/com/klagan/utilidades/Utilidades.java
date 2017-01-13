package com.klagan.utilidades;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.core.vcard.VCard;
import net.glxn.qrgen.javase.QRCode;

public class Utilidades {

	static String empresa = "K-LAGAN Technology & Consulting";
	static String archivoRTF = System.getProperty("user.dir").concat("/Firma.rtf");

	/**
	 * M�todo que genera el QR con los datos de la firma
	 * 
	 * @param nombre
	 * @param cargo
	 * @param telefono
	 * @param email
	 * @param direccion
	 */
	public static void generarQR(String nombre, String cargo, String telefono, String email, String direccion) {

		VCard visita = new VCard().setAddress(direccion).setCompany("K-lagan").setEmail(email).setName(nombre)
				.setPhoneNumber(telefono).setTitle(cargo).setWebsite("www.k-lagan.com");
		ByteArrayOutputStream bout = QRCode.from(visita).withSize(100, 100).to(ImageType.PNG).stream();

		try {

			OutputStream out = new FileOutputStream("/tmp/qr-code.png");
			bout.writeTo(out);
			out.flush();
			out.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("resource")
	public static void generarFirmaTXT(String nombre, String cargo, String telefono, String email, String direccion) {
		FileWriter archivo_txt = null;

		try {
			archivo_txt = new FileWriter("/tmp/Firma.txt");
			PrintWriter pw = new PrintWriter(archivo_txt);
			pw.println();
			pw.println(nombre);
			pw.println();
			pw.println(cargo);
			pw.println();
			pw.println(empresa);
			pw.println();
			pw.println(telefono);
			pw.println();
			pw.println(email);
			pw.println();
			pw.println(direccion);
			pw.println("Síguenos en:");
			pw.println();
			pw.println();
			pw.println(" Please consider your environmental responsibility before printing this e-mail.");
			pw.println();
			pw.println();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != archivo_txt)
					archivo_txt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}

	public static void generarFirmaRTF(String nombre, String cargo, String telefono, String email, String direccion)
			throws IOException {

		File arch = new File(archivoRTF);
		Tika tika = new Tika();
		String filecontent = null;
		try {
			filecontent = tika.parseToString(arch);
		} catch (TikaException e) {
			e.printStackTrace();
		}
		System.out.println("Extracted Content: " + filecontent);

	}

}
