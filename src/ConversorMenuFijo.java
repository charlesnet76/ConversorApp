// Importación de bibliotecas necesarias
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

    public class ConversorMenuFijo {
        private static final String API_KEY = "95a93a5e504ab138ec9a5ba7"; // <-- reemplazar por la clave generada
        private static final String API_BASE = "https://v6.exchangerate-api.com/v6/" + API_KEY;
        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            boolean continuar = true;

            while (continuar) {
                mostrarMenu();
                System.out.print("Elija una opción válida: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1 -> ejecutarConversion("USD", "ARS");
                    case 2 -> ejecutarConversion("ARS", "USD");
                    case 3 -> ejecutarConversion("USD", "BRL");
                    case 4 -> ejecutarConversion("BRL", "USD");
                    case 5 -> ejecutarConversion("USD", "COP");
                    case 6 -> ejecutarConversion("COP", "USD");
                    case 7 -> {
                        System.out.println("👋 Gracias por usar el conversor. ¡Hasta pronto!");
                        return;
                    }
                    default -> System.out.println("❌ Opción inválida. Intente nuevamente.");
                }

                continuar = preguntarSiContinuar();
            }
        }

        private static void mostrarMenu() {
            System.out.println("********************************************************************");
            System.out.println("Bienvenido al conversor de monedas\n");
            System.out.println("1. USD → Peso Argentino");
            System.out.println("2. Peso Argentino → USD");
            System.out.println("3. USD → Real Brasilero");
            System.out.println("4. Real Brasilero → USD");
            System.out.println("5. USD → Peso Colombiano");
            System.out.println("6. Peso Colombiano → USD");
            System.out.println("7. Salir");
            System.out.println("\n********************************************************************");
        }

        private static void ejecutarConversion(String base, String destino) {
            System.out.printf("Ingrese el valor que desea convertir (%s → %s): ", base, destino);
            double cantidad = scanner.nextDouble();
            scanner.nextLine(); // limpiar buffer

            try {
                String urlStr = String.format(API_BASE + "/pair/%s/%s/%.2f", base, destino, cantidad);
                HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
                conn.setRequestMethod("GET");

                InputStreamReader reader = new InputStreamReader(conn.getInputStream());
                JsonObject json = new Gson().fromJson(reader, JsonObject.class);

                if (json.get("result").getAsString().equals("success")) {
                    double convertido = json.get("conversion_result").getAsDouble();
                    double tasaCambio = json.get("conversion_rate").getAsDouble(); // Tasa de cambio

                    System.out.printf("✅ %.2f %s = %.2f %s%n", cantidad, base, convertido, destino);
                    System.out.printf("💱 Tasa de cambio: 1 %s = %.4f %s%n", base, tasaCambio, destino);
                } else {
                    System.out.println("❌ Error en la conversión.");
                }

                conn.disconnect();
            } catch (Exception e) {
                System.out.println("❌ Error al conectar con la API: " + e.getMessage());
            }
        }
        /**
         * Método que pregunta al usuario si desea realizar otra conversión
         */
        private static boolean preguntarSiContinuar() {
            System.out.print("\n¿Desea realizar otra conversión? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            return respuesta.equals("s");
        }
    }


