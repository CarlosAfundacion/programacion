# PR1 · Del problema al programa que se ejecuta

**Programación · 1º DAM · Apuntes**

---

## Al terminar esta unidad vas a saber

- Qué es exactamente un programa y qué pasa cuando lo ejecutas.
- Escribir un programa en Java, guardarlo y ejecutarlo.
- Hacer que tu programa escriba cosas en pantalla.
- Hacer que tu programa te pregunte algo y use tu respuesta.
- Leer un mensaje de error y saber a qué línea se refiere.

No hace falta saber nada previo. Si nunca has programado, esta unidad está escrita
para ti.

---

## 1. Qué es un programa

Un programa es **una lista de órdenes que una máquina ejecuta en orden**.

Nada más. No hay inteligencia dentro, ni intuición, ni sentido común. Hay una lista
y una máquina que la recorre de arriba abajo haciendo exactamente lo que pone.

Esa obediencia literal es la fuente de casi todos tus problemas del primer mes, y
también la razón de que la programación se pueda aprender: si algo no funciona, no
es que el ordenador «no te haya entendido». Es que le dijiste otra cosa.

### El orden importa, y punto

```java
void main() {
    IO.println("Hola");
    IO.println("Que tal");
}
```

Escribe:

```
Hola
Que tal
```

Y si cambias las dos líneas de sitio, escribe:

```
Que tal
Hola
```

Parece obvio. Lo es. Y es la primera regla: **una instrucción detrás de otra, en el
orden en que están escritas**.

> Eso vale **para los programas de esta unidad**, que son una lista seguida de
> órdenes. A partir de PR3 aparecen instrucciones que se saltan trozos, repiten
> partes o se van a otro sitio y vuelven. El recorrido cambia; lo que no cambia es
> que la máquina lo sigue **al pie de la letra**.

---

## 2. Tu primer programa

Este es un programa completo en Java. No falta nada.

```java
void main() {
    IO.println("Hola, mundo");
}
```

Guárdalo en un fichero llamado `Hola.java` y ejecútalo desde la consola:

```
java Hola.java
```

Debería aparecer `Hola, mundo`.

> **Si todavía no sabes crear el fichero, guardarlo como texto plano o abrir una
> consola en su carpeta**, está todo explicado paso a paso en
> **`GUIA_ENTORNO_JAVA.md`**, en la carpeta `programacion/` del material del curso:
> instalar Java 25, comprobar que es la 25, ver las
> extensiones en el Explorador, abrir la consola donde toca y ejecutar. Se hace una
> vez y no se vuelve a tocar.

### Qué es cada cosa

| Trozo | Qué significa |
|---|---|
| `void main()` | «Aquí empieza el programa». Es el punto por donde arranca todo |
| `{` y `}` | Marcan dónde empieza y dónde acaba el bloque de órdenes |
| `IO.println(...)` | «Escribe esto en pantalla y salta de línea» |
| `"Hola, mundo"` | El texto que quieres escribir. Entre comillas dobles |
| `;` | «Aquí termina esta orden». Como el punto de una frase |

> **Sobre `void main()`.** Es **el punto de entrada**: el sitio por donde la máquina
> empieza a ejecutar. Java necesita que ese punto esté dentro de una **clase**, que
> es la caja en la que se agrupa el código; cuando escribes un fichero así de corto,
> el compilador crea esa caja por ti, con el nombre del fichero.
>
> Eso es todo lo que hace falta hoy. **Qué es exactamente una clase, y qué significa
> cada palabra de la forma larga**, se ve en PR5: no por misterio, sino porque hasta
> entonces no tienes las piezas y memorizarlo sin ellas no sirve de nada.

### Java 25 y los apuntes viejos

Si buscas «hola mundo en Java» por internet, casi seguro te sale esto:

```java
public class Hola {
    public static void main(String[] args) {
        System.out.println("Hola, mundo");
    }
}
```

**No está mal.** Es la forma larga, y funciona. Pero desde Java 25 no hace falta
escribirla, y en clase usamos la corta. Si te la encuentras, no te asustes: es lo
mismo con más envoltorio, y lo veremos en PR5.

---

## 3. Escribir en pantalla

`IO.println` escribe lo que le pongas entre paréntesis y salta de línea.

```java
void main() {
    IO.println("=== FICHA DE PERSONAJE ===");
    IO.println("Nombre: Brego");
    IO.println("Clase: Guerrero");
}
```

### Juntar textos con `+`

Puedes pegar trozos de texto con el símbolo `+`:

```java
IO.println("Hola, " + "Carlos");     // escribe: Hola, Carlos
```

