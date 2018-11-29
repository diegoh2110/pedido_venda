package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.OrderStatus;

public class Trabalhador {
	private String nome;
	private OrderStatus nivel;
	private Double salarioBase;

	private Departamento departamento;
	private List<HorasContratos> contratos = new ArrayList<>();

	public Trabalhador() {
	}

	public Trabalhador(String nome, OrderStatus nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public OrderStatus getNivel() {
		return nivel;
	}

	public void setNivel(OrderStatus nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HorasContratos> getContratos() {
		return contratos;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public void addContrato(HorasContratos contrato) {
		contratos.add(contrato);
	}

	public void removeContrato(HorasContratos contrato) {
		contratos.remove(contrato);
	}

	public double renda(Integer ano, Integer mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (HorasContratos c: contratos) {
			cal.setTime(c.getData());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (ano == c_year && mes == c_month) {
				soma +=c.valorTotal();
			}
		}
		return soma;
	}
}
