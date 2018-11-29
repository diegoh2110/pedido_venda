package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departamento;
import entities.HorasContratos;
import entities.Trabalhador;
import entities.enums.OrderStatus;

public class program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Entre com o nome do Departamento: ");
		String departamento = sc.nextLine();
		System.out.println("Digite os dados do Trabalhador: ");
		System.out.print("Nome: ");
		String nome = sc.next();
		System.out.print("Nivel: ");
		String level = sc.next();
		System.out.print("Salario Base: ");
		double salarioBase = sc.nextDouble();

		Trabalhador trabalhador = new Trabalhador(nome, OrderStatus.valueOf(level), salarioBase,
				new Departamento(departamento));

		System.out.print("Quantos contratos esse colaborador tem: ");
		int numeroContratos = sc.nextInt();

		for (int i = 1; i <= numeroContratos; i++) {
			System.out.println("Entre com os dados do contrato #" + i);
			System.out.print("Date (DD/MM/YYYY): ");
			Date dataContrato = dateFormat.parse(sc.next());
			System.out.println("Valor por Hora: ");
			double valorHora = sc.nextDouble();
			System.out.println("Duracao do contrato (Horas): ");
			int horas = sc.nextInt();
			HorasContratos horasContratos = new HorasContratos(dataContrato, valorHora, horas);
			trabalhador.addContrato(horasContratos);
		}

		System.out.println("");
		System.out.print("Digite um Mes e um Ano para calcular a renda (MM/YYYY): ");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());

		System.out.println("Renda: " + mesAno + ": " + String.format("%.2f", trabalhador.renda(ano, mes)));

		sc.close();
	}

}
