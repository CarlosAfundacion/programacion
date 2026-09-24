# PR2 · Datos y expresiones

**Programación · 1º DAM · Apuntes**

---

## Al terminar esta unidad vas a saber

- Guardar datos en variables y cambiarlos.
- Elegir el tipo adecuado para cada dato.
- Hacer cálculos y saber qué resultado van a dar **antes** de ejecutarlos.
- Entender por qué `7 / 2` vale 3 y no 3,5, y cómo conseguir que valga 3,5.
- Sacar los resultados en pantalla bien formateados, en columnas.

---

## 1. Una variable es una caja con nombre

```java
int vida = 30;
```

Eso crea una caja llamada `vida`, que solo admite números enteros, y mete dentro
un 30.

Tres cosas distintas, y conviene no confundirlas:

| | En el ejemplo |
|---|---|
| El **nombre** de la caja | `vida` |
| El **tipo** de la caja | `int` |
| El **contenido** | `30` |

El nombre no es el contenido. Puedes cambiar lo que hay dentro tantas veces como
quieras; el nombre sigue siendo el mismo.

```java
void main() {
    int vida = 30;
    IO.println("Vida: " + vida);     // Vida: 30
    vida = 25;
    IO.println("Vida: " + vida);     // Vida: 25
    vida = vida - 10;
    IO.println("Vida: " + vida);     // Vida: 15
}
```

### `vida = vida - 10` no es una ecuación

En matemáticas, `x = x - 10` no tiene solución. En programación no es una igualdad:
es una **orden**, y se lee de derecha a izquierda.

> «Coge lo que hay en `vida`, réstale 10, y **guarda el resultado otra vez en**
> `vida`.»

El `=` no significa «es igual a». Significa «guarda en».

### Cómo se llaman las cajas

- Empiezan por letra minúscula: `vida`, `nombre`, `ataque`.
- Si son varias palabras, la segunda empieza en mayúscula: `vidaMaxima`,
  `nombreDelHeroe`. Se llama *camelCase*.
- Sin espacios, sin acentos, sin eñes.
- **Con nombres que se entiendan.** `v` no dice nada; `vida` sí. Se admite `i`, `j`
  y `k` como contadores de bucles, y poco más.

---

## 2. Los tipos

Cada caja solo admite una clase de contenido. Estos son los que vas a usar:

| Tipo | Qué guarda | Ejemplo | Ocupa |
|---|---|---|---|
| `int` | Números enteros | `42`, `-7`, `0` | 4 bytes |
| `double` | Números con decimales | `3.5`, `-0.25` | 8 bytes |
| `boolean` | Verdadero o falso | `true`, `false` | sin tamaño fijado |
| `char` | **Un** carácter | `'A'`, `'ñ'`, `'7'` | 2 bytes |
| `String` | Texto | `"Brego el Torpe"` | variable |

### Detalles que importan

**Los decimales van con punto, no con coma.** `3.5`, nunca `3,5`.

**`char` va entre comillas simples; `String` entre dobles.**

```java
char letra = 'A';        // una sola letra, comillas simples
String texto = "A";      // un texto de una letra, comillas dobles
```

No son lo mismo, aunque en pantalla se vean igual.

**`String` empieza por mayúscula y los demás no.** No es un capricho: `String` es
distinto de los otros por dentro, y lo entenderás del todo en PR5. Por ahora,
memorízalo.

**Un `char` es un número por debajo.** Esto sorprende:

```java
char letra = 'A';
IO.println(letra + 1);      // escribe 66, no A1
```

Cada carácter tiene un número asignado, y la `A` es el 65. Rara vez lo vas a
necesitar, pero explica resultados extraños.

### `var`: dejar que Java deduzca el tipo

```java
var vida = 30;           // Java deduce que es int
var nombre = "Brego";    // Java deduce que es String
```

Funciona y es cómodo. Pero **en este curso escribimos el tipo**, al menos hasta
Navidad: verlo escrito ayuda a pensar en tipos, que es justo lo que hay que
aprender aquí.

---

## 3. Constantes

Si un valor no debe cambiar nunca, se marca con `final`:

```java
final int VIDA_MAXIMA = 30;
final double FACTOR_HEROE = 1.5;
```

Por convenio se escriben **en mayúsculas y con guiones bajos**.

Si intentas cambiar una constante, el programa no compila. Eso es lo que quieres:
que el error salte al escribir, no en mitad de una partida.

### Por qué molestarse

Compara:

```java
vida = 30;
if (vida > 30) { vida = 30; }
IO.println("Curado hasta 30");
```

con:

```java
final int VIDA_MAXIMA = 30;
vida = VIDA_MAXIMA;
if (vida > VIDA_MAXIMA) { vida = VIDA_MAXIMA; }
IO.println("Curado hasta " + VIDA_MAXIMA);
```

En el segundo, cambiar la vida máxima a 40 es **tocar una línea**. En el primero es
buscar todos los 30 del programa y decidir cuáles son «ese» 30 y cuáles son otra
cosa.

A un número suelto en mitad del código se le llama **número mágico**, y es de las
pocas cosas que casi todo el mundo en programación considera un error.

---

## 4. Operadores

### Aritméticos

| | Qué hace | Ejemplo | Da |
|---|---|---|---|
| `+` | Suma | `5 + 3` | `8` |
| `-` | Resta | `5 - 3` | `2` |
| `*` | Multiplica | `5 * 3` | `15` |
| `/` | Divide | `7 / 2` | **`3`** ← ojo |
| `%` | Resto de dividir | `7 % 2` | `1` |

### El `%` sirve para más de lo que parece

El resto no es un operador exótico. Aparece constantemente:

```java
// ¿Es par?
numero % 2 == 0

// Convertir 25384 monedas de cobre a oro, plata y cobre
int oro   = total / 10000;
int resto = total % 10000;
int plata = resto / 100;
int cobre = resto % 100;

// Dar la vuelta a un contador: 0,1,2,0,1,2,0...
turno = (turno + 1) % 3;
```

### De comparación

Estos dan siempre `true` o `false`:

| | Significa |
|---|---|
| `==` | ¿Son iguales? |
| `!=` | ¿Son distintos? |
| `<` `>` | Menor, mayor |
| `<=` `>=` | Menor o igual, mayor o igual |

> **`=` guarda. `==` compara.** Es un error clásico y va a pasarte.

### Lógicos

| | Significa | `true` cuando |
|---|---|---|
| `&&` | Y | Las dos condiciones se cumplen |
| `\|\|` | O | Se cumple al menos una |
| `!` | No | Le da la vuelta |

```java
boolean puedePasar = tieneLlave && !estaHerido;
```

### Precedencia

Java hace primero unas cosas y después otras, igual que en matemáticas:

```java
2 + 3 * 4       // 14, porque primero multiplica
(2 + 3) * 4     // 20, porque los paréntesis mandan
```

El orden es: primero `*` `/` `%`, luego `+` `-`, luego las comparaciones, luego
`&&`, y por último `||`.

**No lo memorices: pon paréntesis.** Nadie te va a felicitar por escribir una
expresión que hay que descifrar.

Cuidado también con las restas encadenadas, que van de izquierda a derecha:

```java
10 - 2 - 3      // 5,  es (10-2)-3
10 - (2 - 3)    // 11
```

---

## 5. La división entera

**Esta sección es la más importante de la unidad.** Léela dos veces.

### El problema

```java
IO.println(7 / 2);      // escribe 3
```

No es un error de Java. Es una regla: **si divides dos enteros, el resultado es
entero**, y la parte decimal se tira. No se redondea: se corta.

```java
7 / 2   →  3        (no 3.5, y tampoco 4)
9 / 4   →  2
1 / 2   →  0        ← este hace mucho daño
```

### Por qué importa tanto

Este código parece correcto y da 0:

```java
int vidaActual = 45;
int vidaMaxima = 100;
int porcentaje = vidaActual / vidaMaxima * 100;
IO.println("Vida restante: " + porcentaje + " %");     // escribe: 0 %
```

Paso a paso: `45 / 100` son dos enteros, así que da **0**. Y `0 * 100` es 0.

### Las soluciones

**Que uno de los dos sea decimal.** Basta con uno:

```java
7 / 2.0     →  3.5
7.0 / 2     →  3.5
```

**Convertir con `(double)`, si son variables:**

```java
int a = 7, b = 2;
(double) a / b      →  3.5
```

**El sitio del `(double)` importa:**

```java
(double) a / b        →  3.5     convierte a, luego divide
(double) (a / b)      →  3.0     divide entero (da 3), luego convierte
```

En el segundo, cuando conviertes ya has perdido el decimal. **Hay que convertir
antes de dividir.**

### La trampa del `double` a la izquierda

```java
double mal = 7 / 2;
IO.println(mal);        // escribe 3.0
```

Mucha gente espera 3.5. Pero Java calcula primero la parte derecha —`7 / 2` entre
enteros, que da 3— y **después** lo guarda en un `double`. El `double` llega tarde.

Lo correcto:

```java
double bien = 7.0 / 2;   // 3.5
```

