package entities;

import java.util.Date;

public class HorasContratos {
	private Date data;
	private Double valorPorHora;
	private Integer qtdeHoras;
	
	public HorasContratos() {
	}

	public HorasContratos(Date data, double valorPorHora, int qtdeHoras) {
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.qtdeHoras = qtdeHoras;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public int getQtdeHoras() {
		return qtdeHoras;
	}

	public void setQtdeHoras(int qtdeHoras) {
		this.qtdeHoras = qtdeHoras;
	}
	
	
	public double valorTotal() {
		return valorPorHora * qtdeHoras;
	}

}
