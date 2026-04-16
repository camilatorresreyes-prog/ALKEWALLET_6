                                            # 💸 ALKEWALLET 6

Aplicación móvil desarrollada en Android Studio como continuación del proyecto del módulo 5.

## 📱 Descripción

ALKEWALLET 6 es una billetera virtual que permite iniciar sesión, visualizar el saldo, registrar depósitos y retiros, y mostrar un historial de transacciones.

Esta versión corresponde a la mejora del proyecto anterior, incorporando el consumo de una API REST mediante Retrofit y MockAPI para simular datos dinámicos.

---

## 🚀 Funcionalidades

- Login básico
- Visualización de saldo
- Depósitos de dinero
- Retiros de dinero
- Historial de transacciones
- Validación de datos ingresados
- Consumo de API REST

---

## 🛠️ Materiales y tecnologías utilizadas

- Kotlin
- Android Studio
- Retrofit (consumo de API REST)
- MockAPI (simulación de backend)
- ViewModel (arquitectura MVVM básica)
- XML (diseño de interfaces)
- Logcat (depuración)

---

## 🌐 API utilizada

La aplicación consume datos desde un endpoint creado en MockAPI:


https://69dc1297560857310a0838b1.mockapi.io/transactions


Este servicio permite simular transacciones con los siguientes campos:
- fecha (`date`)
- monto (`amount`)
- descripción (`description`)
- remitente (`from`)
- destinatario (`to`)

---

## 📂 Estructura del proyecto

- `ui.login` → pantalla de inicio de sesión  
- `ui.wallet` → pantalla principal de la billetera  
- `viewmodel` → lógica de negocio  
- `data.api` → cliente Retrofit y servicio API  
- `model` → modelo de datos  

---

## ⚠️ Consideraciones técnicas

El proyecto fue desarrollado como continuación del módulo 5, manteniendo la lógica base de la billetera virtual e incorporando mejoras del módulo 6.

### 📌 Sobre el uso de Room

La implementación de persistencia local con Room fue considerada como parte de las mejoras del proyecto. Sin embargo, se decidió no integrarla en esta versión debido a problemas de compatibilidad y configuración con Gradle durante el desarrollo.

Con el objetivo de garantizar la estabilidad, funcionalidad y cumplimiento de los requisitos principales, se priorizó una aplicación completamente operativa, utilizando consumo de API REST como fuente de datos.

La integración de Room queda como una mejora futura del proyecto.

---

## 👩‍💻 Autora

Camila Torres Reyes
