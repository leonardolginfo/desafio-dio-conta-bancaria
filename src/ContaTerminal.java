import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {

	/**
	 * @param args
	 * 
	 */
	//Sistema simples para entrega de desafio
	
	public static void main(String[] args) {

		String nomeCliente;
		int numeroConta = 0;
		String numeroContaEntrada;
		String numeroAgencia;
		String saldoInput;
		BigDecimal saldo = null;

		Scanner entrada = new Scanner(System.in);
		System.out.println("Qual seu nome?");
		nomeCliente = entrada.nextLine();

		System.out.println("Por favor, digite o número da agência.");
		numeroAgencia = entrada.next();

		System.out.println("Por favor, digite o nº da conta, somente números");
		numeroContaEntrada = entrada.next();
		try {

			tratarNumeroConta(numeroContaEntrada);
			entrada.nextLine();

			System.out.println("Digite o valor inicial de depósito?");
			saldoInput = entrada.nextLine();

			DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
			symbols.setDecimalSeparator(',');
			DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);

			try {
				saldo = new BigDecimal(decimalFormat.parse(saldoInput).toString());
			} catch (Exception e) {
				System.out.println("Erro na entrada do valor do saldo");
				e.printStackTrace();
			}

			System.out.println("Olá " + nomeCliente + ", obrigado por criar sua conta em nosso banco, sua agencia é "
					+ numeroAgencia + ", conta " + numeroConta + " e seu saldo R$" + saldo
					+ " está disponível para saque ");

		} catch (Exception e) {
			System.out.println("Você não digitou um número, encerrando processo.");

		}

		entrada.close();
	}

	private static int tratarNumeroConta(String numeroContaTemp) {
		int numeroConta = Integer.parseInt(numeroContaTemp.replace("-", ""));
		return numeroConta;
	}


}