Esto va a ser muy útil en cuanto tengas datos que meter dentro de una frase.

### Cuidado con los espacios

El ordenador no añade espacios por su cuenta:

```java
IO.println("Hola," + "Carlos");      // escribe: Hola,Carlos
IO.println("Hola, " + "Carlos");     // escribe: Hola, Carlos
```

La diferencia es el espacio dentro de las comillas. Si el resultado te sale todo
pegado, mira ahí.

---

## 4. Preguntarle algo al usuario

`IO.readln` escribe una pregunta, espera a que el usuario teclee algo y pulse
Enter, y **te devuelve lo que haya escrito**.

```java
void main() {
    String nombre = IO.readln("Como te llamas? ");
    IO.println("Encantado, " + nombre + ".");
}
```

La parte nueva es `String nombre = ...`. Se lee así:

> «Guarda en una caja llamada `nombre`, que contiene texto, lo que devuelva
> `IO.readln`.»

De las cajas hablaremos a fondo en PR2. Por ahora te basta con saber que **hay que
guardar lo que el usuario escribe en algún sitio**, o se pierde.

### Un programa completo

```java
void main() {
    String nombre = IO.readln("Como te llamas? ");
    String color = IO.readln("Tu color favorito? ");
    IO.println("");
    IO.println(nombre + ", tu color es el " + color + ".");
    IO.println("Tu nombre tiene " + nombre.length() + " letras.");
}
```

Ejecutado, con «Carlos» y «verde»:

```
Como te llamas? Carlos
Tu color favorito? verde

Carlos, tu color es el verde.
Tu nombre tiene 6 letras.
```

Dos detalles:

- `IO.println("")` escribe una línea en blanco. Sirve para separar y que se lea mejor.
- `nombre.length()` es **cuántos caracteres tiene el texto**. Para nombres normales
  coincide con las letras que ves. No siempre: hay símbolos que Java cuenta como dos
  —algunos emojis, por ejemplo— porque lo que cuenta no son «letras» sino las
  unidades con las que guarda el texto por dentro. Se ve a fondo en PR6.
  Documentación: <https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/String.html>

---

## 5. Anatomía de un programa

Ya tienes todas las piezas del primer mes. Vamos a ponerles nombre.

```java
void main() {                                  // ← cabecera
    String nombre = IO.readln("Nombre: ");     // ← instrucción
    IO.println("Hola, " + nombre);             // ← instrucción
}                                              // ← cierre del bloque
```

| Concepto | Qué es |
|---|---|
| **Instrucción** | Una orden. Termina en punto y coma |
| **Bloque** | Un grupo de instrucciones entre llaves `{ }` |
| **Ejecución** | El recorrido de la máquina por las instrucciones, en orden |
| **Literal** | Un valor escrito tal cual, como `"Hola"` o `42` |

### Las llaves y el sangrado

Todo lo que va dentro de un bloque se escribe **desplazado a la derecha**, con
cuatro espacios. Esto:

```java
void main() {
    IO.println("dentro");
}
```

y esto:

```java
void main() {
IO.println("dentro");
}
```

hacen **exactamente lo mismo**. A Java le da igual. Pero el segundo es más difícil
de leer, y cuando tengas bloques dentro de bloques dentro de bloques, el sangrado
será lo único que te permita saber dónde estás.

Tu IDE lo hace solo. Déjale.

---

## 6. Comentarios

Un comentario es texto que el ordenador **ignora** por completo. Está ahí para las
personas.

```java
void main() {
    // Esto es un comentario de una línea. Java no lo lee.
    IO.println("Hola");   // También puede ir al final de una línea
}
```

Hay una segunda forma, con tres barras, que se usa para explicar **qué hace** algo:

```java
/// Saluda al usuario preguntándole el nombre.
void main() {
    // ...aquí irían las instrucciones
}
```

> Los puntos suspensivos de arriba **no son código**: están para decir «aquí va el
> resto, que no viene al caso». Si los copias tal cual, no compila.

En este curso usamos `///` para explicar para qué sirve un trozo de programa, y
`//` para notas sueltas.

### Para qué sirven de verdad

No para traducir el código. Esto no aporta nada:

```java
// escribe hola
IO.println("Hola");
```

Sirven para explicar **por qué**, que es lo que no se ve mirando el código:

```java
// Se deja una línea en blanco para separar la ficha del menú anterior
IO.println("");
```

---

## 7. Cuando algo falla

Te va a fallar constantemente el primer mes. Es normal, le pasa a todo el mundo, y
aprender a leer los errores es literalmente la habilidad que estás desarrollando.

