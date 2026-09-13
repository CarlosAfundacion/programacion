# Guía de puesta en marcha · Instalación del entorno Java 25

**Programación (MP0485) y Contornos de desenvolvemento (MP0487) · 1º DAM**
**Material del alumnado. Curso 2026/27**

---

Esta guía es para llegar desde un ordenador en el que no hay nada hasta tener el
entorno de Java 25 **instalado, configurado y comprobado**. No hace falta saber
nada previo, y todo lo que aparece aquí está explicado antes de usarse.

Esta guía **no enseña a programar**: los programas de ejemplo, su sintaxis y su
explicación se ven en los apuntes de Programación y de Contornos. Aquí solo se
instalan las herramientas y se comprueba que funcionan.

Se usa en dos momentos:

- **En clase, el primer día.** 
- **En casa, si tienes ordenador propio.** Entonces se hace entera, desde el
  apartado 2.

> **Tener ordenador en casa no es un requisito del módulo.** Todo lo evaluable se
> hace en el aula. Esta guía existe para que quien quiera practicar fuera pueda.

---

## 1. Cuatro palabras que hacen falta antes de empezar

| Palabra | Qué es |
|---|---|
| **Fichero** | Un documento guardado en el disco. Tiene un nombre y vive dentro de una carpeta |
| **Carpeta** | Una caja que contiene ficheros y otras carpetas |
| **Ruta** | La lista de carpetas que hay que atravesar para llegar a un fichero: `C:\Users\lucia\Documents\dam\Hola.java` |
| **Extensión** | Lo que va detrás del último punto del nombre: `.java`, `.txt`, `.pdf`. Dice **qué clase de fichero es** |

Y una más, que es la que más problemas da el primer día:

**Texto plano.** Un fichero de texto plano contiene **solo letras**, sin negritas,
sin tipos de letra y sin márgenes. El código fuente es texto plano. Word **no**
guarda texto plano: guarda un documento con formato, y por eso no sirve para
programar.

### Activa la vista de extensiones. Ahora, antes de nada

Windows oculta las extensiones por defecto, y eso hace invisible el error más
frecuente de la primera semana: guardar `Hola.java.txt` creyendo que se guardó
`Hola.java`.

En Windows 11: abre el **Explorador de archivos**, pulsa **Ver** → **Mostrar** →
marca **Extensiones de nombre de archivo**.

A partir de ahora los nombres se ven enteros. Si tu fichero aparece como
`Hola.java.txt`, cámbiale el nombre y quítale el `.txt`.

---

## 2. Instalar el JDK 25

**JDK** son las siglas de *Java Development Kit*: el paquete que hace falta para
**escribir** programas en Java. Contiene el compilador (`javac`), el lanzador
(`java`) y las librerías. En Contornos, en la unidad CO1, se ve qué es cada pieza;
aquí basta con saber que es lo que hay que instalar.

**En este curso se usa Java 25.** No vale una versión anterior: los programas de
las primeras unidades usan una forma de escribir que solo existe a partir de la 25.

### Descargar el JDK 25

Tienes varias opciones para descargar el JDK 25. Una recomendada es **Eclipse Adoptium**:

1. Entra en <https://adoptium.net/temurin/releases/>.
2. Elige:
   - **Operating System**: Windows
   - **Architecture**: x64 (es lo que tiene prácticamente cualquier portátil; si tu
     equipo es un ARM, elige aarch64)
   - **Package Type**: **JDK** (no JRE)
   - **Version**: **25**
3. Descarga el fichero **`.msi`**, que es el instalador.

### Instalar

Ejecuta el `.msi` y acepta las opciones por defecto, **asegurándote de que está
marcada la opción `Set JAVA_HOME variable` y `Add to PATH`**. Si están en gris con
una equis roja, pínchalas y elige *Will be installed on local hard drive*.

