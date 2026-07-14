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

### GIT COMMITS

https://github.com/agustn134/MemoryMatchWear/commit/1bdb182948a2e5f94134bcdcdd177b17575badfc
https://github.com/agustn134/MemoryMatchWear/commit/c4d2ce27be52519be3db6ce0fffcc80840826e97

https://github.com/agustn134/MemoryMatchWear/commit/653b163703de6a6282b666ddd6215c0ae1beb7b0

https://github.com/agustn134/MemoryMatchWear/commit/09ddcd2c444b3c72a92c2935c63df1b58b357d96

https://github.com/agustn134/MemoryMatchWear/commit/dffb4edd15f06680fc807a4ed880adaf85b2b6d2

https://github.com/agustn134/MemoryMatchWear/commit/d0d817a4dee2fe080c24356c54ca75765d78610b

https://github.com/agustn134/MemoryMatchWear/commit/d3ff2d20daa0237924f7cae2a2967bf18b9c2d73

https://github.com/agustn134/MemoryMatchWear/commit/621331fc0f244c2d5cf434258c384a4980b10144
[
](https://github.com/agustn134/MemoryMatchWear/commit/44444e806d84fbc4c90e13df2c1d09b778c78a6c)


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



<img width="384" height="384" alt="imagen" src="https://github.com/user-attachments/assets/8dbb07b3-e00d-4afb-a120-d113034cfc46" />

<img width="384" height="384" alt="imagen" src="https://github.com/user-attachments/assets/ea6aba8e-94a6-480d-ac58-1257202be678" />

<img width="384" height="384" alt="imagen" src="https://github.com/user-attachments/assets/3ff4a12f-8f68-40ff-a5a3-de9170fe005a" />

