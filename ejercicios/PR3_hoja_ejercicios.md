# PR3 · Hoja de ejercicios

**Decidir · Programación · 1º DAM**
**Semanas 4 a 6 (05/10 a 19/10) · 12 sesiones**

---

## Qué hay en esta hoja, y qué no

Esta hoja tiene **un solo ejercicio: el E3.4**. Es el único que se entrega y el
único que tiene nota.

Todo lo demás de la unidad —los ejemplos guiados y los ejercicios «Ahora tú», entre
ellos el E3.1, el E3.2, el E3.3 y el E3.5— está en `../apuntes/PR3_apuntes.md`, al
lado de su explicación. Esos **no se entregan y no tienen nota**: se comprueban con
la tabla de casos que llevan al lado.

Conservan su identificador de siempre (E3.1, E3.2, E3.3, E3.5), así que si otro
documento los menciona, sigue hablando de los mismos ejercicios.
---

## E3.4 — Un turno completo

**Fichero:** `E34Turno.java`

Un turno de combate: el héroe actúa, el enemigo contraataca si sigue vivo, y el
programa informa del resultado con tres líneas de formato fijo.

### Lo que lee

1. La vida inicial del héroe, un entero de **1 a 30**.
2. La vida inicial del enemigo, un entero de **1 a 20**.
3. La acción, que hay que **normalizar** (apuntes §4) antes de compararla.

Se te dan siempre enteros válidos dentro de rango. **No tienes que comprobar que lo
sean ni capturar errores**: eso es de PR5.

### Las reglas, todas

| Acción | Qué hace |
|---|---|
| `atacar` | Resta **7** a la vida del enemigo |
| `defender` | El contraataque del enemigo pasa a ser **2** en vez de 5 |
| `pocion` | Suma **8** a la vida del héroe, **sin pasar de 30** |
| `huir` | El turno termina **sin contraataque** |
| cualquier otra cosa, o nada | Se **pierde la acción**, y el contraataque llega igual |

Y después:

- Si la vida del enemigo queda en **0 o por debajo**, se fija en **0** y **no
  contraataca**.
- Si el enemigo sigue vivo, contraataca por **5**, o por **2** si el héroe había
  defendido.
- La vida del héroe **nunca queda negativa**: si baja de 0, se fija en 0.

### Lo que escribe: el contrato de salida

Las tres líneas, **siempre las tres, siempre en este orden y siempre con esta
forma**, pase lo que pase:

```
HEROE=n
ENEMIGO=n
ESTADO=VICTORIA
```

`ESTADO` vale exactamente una de estas cuatro palabras, en mayúsculas:

| Estado | Cuándo |
|---|---|
| `HUIDA` | La acción fue `huir` |
| `VICTORIA` | El enemigo ha quedado en 0 |
| `DERROTA` | El héroe ha quedado en 0 |
| `CONTINUA` | Ninguno de los tres anteriores |

El orden de esa lista **es parte de las reglas**: si la acción fue `huir`, el estado
es `HUIDA` y da igual todo lo demás. Apuntes §8 explica qué es un contrato de salida
y por qué se escribe al final y de una vez.

### Los casos que tiene que pasar

Son **obligatorios**, los diez. Entrada en el orden en que se lee: vida del héroe,
vida del enemigo, acción.

| Héroe | Enemigo | Acción | `HEROE=` | `ENEMIGO=` | `ESTADO=` |
|---|---|---|---|---|---|
| 30 | 20 | `atacar` | 25 | 13 | `CONTINUA` |
| 30 | 20 | `defender` | 28 | 20 | `CONTINUA` |
| 20 | 20 | `pocion` | 23 | 20 | `CONTINUA` |
| 30 | 20 | `pocion` | 25 | 20 | `CONTINUA` |
| 30 | 20 | `huir` | 30 | 20 | `HUIDA` |
| 5 | 7 | `atacar` | 5 | 0 | `VICTORIA` |
| 4 | 20 | `atacar` | 0 | 13 | `DERROTA` |
| 30 | 20 | `bailar` | 25 | 20 | `CONTINUA` |
| 30 | 20 | (Enter sin escribir nada) | 25 | 20 | `CONTINUA` |
| 30 | 20 | `  ATACAR  ` | 25 | 13 | `CONTINUA` |

Los cuatro que más gente falla, y por qué:

- **`30/20/pocion` da 25.** La poción sube de 30 a 38, pero el tope la deja en 30, y
  después el contraataque resta 5. Sin el tope saldría 33.
