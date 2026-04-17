💸 ALKEWALLET 6

Aplicación móvil Android desarrollada como continuación del proyecto del Módulo 5, incorporando mejoras del Módulo 6 relacionadas con consumo de API, organización del código y experiencia de usuario.

📱 Descripción

ALKEWALLET 6 es una aplicación de billetera virtual que permite a los usuarios iniciar sesión, visualizar su saldo, realizar depósitos y retiros, y consultar un historial de transacciones.

En esta versión se integró el consumo de una API REST utilizando Retrofit, permitiendo trabajar con datos dinámicos y simulando un entorno real de aplicación financiera.

🧩 Continuidad del Proyecto

Este proyecto corresponde a la evolución del sistema desarrollado en el Módulo 5.

La aplicación base ya contaba con funcionalidades operativas, por lo que en esta etapa se decidió mantener la estructura existente y aplicar mejoras progresivas sin comprometer la estabilidad del sistema.

Mejoras implementadas:

🌐 Integración de API REST (Retrofit + MockAPI)
🧠 Separación de lógica mediante ViewModel (MVVM)
🎨 Mejora visual de la interfaz
⚠️ Validación de datos ingresados

🚀 Funcionalidades

🔐 Inicio de sesión (login)
💰 Visualización de saldo
➕ Depósitos de dinero
➖ Retiros de dinero
📄 Historial de transacciones
🌐 Consumo de API REST
⚠️ Validación de operaciones

🛠️ Tecnologías y herramientas utilizadas

-  Lenguaje: Kotlin
-  IDE: Android Studio
-  Arquitectura: MVVM (ViewModel)
-  Consumo de API: Retrofit
-  Backend simulado: MockAPI
-  Diseño UI: XML
  -   epuración: Logcat

🌐 API utilizada

La aplicación consume datos desde un endpoint de MockAPI:

https://69dc1297560857310a0838b1.mockapi.io/transactions

Datos manejados:
-  Fecha (date)
-  Monto (amount)
-  Descripción (description)
-  Remitente (from)
-  Destinatario (to)

📂 Estructura del proyecto

-  ui.login → Pantalla de inicio de sesión
-  ui.wallet → Pantalla principal
-  viewmodel → Lógica de negocio
-  data.api → Cliente Retrofit
-  model → Modelo de datos

💾 Persistencia de datos (Room)

La implementación de Room fue considerada dentro del desarrollo del proyecto.

Sin embargo, no se integró en esta versión debido a problemas de compatibilidad con Gradle durante la configuración del entorno.

Adicionalmente, al trabajar con datos obtenidos desde una API REST en tiempo real, la persistencia local no era estrictamente necesaria para cumplir los objetivos del módulo.

Por esta razón, se priorizó una aplicación completamente funcional y estable.

📸 Capturas de pantalla

![Login](screenshots/login_modulo6.jpg)
![Wallet](screenshots/wallet_modulo6.jpg)
![Historial1](screenshots/historial1_modulo6.jpg)
![Historial2](screenshots/historial2_modulo6.jpg)


⚠️ Consideraciones

-  Se priorizó la estabilidad de la aplicación durante el desarrollo
-  Se evitó introducir cambios estructurales que pudieran generar errores
-  Room queda como mejora futura del proyecto.

📚 Bibliografía

📘 Material del curso

-  Manual Módulo 6 – Desarrollo de Aplicaciones Android
Contenidos sobre:
-  API REST
-  Testing
-  Acceso a datos
-  Distribución de aplicaciones móviles

🌐 Recursos externos

-  Android Developers. (2024).
https://developer.android.com/topic/architecture
-  Android Developers. (2024).
https://developer.android.com/training/basics/firstapp
-  Square. (2024). Retrofit Documentation.
https://square.github.io/retrofit/
-  MockAPI. (2024).
https://mockapi.io

👩‍💻 Autora

Camila Torres Reyes.
