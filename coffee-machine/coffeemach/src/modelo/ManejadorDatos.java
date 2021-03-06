package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import componentes.DepositoMonedas;

public class ManejadorDatos implements Serializable {

	private int codigoMaquina;
	private HashMap<Ingrediente, Double> listaIngredientes;
	private DepositoMonedas deposito100, deposito200, deposito500;
	private ArrayList<Receta> listaRecetas;
	private ArrayList<Venta> listaVentas;

	public void setCodigoMaquina(int codigoMaquina) {
		this.codigoMaquina = codigoMaquina;
	}

	public void setListaIngredientes(
			HashMap<Ingrediente, Double> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}

	public void setDeposito100(DepositoMonedas deposito100) {
		this.deposito100 = deposito100;
	}

	public void setDeposito200(DepositoMonedas deposito200) {
		this.deposito200 = deposito200;
	}

	public void setDeposito500(DepositoMonedas deposito500) {
		this.deposito500 = deposito500;
	}

	public void setListaRecetas(ArrayList<Receta> listaRecetas) {
		this.listaRecetas = listaRecetas;
	}

	public void setListaVentas(ArrayList<Venta> listaVentas) {
		this.listaVentas = listaVentas;
	}

	private static final long serialVersionUID = 1;

	public ManejadorDatos() {
		// leo el archivo
		listaIngredientes = new HashMap<Ingrediente, Double>();
		deposito100 = new DepositoMonedas("", 0, 0, 0, 0);
		deposito200 = new DepositoMonedas("", 0, 0, 0, 0);
		deposito500 = new DepositoMonedas("", 0, 0, 0, 0);
		listaRecetas = new ArrayList<Receta>();
		listaVentas = new ArrayList<Venta>();
		codigoMaquina = 0;
	}

	public void reabastecerIngredientes(
			HashMap<Ingrediente, Double> listaIngredientes) {

		this.listaIngredientes = listaIngredientes;

	}

	public void reabastecerMonedas(DepositoMonedas depo) {

		if (depo.getTipo().equalsIgnoreCase("100")) {
			deposito100 = depo;
		}
		if (depo.getTipo().equalsIgnoreCase("200")) {
			deposito200 = depo;
		}
		if (depo.getTipo().equalsIgnoreCase("500")) {
			deposito500 = depo;
		}

	}

	public void agregarReceta(Receta rec) {

		listaRecetas.add(rec);

	}

	public void modificarIngredienteReceta(Receta r) {

		for (Receta rec : listaRecetas) {

			if (rec.getDescripcion().equalsIgnoreCase(r.getDescripcion())) {
				rec.setListaIngredientes(r.getListaIngredientes());
				break;
			}
		}

	}

	public void cargarDatos() throws IOException, ClassNotFoundException {
		// aqui desSeralizo

		FileInputStream fis;
		// try {

		File f = new File("bd.cafe");
		if (!f.exists()) {
			f.createNewFile();
			System.out.println("creando nuevo");
		}

		fis = new FileInputStream(f);
		ObjectInputStream oos = new ObjectInputStream(fis);

		ManejadorDatos md = (ManejadorDatos) oos.readObject();

		this.deposito100 = md.deposito100;
		this.deposito200 = md.deposito200;
		this.deposito500 = md.deposito500;
		this.listaIngredientes = md.listaIngredientes;
		this.listaRecetas = md.listaRecetas;
		this.listaVentas = md.listaVentas;
		this.codigoMaquina = md.codigoMaquina;

		/*
		 * } catch (FileNotFoundException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } catch (ClassNotFoundException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); } catch
		 * (Exception e) { guardarDatos(); }
		 */

	}

	public void guardarDatos() {
		// aqui seralizo
		try {
			FileOutputStream fos = new FileOutputStream("bd.cafe");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(this);

		} catch (FileNotFoundException ffe) {

		} catch (Exception e) {

		}
	}

	public int getCodigoMaquina() {
		return codigoMaquina;
	}

	public HashMap<Ingrediente, Double> getListaIngredientes() {
		return listaIngredientes;
	}

	public DepositoMonedas getDeposito100() {
		return deposito100;
	}

	public DepositoMonedas getDeposito200() {
		return deposito200;
	}

	public DepositoMonedas getDeposito500() {
		return deposito500;
	}

	public ArrayList<Receta> getListaRecetas() {
		return listaRecetas;
	}

	public ArrayList<Venta> getListaVentas() {
		return listaVentas;
	}
}
