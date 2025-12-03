# 🍎 Huerto Hogar Mobile

**Huerto Hogar** es una aplicación móvil desarrollada con **Kotlin Multiplatform** (enfocada en Android) diseñada para la visualización y compra de productos frescos como frutas, verduras y productos orgánicos. La aplicación permite a los usuarios navegar por un catálogo de productos, ver detalles específicos y gestionar su perfil de usuario.

## 📱 Características Principales

* **Autenticación de Usuarios:**
    * Pantalla de inicio de sesión con validación de credenciales (correo y contraseña).
    * Persistencia de sesión básica utilizando `SharedPreferences`.
* **Catálogo de Productos:**
    * Visualización de productos en una cuadrícula (Grid) interactiva.
    * Carga de imágenes dinámica.
* **Detalle de Producto:**
    * Información detallada: Nombre, precio, descripción y stock disponible.
    * Navegación fluida entre el catálogo y el detalle.
* **Perfil de Usuario:**
    * Visualización del usuario logueado actualmente.
* **Gestión de Estados:**
    * Manejo de estados de UI: *Cargando* (Loading), *Éxito* (Success) y *Error*.

## 🛠️ Stack Tecnológico

El proyecto está construido utilizando tecnologías modernas del ecosistema Android y Kotlin:

* **Lenguaje:** [Kotlin](https://kotlinlang.org/)
* **UI Framework:** [Jetpack Compose](https://developer.android.com/jetpack/compose) (UI declarativa).
* **Arquitectura:** MVVM (Model-View-ViewModel).
* **Red (Networking):**
    * [Retrofit](https://square.github.io/retrofit/) - Cliente HTTP.
    * [OkHttp](https://square.github.io/okhttp/) & Logging Interceptor.
    * **API Base URL:** `https://hh-api-producto.onrender.com`
* **Carga de Imágenes:** [Coil 3](https://coil-kt.github.io/coil/) (AsyncImage).
* **Navegación:** [Navigation Compose](https://developer.android.com/guide/navigation/navigation-compose).
* **Inyección de Dependencias:** Manual (ViewModelFactory).
* **Sistema de Construcción:** Gradle (Kotlin DSL).

## 🚀 Instalación y Configuración

Sigue estos pasos para ejecutar el proyecto en tu entorno local:

### Prerrequisitos
* Android Studio (versión reciente recomendada).
* JDK 11 o superior.
* Dispositivo Android o Emulador con API 24 (Android 7.0) o superior.

### Pasos

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/tu-usuario/huerto-hogar-movile.git](https://github.com/tu-usuario/huerto-hogar-movile.git)
    cd huerto-hogar-movile
    ```

2.  **Abrir en Android Studio:**
    * Abre Android Studio y selecciona "Open".
    * Navega a la carpeta del proyecto y selecciona el archivo `build.gradle.kts` o la carpeta raíz.

3.  **Sincronizar Gradle:**
    * Espera a que Android Studio descargue las dependencias y sincronice el proyecto.

4.  **Ejecutar la App:**
    * Selecciona el módulo `composeApp` o la configuración de ejecución por defecto.
    * Presiona el botón de **Run** (▶️) o usa `Shift + F10`.

## 📂 Estructura del Proyecto

El proyecto sigue una estructura de Kotlin Multiplatform, donde la lógica principal de la UI de Android reside en:

```text
huerto-hogar-movile/
├── composeApp/                 # Módulo principal de la aplicación (KMP)
│   ├── build.gradle.kts        # Dependencias específicas (Compose, Coil, Retrofit)
│   └── src/androidMain/
│       ├── kotlin/org/example/project/
│       │   │
│       │   ├── model/          # 📦 Modelos de Datos
│       │   │   └── DataClasses.kt      # Definición de 'Producto' y estructuras de datos
│       │   │
│       │   ├── repository/     # 🌐 Capa de Datos y Red
│       │   │   ├── RetrofitInstance.kt # Configuración del cliente HTTP y URL base
│       │   │   ├── ProductosService.kt # Definición de endpoints de la API
│       │   │   └── ProductoRepository.kt # Intermediario entre la API y el ViewModel
│       │   │
│       │   ├── view/           # 🎨 Capa de Presentación (UI)
│       │   │   ├── screens/    # Pantallas Completas
│       │   │   │   ├── LoginScreen.kt       # Pantalla de autenticación
│       │   │   │   ├── HomeScreen.kt        # Pantalla principal (Catálogo)
│       │   │   │   ├── ProductDetails.kt    # Pantalla de detalle de producto
│       │   │   │   ├── ProfileScreen.kt     # Pantalla de perfil de usuario
│       │   │   │   │
│       │   │   │   ├── composables/         # Componentes Reutilizables
│       │   │   │   │   ├── HomeGrid.kt      # Cuadrícula de productos
│       │   │   │   │   ├── Details.kt       # Componente visual del detalle
│       │   │   │   │   └── AddButton.kt     # Botón de acción rápida
│       │   │   │   │
│       │   │   │   └── transiciones/        # Feedback al Usuario
│       │   │   │       ├── LoadingScreen.kt # Indicador de carga
│       │   │   │       └── ErrorScreen.kt   # Pantalla de error/reintento
│       │   │   │
│       │   │   └── viewmodel/  # 🧠 Gestión de Estado (State Management)
│       │   │       ├── LoginViewModel.kt    # Lógica de login
│       │   │       ├── HomeViewModel.kt     # Lógica de carga de productos
│       │   │       └── ViewModelFactory.kt  # Inyección de dependencias para ViewModels
│       │   │
│       │   ├── App.kt          # 🧭 Grafo de Navegación y Setup inicial
│       │   └── MainActivity.kt # 🏁 Punto de entrada de la aplicación Android
│       │
│       └── res/                # 🖼️ Recursos Estáticos
│           ├── drawable/       # Imágenes de frutas, verduras y assets gráficos
│           ├── mipmap/         # Iconos de lanzamiento (Launcher Icons)
│           └── values/         # Textos (strings.xml) y colores
│
├── gradle/                     # Configuración de Gradle y Versiones
│   └── libs.versions.toml      # Catálogo de versiones de librerías
│
└── build.gradle.kts            # Configuración global del proyecto