# PR2 · Hoja de ejercicios

**Datos y expresiones · Programación · 1º DAM**
**Semanas 2 a 4 (21/09 a 05/10) · 15 sesiones**

---

Hasta ahora tu programa escribía carteles. A partir de esta unidad **calcula**.
Es la unidad más larga del trimestre y la que más gente subestima: casi todo lo
que venga después se apoya en entender bien lo de aquí.

### Los tres conceptos de la unidad

1. Una **variable** es una caja con nombre. El nombre no es el contenido.
2. Cada caja tiene un **tipo**, y el tipo decide qué cabe dentro y qué operaciones valen.
3. Dividir dos enteros da un entero. `7 / 2` vale **3**, no 3,5. Esto va a costar.

---

## E2.1 — Estadísticas del personaje

**Fichero:** `E21Estadisticas.java`

Pide **fuerza** y **destreza** (números del 1 al 10) y calcula:

- `vida = 20 + fuerza × 3`
- `ataque = fuerza × 2 + destreza`
- `defensa = destreza × 2`
- `media` de fuerza y destreza, **con decimales**

Escribe los cuatro resultados, uno por línea.

La media es la que tiene trampa: si la calculas mal te sale un número entero.

---

## E2.2 — El cambista

**Fichero:** `E22Monedas.java`

En el juego, 1 oro son 100 de plata, y 1 plata son 100 de cobre.

Pide una cantidad de monedas de cobre y dime cuántas de oro, plata y cobre son.

```
Monedas de cobre: 25384
25384 de cobre son:
  2 oro, 53 plata y 84 cobre.
```

Necesitas dos operadores: `/` para cuántas veces cabe, y `%` para lo que sobra.

Compruébalo con 100, con 99 y con 0.

---

## E2.3 — Trazar a mano

**Fichero:** en papel

**Sin ordenador.** Escribe en papel qué vale cada variable al final:

```java
int a = 10;
int b = 3;
int c = a / b;
int d = a % b;
double e = a / b;
double f = (double) a / b;
a = a + 5;
int g = a / b;
```

Rellena: `a`, `b`, `c`, `d`, `e`, `f`, `g`.

**Después**, y solo después, escríbelo en el ordenador y compruébalo. Si algo no
coincide con lo que habías previsto, eso es exactamente lo que tienes que entender.

---

## E2.4 — La ficha completa

**Fichero:** `E24Ficha.java`

Pide nombre, clase, fuerza y destreza, y saca la ficha del personaje dentro de un
marco, con las columnas alineadas:

```
+----------------------------------+
| BREGO EL TORPE                   |
| Guerrero                         |
+----------------------------------+
| Vida                          41 |
| Ataque                        18 |
| Poder                       7.25 |
+----------------------------------+
```

El nombre va en mayúsculas. El poder es `(fuerza × 1,5 + destreza) / 2` y sale con
dos decimales.

Para alinear usa `String.format`. Para el marco, `"-".repeat(34)`.

---

## E2.5 — Los tres fallos

**Fichero:** `E25Roto.java`

Te doy un programa que **compila y se ejecuta**, pero da tres resultados mal.
Son tres fallos de conversión de tipos.

Ejecútalo primero y mira lo que sale. El primero es escandaloso: dice que te queda
el **0 %** de vida cuando en realidad te queda el 45 %.

Encuentra los tres, arréglalos y escribe al lado de cada uno, en un comentario, por
qué fallaba.

---

## Cuando algo falle

Antes de levantar la mano, comprueba estos cinco. Son los que salen siempre en esta unidad:

| Lo que ves | Casi seguro es |
|---|---|
| El porcentaje da 0 | `vidaActual / vidaMaxima` con enteros da 0 antes de multiplicar por 100. Hay que convertir a `double` **antes** de dividir |
| `double x = 7 / 2;` da 3.0 | la división se calcula entera y **después** se convierte. El `double` de la izquierda llega tarde |
| Comparar textos con `==` | usa `equals`. La explicación completa llega en PR5 |
| `Integer.parseInt` revienta | si el usuario escribe letras. Se arregla en PR5 con `try/catch`. De momento, avisar y seguir |
| Números sueltos en el código | el 20 de la vida base debería ser una constante `final` |

---

## Cómo se entrega

Un commit por ejercicio, con un mensaje que diga qué hace. **No vale** un solo commit al final con todo dentro y el mensaje «ejercicios».

Y la **bitácora de prompts** al día conforme al protocolo común: resultado
esperado, contexto seguro, decisión sobre la propuesta y prueba realmente
ejecutada. Si no has usado IA, déjalo escrito.