- **`5/7/atacar` deja al héroe en 5.** El enemigo cae, así que **no contraataca**.
  Si te sale 0, estás contraatacando después de la victoria.
- **`30/20/defender` da 28.** Defender deja el contraataque en 2, no en «la mitad».
- **`  ATACAR  ` tiene que funcionar igual que `atacar`.** Si no, te falta la
  normalización.

### Cómo comprobarlo tú

Pasa los diez a mano, uno por uno, y apunta lo que sale de verdad al lado de lo que
tenía que salir. Diez ejecuciones son tres minutos. Si una sola línea difiere, aún no
está.

**Esto no es opcional:** el resultado de esas diez ejecuciones es lo que va en
`PRUEBAS.md`.

---

## Cómo se entrega

Todo esto tiene que estar hecho **antes de que empiece tu defensa**.
Si falta algo, la entrega no está completa.

### Dónde

En el repositorio que ya tienes asignado, **`hito1-USUARIO`**, en la rama **`main`**:

```
hito1-USUARIO/
├── pr3/
│   ├── E34Turno.java      ← tu programa
│   └── PRUEBAS.md         ← los diez casos, con lo que te sale de verdad
├── BITACORA_PROMPTS.md    ← ya existe: le añades la entrada de PR3
└── ...                    ← el resto del repositorio, sin tocar
```

**No crees un repositorio nuevo y no toques nada de lo que ya hay fuera de `pr3/`.**
El recorrido para clonar, confirmar y subir es el de CO4 §§2-4; si se te ha olvidado
una orden, está ahí.

### Las cuatro condiciones

| | Qué |
|---|---|
| 1 | La carpeta `pr3/` existe en la rama `main` y está **subida** |
| 2 | `pr3/E34Turno.java` compila y arranca |
| 3 | `pr3/PRUEBAS.md` tiene **los diez casos** con lo que sale de verdad |
| 4 | `BITACORA_PROMPTS.md` tiene la entrada de PR3 |

### `PRUEBAS.md`

Una tabla y nada más. Una fila por caso, en el orden de la tabla de arriba:

```markdown
| Entrada | Esperado | Lo que sale | ¿Coincide? |
|---|---|---|---|
| 30 / 20 / atacar | 25 / 13 / CONTINUA | 25 / 13 / CONTINUA | si |
```

Si un caso no coincide, **escríbelo igual, con un `no`**. Una tabla honesta con dos
`no` vale más que una tabla de diez `si` que no te has creído: en la defensa se te va
a preguntar por tu código, y saber dónde falla es exactamente lo que se mide.

### La bitácora de prompts

Una entrada nueva en `BITACORA_PROMPTS.md`, con `PR3` en el título, siguiendo la
estructura que ya tiene el fichero: qué querías, qué contexto compartiste, qué
pediste, qué decidiste hacer con la respuesta, qué cambio revisaste y **qué prueba
ejecutaste de verdad**.

Si no has usado IA, escribe «No he usado IA en esta entrega». Eso también vale y no
resta nada.

### Sobre la corrección automática del repositorio

Ese repositorio tiene corrección automática en la pestaña **Actions**, y **no
comprueba PR3**: está hecha para el hito 1 y lo único que mira es `Juego.java`. Lo
que diga sobre tu entrega de PR3 es, literalmente, nada.

**Tus diez casos los pasas tú**, a mano, y los escribes en `PRUEBAS.md`.

### Los commits

Un commit por cada cosa que funcione, con un mensaje que diga qué hace. **No vale**
un solo commit al final con todo dentro y el mensaje «ejercicios».

---

## Cuando algo falle

Antes de levantar la mano, comprueba estos seis. Son los que salen siempre:

| Lo que ves | Casi seguro es |
|---|---|
| `if (a > b);` | el `;` cierra el `if`; el bloque de debajo se ejecuta siempre |
| Una rama no se alcanza nunca | ramas en mal orden: de lo general a lo específico |
| `==` con textos | `equals`. Apuntes §4 |
| `  ATACAR  ` no funciona | falta `.trim().toLowerCase()` |
| `variable might not have been initialized` | hay un camino que no le da valor |
| El estado sale mal con el enemigo a 0 | estás contraatacando después de la victoria |

Y si el programa va pero un caso de la tabla no sale, el sitio donde mirar es la
regla de ese caso, no el programa entero. Los cuatro de arriba dicen cuál es.