**Qué es el PATH.** Cuando escribes `java` en una consola, el sistema no busca por
todo el disco: mira solo en una lista de carpetas llamada **PATH**. Marcar esa
casilla añade la carpeta del JDK a esa lista, y por eso después puedes escribir
`java` desde cualquier sitio. Si no se marca, la consola contestará que `java` no
se reconoce aunque esté instalado.

### Comprobar

**Cierra todas las consolas que tengas abiertas y abre una nueva.** El PATH se lee
al abrir la consola: una que ya estuviera abierta no se entera del cambio.

Abre una consola (apartado 3) y escribe estas dos órdenes, una detrás de otra:

```
java --version
javac --version
```

Las dos tienen que contestar **25**, algo parecido a esto:

```
openjdk 25 2025-09-16
OpenJDK Runtime Environment (build 25+...)
OpenJDK 64-Bit Server VM (build 25+..., mixed mode, sharing)

javac 25
```

Lo importante es que ambas órdenes reporten **25** como versión principal.

| Si sale esto | Es que |
|---|---|
| `'java' no se reconoce como un comando interno o externo` | O no está instalado, o no se marcó lo del PATH, o no has abierto una consola nueva |
| Un número que **no** es 25 | Tienes otra versión de Java instalada y el PATH la encuentra antes. Avisa: no lo arregles a ciegas |
| `java` contesta 25 pero `javac` no se reconoce | Instalaste el JRE en vez del JDK. Vuelve al paso de la descarga y elige *JDK* |

---

## 3. La consola

La **consola** (o terminal) es una ventana donde se escriben órdenes con el teclado
en vez de pinchar con el ratón. En Windows 11 la que se usa es **Terminal de
Windows**, que abre PowerShell.

### Abrirla en la carpeta correcta

Esto es lo importante: la consola siempre está **situada en una carpeta**, y las
órdenes actúan sobre esa carpeta. La forma más rápida de abrirla donde te interesa:

1. Abre el Explorador y entra en la carpeta donde tengas tus ficheros.
2. **Botón derecho sobre un sitio vacío** de la carpeta → **Abrir en Terminal**.

### Lo que ves al abrirla

```
PS C:\Users\lucia\Documents\dam>
```

Eso es el **prompt**: no es una orden, es la consola diciéndote dónde estás.
**Tú escribes solo lo que va después**, y pulsas **Enter**.

### Las cuatro órdenes que hacen falta esta semana

| Orden | Qué hace |
|---|---|
| `pwd` | Dice en qué carpeta estás. Cuando algo no aparezca, empieza por aquí |
| `dir` | Lista lo que hay en la carpeta actual |
| `cd nombre-de-carpeta` | Entra en esa carpeta |
| `cd ..` | Sube a la carpeta de arriba |

**Rutas con espacios.** Si una carpeta se llama `mis programas`, hay que escribirla
entre comillas: `cd "mis programas"`. Sin comillas, la consola entiende dos cosas
distintas y da error.

**Un truco que ahorra mucho tiempo:** escribe las primeras letras del nombre y pulsa
**Tab**. La consola lo completa sola, y así no te equivocas al teclear.

> **La consola y el editor son dos cosas distintas.** En el editor **escribes el
> programa**; en la consola **das órdenes al sistema** para ejecutarlo. Lo que se
> escribe en uno no se escribe en el otro: `java Hola.java` es una orden de la
> consola, no una línea de tu programa.

---

## 4. El editor y tu carpeta de trabajo

### Crea tu carpeta ahora, y no la muevas

```
C:\Users\tu-usuario\Documents\dam\
```

**Todo lo del curso va aquí dentro.** No en el Escritorio, no en Descargas, no en
una memoria USB que se te olvide en casa.

> **En los equipos del aula, pregunta antes dónde se guarda.** En muchos centros el
> disco del aula se borra al reiniciar. Si es el caso, al terminar cada clase copia
> tu carpeta a tu espacio personal, a una nube o a un USB. **Perder el trabajo de la
> semana pasada no es una excusa que puedas usar dos veces.**

### El editor del primer día: el Bloc de notas

