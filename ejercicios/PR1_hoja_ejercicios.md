# PR1 · Hoja de ejercicios

**Programación · 1º DAM ·**

---

## Antes de empezar

Cada ejercicio se guarda en su propio fichero, con el nombre exacto que se indica.
**Es un requisito de entrega, no una regla del lenguaje**: se corrigen a la vez
treinta carpetas, y con nombres distintos no hay forma. Si le pones otro nombre, el
programa funciona igual; lo que no funciona es la corrección.

Guarda cada uno en tu carpeta del curso, **como texto plano y en UTF-8**. Si aún no
tienes montado el entorno —Java 25, extensiones visibles, consola— sigue
**`GUIA_ENTORNO_JAVA.md`**, que está en esta misma carpeta y lo lleva de principio
a fin.

Para ejecutar un programa, abre la consola **en la carpeta donde esté el fichero**
(botón derecho en un sitio vacío de la carpeta → *Abrir en Terminal*) y escribe:

```
java E11Portada.java
```

`java` es el programa que lanza el tuyo, y `E11Portada.java` es el fichero que le
pasas. **No hay que compilar nada antes**: Java 25 lo hace solo.

Si no estás seguro de dónde está la consola, mira la ruta y `dir` lista lo que hay
ahí. Si tu fichero no sale en `dir`, la consola está en otra carpeta.

### Cuando algo falle

Va a fallar. Es normal y es parte del trabajo. Cuando salga un error:

1. **Lee el número de línea.** El error dice en qué línea está el problema.
2. **Lee la primera línea del mensaje**, aunque esté en inglés. Las demás sobran.
3. Mira esa línea de tu código y la anterior.
4. Si no lo ves en dos minutos, levanta la mano.

Los cuatro errores que vas a tener esta semana:

| Mensaje | Qué pasa |
|---|---|
| `';' expected` | Falta un punto y coma al final de una línea |
| `illegal character` | Has copiado texto de algún sitio y se han colado comillas raras |
| `cannot find symbol` | Algo está mal escrito. Casi siempre, una mayúscula |
| `error: file not found: E11Portada.java` | La consola está en otra carpeta, o el fichero se guardó como `.txt`. `pwd` y `dir` |
| `class file has wrong version` o un error sobre `void main()` | No estás usando Java 25. Compruébalo con `java --version` |

---

## E1.1 — La portada

**Fichero:** `E11Portada.java`

Escribe un programa que muestre la portada de tu juego: un marco de guiones, el
título y tu nombre debajo. Cuatro o cinco líneas de salida.

No pregunta nada al usuario. Solo escribe.

```
--------------------------------
   LA MAZMORRA DEL CPR
     por Carlos Méndez
--------------------------------
```

El título es tuyo, inventa el que quieras. Va a ser el de tu juego todo el curso.

---

## E1.2 — Saludar por el nombre

**Fichero:** `E12Saludo.java`

Escribe un programa que pregunte al usuario cómo se llama y le responda saludándole
por su nombre.

```
¿Cómo te llamas? Lucía
Hola, Lucía. Bienvenida a la mazmorra.
```

**Pista:** para preguntar se usa `IO.readln`, y hay que guardar lo que conteste en
algún sitio para poder usarlo después.

---

## E1.3 — La ficha del personaje

**Fichero:** `E13Ficha.java`

Escribe un programa que pregunte **tres** datos del personaje —nombre, clase y
arma— y luego los presente juntos, uno por línea.

```
Nombre del personaje: Nel
Clase (guerrero, mago, pícaro): mago
Arma: bastón

Personaje: Nel
Clase....: mago
Arma.....: bastón
```

Fíjate en que primero pregunta las tres cosas y **después** las escribe todas. No
va preguntando y respondiendo de una en una.

---

## E1.4 — Explicar tu propio código

**Fichero:** `E14FichaComentada.java`

Copia tu E1.3 en un fichero nuevo y **comenta todas las líneas**.

Un comentario se escribe con `//` y todo lo que va detrás lo ignora el ordenador.
Están ahí para las personas.

```java
// Pide el nombre y lo guarda en una caja llamada "nombre".
String nombre = IO.readln("Nombre del personaje: ");
```

**Reglas:**

- Un comentario por cada línea de código.
- Explica **qué hace y para qué**, no cómo se escribe. `// declaro una variable`
  no vale. `// guardo el nombre para poder escribirlo luego` sí.
- Si no sabes explicar una línea, esa línea no la entiendes. Pregunta.


---

## Cómo se entrega

De momento, **no se entrega nada**. Los cuatro ficheros se guardan en tu carpeta y
se quedan ahí.

En la semana 3, en Contornos, montaremos el repositorio y estos cuatro ejercicios
serán tus primeros *commits*. Guárdalos bien: **no los borres ni los renombres**.

Prepara también `BITACORA_PROMPTS.md`, que es un fichero de texto tuyo con
extensión `.md`: se crea igual que un `.java`, eligiendo *Todos los archivos* al
guardar. Sigue el **recuadro «Esta semana»** de `PROTOCOLO_IA_1DAM.md`
—el resto del protocolo usa herramientas que todavía no hemos visto—.

Si consultas una IA, no pegues material privado ni datos personales: anota qué
esperabas, qué aceptaste o rechazaste y qué ejecutaste. Si no la usas, escribe «No
he usado IA en esta entrega».

---

## Si terminas antes

- Haz que el E1.3 pregunte también la edad y la ciudad.
- Haz que la ficha del E1.3 salga dentro de un marco, como la portada del E1.1.
- Mira qué pasa si en el E1.2 no escribes nada y le das a Enter directamente.
  Anota qué ocurre: nos hará falta más adelante.
