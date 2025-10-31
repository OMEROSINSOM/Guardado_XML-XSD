# 🏦 Sistema Bancario con XML, XSD y Multihilos – Java (NetBeans)

Aplicación desarrollada en **Java (NetBeans IDE)** que simula el funcionamiento de un **banco**.  
El sistema permite **registrar, modificar, eliminar y consultar clientes**, almacenando los datos en un archivo **XML** validado mediante un **esquema XSD**.  
Además, utiliza **hilos (Threads)** para simular varios **cajeros** atendiendo a los clientes de manera concurrente.

---

## 🚀 Características principales

- **CRUD completo** de clientes bancarios (crear, leer, actualizar, eliminar).  
- **Persistencia en XML** con estructura validada mediante un **archivo XSD**.  
- **Hilos (multithreading):** cada cajero funciona en paralelo atendiendo clientes.  
- **Interfaz gráfica con Swing** para la gestión de clientes y control de ejecución.  
- **Validación automática** del XML antes de guardar o leer datos.  
- **Mensajes de estado y notificaciones** con `JOptionPane`.  

---

## 🛠️ Tecnologías utilizadas

| Componente | Descripción |
|-------------|-------------|
| **Lenguaje** | Java SE 8+ |
| **IDE** | Apache NetBeans 12+ |
| **Persistencia** | XML (DOM / JAXP) |
| **Validación** | XSD (XML Schema Definition) |
| **Multihilos** | `java.lang.Thread`, `Runnable` |
| **GUI** | Java Swing |
| **Paquetes principales** | `modelo`, `dao`, `hilos`, `xml`, `interfaces` |