El primer día se usa el **Bloc de notas** de Windows. No porque sea bueno, sino
porque **ya está instalado, guarda texto plano y no distrae**. El entorno de
desarrollo de verdad (IntelliJ IDEA) se instala en Contornos, en la unidad CO3, y a
partir de ahí es el que se usa.

**Crear y guardar un fichero `.java`, paso a paso:**

1. Abre el Bloc de notas (tecla Windows, escribe «Bloc de notas», Enter).
2. Escribe o pega el contenido que te den en clase.
3. **Archivo → Guardar como**.
4. Navega hasta `Documents\dam`.
5. En **Tipo**, elige **Todos los archivos** (si dejas «Documentos de texto», te
   añade `.txt` al final).
6. En **Codificación**, elige **UTF-8**. Es lo que hace que la ñ y las tildes se
   guarden bien.
7. En **Nombre**, escribe el nombre completo **con la extensión**, por ejemplo
   `Prueba.java`.
8. Guardar.

**Comprueba en el Explorador que el fichero se llama exactamente como debe, sin
nada añadido.** Con la vista de extensiones activada (apartado 1) esto se ve de
un vistazo.

Cada vez que cambies algo, **`Ctrl+G`**. Ejecutar un programa **no lo guarda**: si
editas y no guardas, ejecutas la versión anterior y te vuelves loco buscando un
error que ya habías arreglado.

### Si prefieres usar IntelliJ IDEA desde el principio

Se puede, y en CO3 se hace igualmente. Lo mínimo:

1. Descarga **IntelliJ IDEA Community Edition** de
   <https://www.jetbrains.com/idea/download/> (la edición *Community* es gratuita).
2. Instala con las opciones por defecto.
3. Al crear un proyecto nuevo, en **JDK** elige el **25** que instalaste en el
   apartado 2. Si no aparece, *Add JDK* y señala la carpeta donde se instaló
   (normalmente `C:\Program Files\Eclipse Adoptium\jdk-25...`).
4. Los ficheros del proyecto viven dentro de la carpeta del proyecto: mira en el
   panel de la izquierda dónde está tu fichero `.java` antes de buscarlo desde la
   consola.

---

## 5. Comprobación final: todo funciona junto

Este paso lo haremos en cuanto hagamos nuestro primer código.

### Si no sale

| Lo que dice la consola | Qué pasa y qué hacer |
|---|---|
| `'java' no se reconoce...` | El PATH. Vuelve al apartado 2 y abre una consola nueva |
| `error: file not found: NombreDelFichero.java` | La consola está en otra carpeta. Escribe `pwd` y `dir`: si no ves tu fichero listado, no estás donde crees. `cd` hasta la carpeta correcta |
| `error: file not found: ...` **y en `dir` aparece con `.txt` al final** | Se guardó con la extensión mal. Cámbiale el nombre desde el Explorador |
| `class file has wrong version` o un error sobre el punto de entrada del programa | Estás usando una versión de Java anterior a la 25. Comprueba con `java --version` |

Cualquier otro resultado inesperado (acentos raros, comportamiento del código,
etc.) no es un problema de instalación: se resuelve en clase, con los apuntes de
Programación o de Contornos.

---

## 6. Lista de comprobación

Antes de decir que tienes el entorno listo, comprueba las seis:

- [ ] El Explorador me enseña las extensiones de los ficheros.
- [ ] `java --version` contesta **25**.
- [ ] `javac --version` contesta **25**.
- [ ] Tengo mi carpeta `Documents\dam` y sé cómo abrir una consola dentro de ella.
- [ ] `pwd` y `dir` me enseñan mi carpeta y mis ficheros.
- [ ] He guardado el fichero de prueba en texto plano, en UTF-8 y con el nombre y
      la extensión correctos.
- [ ] Al ejecutarlo con `java NombreDelFichero.java`, aparece el resultado
      esperado en pantalla.

Si alguna falla, es mejor resolverla ahora: sin esto no podrás hacer los próximos ejercicios.
