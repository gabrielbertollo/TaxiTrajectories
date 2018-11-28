package util;

public class Cronometro {
	
	//Variaveis cronometro
	private static long inicioTeste;
	private static long finalTeste;
	private static long resultadoTeste;

	public static void start() {
		inicioTeste = System.currentTimeMillis();
		finalTeste = 0;
		resultadoTeste = 0;
	}

	public static void stop() {
		finalTeste = System.currentTimeMillis();
		resultadoTeste = finalTeste - inicioTeste;
	}

	public static long tempoMilissegundos() {
		return resultadoTeste;
	}

}