### Anatomía de un error

Si escribes esto, olvidando un punto y coma:

```java
void main() {
    IO.println("uno")
    IO.println("dos");
}
```

Java responde:

```
A4.java:2: error: ';' expected
    IO.println("uno")
                     ^
1 error
```

Léelo por partes:

| Trozo | Qué te dice |
|---|---|
| `A4.java` | En qué fichero |
| `:2` | **En qué línea.** Lo más importante |
| `error: ';' expected` | Qué esperaba encontrar y no encontró |
| `^` | En qué punto exacto de la línea |

**Ve siempre a la línea que te dice.** Aquí el aviso es exacto: falta el `;` al
final de la línea 2, y eso es justo lo que dice `A4.java:2`. El `^` señala además el
punto de la línea donde lo esperaba, detrás del paréntesis.

A veces —con una llave `}` que falta, sobre todo— el compilador se da cuenta más
abajo y te manda a una línea posterior a la del fallo real. Aun así el número te
deja a un paso: se mira esa línea y la anterior.

### Los cinco errores del primer mes

| Lo que ves | Casi seguro es |
|---|---|
| `';' expected` | Falta un punto y coma al final de una instrucción |
| `illegal character` | Copiaste de un PDF o de un chat y se colaron comillas «raras» |
| `cannot find symbol` | Escribiste mal un nombre. Java distingue mayúsculas: `IO` no es `io` |
| `class, interface, enum... expected` | Sobra o falta una llave `}` |
| El fichero no se encuentra | Lo guardaste como `.txt` en vez de `.java` |

### Las comillas tipográficas

Este error merece mención aparte porque no se ve.

Si copias código de un documento de Word, de un PDF o de un chat, las comillas
pueden venir «curvadas» (`“` y `”`) en vez de rectas (`"`). Java solo entiende
las rectas.

Míralas juntas y con calma, que es donde se ve:

```
correcto:    IO.println("Hola");
incorrecto:  IO.println(“Hola”);
```

En pantalla, y sobre todo con letra pequeña, parecen casi iguales. El síntoma es
`illegal character`. La solución es borrar las comillas y volver a escribirlas a
mano con la tecla del `2`.

> Si te pasa esto, aprovecha para pensar en lo que acabas de hacer: has copiado
> código sin mirarlo. La próxima vez, escríbelo.

---

## 8. Los acentos

Si tu nombre sale con caracteres raros en pantalla, **no has hecho nada mal**. Es
un desajuste entre cómo guarda Java el texto y cómo lo interpreta la consola.

Se resuelve una vez y ya está, y lo vemos en la unidad CO1 de Contornos, porque es
justo lo que estudia esa unidad: la conversación entre un programa y un periférico.

---

## Resumen en una página

```java
/// Comentario que explica para qué sirve esto.
void main() {                                    // aquí empieza el programa
    String x = IO.readln("Pregunta: ");          // pregunta y guarda la respuesta
    IO.println("Texto " + x);                    // escribe en pantalla
    IO.println("");                              // línea en blanco
}                                                // aquí acaba
```

| Quiero… | Escribo |
|---|---|
| Escribir algo en pantalla | `IO.println("texto");` |
| Escribir una línea en blanco | `IO.println("");` |
| Preguntar y guardar la respuesta | `String x = IO.readln("Pregunta: ");` |
| Pegar dos textos | `"uno" + "dos"` |
| Saber cuántos caracteres tiene un texto | `x.length()` |
| Dejar una nota para personas | `// nota` o `/// explicación` |

**Las cinco reglas de oro**

1. Las instrucciones se ejecutan **en orden**, de arriba abajo.
2. Las instrucciones de esta unidad —escribir, leer, guardar en una caja— terminan
   en **punto y coma**. No todo en Java lo lleva: las llaves `{ }` no, y en PR3
   aparecen líneas que tampoco.
3. Los textos van entre **comillas dobles rectas**.
4. Java distingue **mayúsculas de minúsculas**: `IO` no es `io`.
5. Cuando falle, **lee el número de línea** del error y ve ahí.

---

## Para practicar

Los ejercicios están en `PR1_hoja_ejercicios.md`. Hazlos **en orden** y ejecuta cada
uno antes de pasar al siguiente.

Y un consejo que vale para todo el curso: cuando algo te funcione, **rómpelo a
propósito**. Quita un punto y coma y mira qué error sale. Cambia una mayúscula.
Borra una llave. Así, cuando el error aparezca sin querer, ya sabrás lo que es.
