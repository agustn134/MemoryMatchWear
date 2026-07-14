#  Memory Match Wear

**Juego de Memoria para Wear OS**  
*Componentes Android · Pantalla Circular · Animaciones Flip*  
*Arquitectura Limpia · Compose for Wear OS · UTNG 2025*

---

### Datos del Alumno
* **Nombre:** Agustin Lopez Parra
* **Grupo:** GIDS6093
* **Repositorio:** [github.com/agustn134/MemoryMatchWear](https://github.com/agustn134/MemoryMatchWear)

---

**Memory Match** es un juego de memoria que muestra una cuadrícula de tarjetas boca abajo en la pantalla circular del reloj. El jugador las voltea de dos en dos buscando pares de componentes Android (Compose, Room, Flow, StateFlow, ViewModel...). Al completar todos los pares gana. Incluye animaciones fluidas tipo *flip* y respuesta háptica (vibración).

## 1. Visión General

El tablero tiene 12 tarjetas (6 pares) dispuestas en una cuadrícula 3×4 sobre la pantalla circular. El jugador toca una tarjeta → se anima el flip y se revela el ícono/etiqueta → toca una segunda → si coinciden permanecen visibles → si no, se voltean de nuevo tras una pausa de 800ms.

### 1.1 Las 6 parejas de tarjetas

| # | Ícono | Etiqueta | Concepto Android que representa |
| :---: | :--- | :--- |
| **1** | **StateFlow** | Flujo de estado reactivo — fuente de verdad de la UI. |
| **2** | **ViewModel** | Maneja el estado y la lógica de presentación. |
| **3** | **Room** | Base de datos SQLite con DAOs y Entities. |
| **4** |  **Flow** | Stream de datos asíncrono de Coroutines. |
| **5** |**Compose** | Framework declarativo de UI de Google. |
| **6** | **DataLayer** | Wearable Data Layer API (comunicación reloj ↔ teléfono). |

### 1.2 Mecánica del juego

| Estado | Qué hace el jugador | Qué pasa en el sistema |
| :--- | :--- | :--- |
| **IDLE** | Ve 12 tarjetas boca abajo en la cuadrícula. | El tablero se inicializa con los 6 pares mezclados aleatoriamente. |
| **SELECTING_FIRST** | Toca una tarjeta. | La tarjeta se anima (flip) y queda boca arriba. El estado cambia a `WAITING_SECOND`. |
| **SELECTING_SECOND**| Toca una segunda tarjeta diferente. | Flip de la segunda. Si coinciden → `MATCHED`. Si no → pausa de 800ms → ambas se voltean. |
| **MATCHED** | Nada — celebración automática. | Las dos tarjetas se marcan como *matched*. Vibración háptica corta. Si se encuentran todas: `WON`. |
| **WON** | Ve la pantalla de victoria. | Se muestra el tiempo total y los pares encontrados. Opción de reiniciar. |

### 1.3 Stack y Arquitectura

| Componente | Tecnología Implementada |
| :--- | :--- |
| **UI** | Compose for Wear OS — cuadrícula con `LazyVerticalGrid` circular. |
| **Arquitectura** | MVVM + Clean Architecture (Domain / Data / Presentation). |
| **Animación** | `animateFloatAsState` + `graphicsLayer` (rotación en el eje Y para el flip). |
| **Estado** | `GameState` inmutable + `StateFlow<GameState>`. |
| **Persistencia** | DataStore Preferences (para guardar el mejor tiempo y mejores movimientos). |
| **Haptics** | `WearableHapticFeedback` (para eventos de match, error y victoria). |
| **Coroutines** | `viewModelScope.launch` para gestionar la pausa asíncrona de 800ms. |
| **Testing** | JUnit 4 — pruebas de la lógica de matching y mezcla (sin necesidad de emulador). |
