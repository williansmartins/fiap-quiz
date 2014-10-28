package com.williansmartins.util;

public final class ValidarCpf {
	private String cpf;

	public ValidarCpf() {
	}

	public boolean validarCpf(String cpf) {
		if (cpf == null) {
			return false;
		} else {

			if (cpf.equals("00000000000") || cpf.equals("11111111111")
					|| cpf.equals("22222222222") || cpf.equals("33333333333")
					|| cpf.equals("44444444444") || cpf.equals("55555555555")
					|| cpf.equals("66666666666") || cpf.equals("77777777777")
					|| cpf.equals("88888888888") || cpf.equals("99999999999")
					|| (cpf.length() != 11))
				return false;

			String cpfGerado = "";
			this.cpf = cpf;
			removerCaracteres();
			if (verificarSeTamanhoInvalido(this.cpf))
				return false;
			if (verificarSeDigIguais(this.cpf))
				return false;
			cpfGerado = this.cpf.substring(0, 9);
			cpfGerado = cpfGerado.concat(calculoComCpf(cpfGerado));
			cpfGerado = cpfGerado.concat(calculoComCpf(cpfGerado));

			if (!cpfGerado.equals(this.cpf))
				return false;
		}
		return true;
	}

	private void removerCaracteres() {
		this.cpf = this.cpf.replace("-", "");
		this.cpf = this.cpf.replace(".", "");
	}

	private boolean verificarSeTamanhoInvalido(String cpf) {
		if (cpf.length() != 11)
			return true;
		return false;
	}

	private boolean verificarSeDigIguais(String cpf) {
		// char primDig = cpf.charAt(0);
		char primDig = '0';
		char[] charCpf = cpf.toCharArray();
		for (char c : charCpf)
			if (c != primDig)
				return false;
		return true;
	}

	private String calculoComCpf(String cpf) {
		int digGerado = 0;
		int mult = cpf.length() + 1;
		char[] charCpf = cpf.toCharArray();
		for (int i = 0; i < cpf.length(); i++)
			digGerado += (charCpf[i] - 48) * mult--;
		if (digGerado % 11 < 2)
			digGerado = 0;
		else
			digGerado = 11 - digGerado % 11;
		return String.valueOf(digGerado);
	}
}
