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

