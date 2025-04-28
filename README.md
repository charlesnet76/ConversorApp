💵 Conversor de Moneda - Java App
Aplicación Java para convertir entre diferentes monedas usando ExchangeRate-API.

🚀 Proyecto educativo - Rápido, sencillo y funcional.

📋 Funcionalidades
🔄 Convertir entre:

USD ↔ ARS

USD ↔ BRL

USD ↔ COP

🌐 Conexión en tiempo real con API de tasas de cambio.

🛡️ Validación de opciones y errores controlados.

🔥 Menú interactivo sencillo y claro.

📊 Vista previa
plaintext
Copy
Edit
********************************************************************
Bienvenido al conversor de moneda

1. USD → Peso Argentino
2. Peso Argentino → USD
3. USD → Real Brasilero
4. Real Brasilero → USD
5. USD → Peso Colombiano
6. Peso Colombiano → USD
7. Salir
********************************************************************
Elija una opción válida:
🎯 Badges del proyecto

🖼️ Diagrama de Flujo (Lógico)
mermaid
Copy
Edit
flowchart TD
    A[Inicio] --> B[Mostrar Menú]
    B --> C{Usuario elige opción}
    C -- Opción 1-6 --> D[Consultar API y mostrar resultado]
    D --> E{¿Otra conversión?}
    E -- Sí --> B
    E -- No --> F[Finalizar aplicación]
    C -- Opción inválida --> B
    C -- Salir --> F
🛠️ Tecnologías Usadas

Tecnología	Descripción
Java 21	Lenguaje de programación principal
Gson	Librería para procesar JSON
ExchangeRate-API	Servicio de conversión de monedas
IntelliJ IDEA	Entorno de desarrollo
🚀 Instalación Rápida
Clonar el repositorio:

bash
Copy
Edit
git clone https://github.com/tuusuario/conversor-moneda-java.git
cd conversor-moneda-java
Abrir en IntelliJ IDEA.

Descargar e incluir Gson.jar en una carpeta lib/.

Ejecutar ConversorMenuFijo.java.

🔑 Configurar API Key
Antes de ejecutar, reemplaza en el código:

java
Copy
Edit
private static final String API_KEY = "TU_API_KEY_AQUI";
Puedes obtener tu API gratuita en 👉 ExchangeRate-API.

📷 (Opcional) Captura de pantalla real
Puedes agregar luego una imagen de cómo se ve la app en la terminal.

markdown
Copy
Edit
![Captura de ConversorApp](ruta/a/tu/imagen.png)
📄 Licencia
Este proyecto se distribuye bajo licencia MIT.
Eres libre de copiarlo, modificarlo y usarlo. 🙌