### Convertir al revés: `(int)`

```java
(int) 3.9       →  3
(int) -3.9      →  -3
```

**Trunca, no redondea.** Corta por el punto. Si quieres redondear de verdad, hay
otra herramienta y la verás en PR5.

### De texto a número

Lo que devuelve `IO.readln` **siempre es texto**, aunque el usuario teclee un
número. Para operar con él hay que convertirlo:

```java
int fuerza = Integer.parseInt(IO.readln("Fuerza: "));
double peso = Double.parseDouble(IO.readln("Peso: "));
```

> Si el usuario escribe «hola», esto revienta y el programa se para. Es un problema
> real, tiene solución, y se llama excepciones. Lo veremos en PR5. De momento, al
> probar tus programas, teclea números.

---

## 6. Sacar los datos bien

Concatenar con `+` funciona, pero para una tabla se queda corto:

```java
IO.println("Vida: " + vida);
IO.println("Ataque: " + ataque);
```

sale descolocado en cuanto los números tienen distinto número de cifras.

### `String.format`

```java
IO.println(String.format("%-14s %8d", "Vida", vida));
```

El primer argumento es una **plantilla** con huecos, y los demás son lo que va en
cada hueco.

| Hueco | Para | Ejemplo |
|---|---|---|
| `%d` | Enteros | `%5d` reserva 5 espacios, alineado a la derecha |
| `%f` | Decimales | `%.2f` con dos decimales |
| `%s` | Textos | `%-10s` reserva 10, alineado a la **izquierda** |

El signo menos alinea a la izquierda. Sin él, a la derecha.

### Un marco completo

```java
final int ANCHO = 34;
String linea = "+" + "-".repeat(ANCHO) + "+";

IO.println(linea);
IO.println(String.format("| %-14s %17d |", "Vida", 41));
IO.println(String.format("| %-14s %17.2f |", "Poder", 7.25));
IO.println(linea);
```

```
+----------------------------------+
| Vida                          41 |
| Poder                       7.25 |
+----------------------------------+
```

`"-".repeat(34)` escribe el guion 34 veces. Ahorra contarlos a mano.

---

## Errores típicos

| Lo que ves | Qué pasa | Cómo se arregla |
|---|---|---|
| Un porcentaje da 0 | División entera | `(double)` **antes** de dividir |
| `double x = 7 / 2;` da 3.0 | Se calcula entero y se convierte después | `7.0 / 2` |
| `possible lossy conversion` | Metes un `double` en un `int` | `(int)`, sabiendo que trunca |
| Comparar textos con `==` no funciona | Los textos no se comparan así | `.equals()`. Se explica en PR5 |
| `NumberFormatException` | `parseInt` de algo que no es número | Se arregla en PR5 |
| El resultado sale con la coma rara | Estás usando `3,5` en vez de `3.5` | Punto decimal |
| `cannot assign a value to final` | Intentas cambiar una constante | Está bien: era intocable |

---

## Resumen en una página

```java
final int VIDA_MAXIMA = 30;              // constante, en mayúsculas
int vida = 30;                            // entero
double media = 7.5;                       // decimal, con punto
boolean vivo = true;                      // verdadero o falso
char inicial = 'B';                       // comillas simples
String nombre = "Brego";                  // comillas dobles

vida = vida - 10;                         // "guarda en", no "es igual a"
```

| Quiero… | Escribo |
|---|---|
| Dividir con decimales | `(double) a / b` |
| El resto de una división | `a % b` |
| Quitar los decimales | `(int) x` (trunca) |
| Convertir texto a número | `Integer.parseInt(texto)` |
| Alinear en columnas | `String.format("%-10s %5d", txt, num)` |
| Dos decimales | `String.format("%.2f", x)` (coma o punto **según el equipo**) |
| Dos decimales, siempre con punto | `String.format(java.util.Locale.ROOT, "%.2f", x)` |
| Una línea de guiones | `"-".repeat(30)` |

**Las cinco reglas de oro**

1. `=` guarda. `==` compara.
2. Entero dividido entre entero da **entero**.
3. Hay que convertir a `double` **antes** de dividir, no después.
4. `(int)` trunca, no redondea.
5. Ante la duda con la precedencia, **pon paréntesis**.

---

## Para practicar

Los ejercicios están en `PR2_hoja_ejercicios.md`.

El **E2.3** es especial: se hace en papel, sin ordenador, prediciendo qué vale cada
variable. Hazlo así de verdad. Predecir y luego comprobar enseña muchísimo más que
ejecutar y ver qué sale, porque te obliga a descubrir en qué te equivocabas.
