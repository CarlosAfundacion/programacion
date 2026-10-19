# PR3 · Decidir

**Programación · 1º DAM · Apuntes**

---

## Al terminar esta unidad vas a saber

- Hacer que tu programa tome caminos distintos según los datos.
- Encadenar varias condiciones y ponerlas en el orden correcto.
- Usar `switch` como expresión cuando comparas una variable contra valores concretos.
- Combinar condiciones con «y», «o» y «no», y saber por qué el orden te protege.
- Aplanar un `if` dentro de otro sin cambiar lo que hace.
- Prever la entrada que no esperabas, que es la que te va a romper el programa.

## Cómo están escritos estos apuntes

Cada apartado tiene tres partes y van en este orden:

| | Qué es | Qué haces tú |
|---|---|---|
| **La idea** | La explicación, con el trozo de código mínimo | Leer |
| **Guiado** | Un programa completo que se monta en clase paso a paso | Teclear, ejecutar y predecir |
| **Ahora tú** | Un ejercicio muy parecido al guiado, con los casos que tiene que pasar | Hacerlo solo y comprobarlo con la tabla |

**Los «Ahora tú» no tienen nota.** Se comprueban con la tabla de casos que va al
lado: si tus salidas coinciden con las de la tabla, está bien. Lo único que se
entrega de esta unidad es el E3.4 del final.

Todo lo que se pide en un «Ahora tú» o en el E3.4 está explicado aquí. Si te falta
algo, no es que tengas que buscarlo: es que estos apuntes tienen un agujero, y
conviene decirlo.

**De dónde viene esto.** `IO.println` e `IO.readln` son de PR1 §§2-4. Los operadores
de comparación, los lógicos (`&&`, `||`, `!`) y la precedencia son de PR2 §4; la
división decimal, de PR2 §5. Se usan aquí sin volver a explicarlos.

---

## 1. El `if`

```java
if (vida <= 0) {
    IO.println("Has caido.");
}
```

Entre paréntesis va una **condición**: algo que vale `true` o `false`. Si vale
`true`, se ejecuta el bloque; si no, se salta.

### Con alternativa

```java
if (vida > 0) {
    IO.println("Sigues en pie.");
} else {
    IO.println("Has caido.");
}
```

Uno de los dos bloques se ejecuta **siempre**. Nunca los dos, nunca ninguno.

### Las llaves, siempre

Java permite escribir esto cuando el bloque es de una sola línea:

```java
if (vida <= 0) IO.println("Has caido.");
```

**En este curso no.** Llaves siempre, y el guiado de abajo enseña por qué.

### Guiado · G1 · la batería

Un programa completo. Se monta por pasos y **se ejecuta después de cada paso**.

**Paso 1.** Leer el dato y escribirlo, nada más:

```java
void main() {
    int bateria = Integer.parseInt(IO.readln("Bateria: "));
    IO.println("He leido: " + bateria);
}
```

Ejecútalo con `0` y con `1`. Si no escribe lo que has teclado, no sigas: el fallo
está aquí y es más fácil de encontrar ahora que al final.

**Paso 2.** Añadir la decisión:

```java
void main() {
    int bateria = Integer.parseInt(IO.readln("Bateria: "));
    if (bateria <= 0) {
        IO.println("Sin bateria");
    } else {
        IO.println("En marcha");
    }
}
```

**Antes de ejecutarlo, escribe en tu cuaderno qué va a salir con `0` y qué con
`1`.** Después ejecútalo. Si has acertado, has entendido el `if`; si no, mira qué
rama se ha llevado tu valor.

| Bateria | Escribe |
|---|---|
| `0` | `Sin bateria` |
| `1` | `En marcha` |
| `-5` | `Sin bateria` |

**Paso 3 · el error provocado.** Quita las llaves y pon dos líneas debajo:

```java
    if (bateria <= 0)
        IO.println("Sin bateria");
        IO.println("Apagando el motor.");
```

Ejecútalo con `30`. Escribe:

```
Apagando el motor.
```

La sangría engaña: solo la primera línea está dentro del `if`. La segunda **se
ejecuta siempre**. Con llaves esto no puede pasar, y por eso la regla no se negocia.

### Ahora tú · AT-if · el saldo

Escribe un programa que lea un saldo y escriba `Disponible` si es positivo y
`Agotado` en cualquier otro caso.

| Saldo | Tiene que escribir |
|---|---|
| `-1` | `Agotado` |
| `0` | `Agotado` |
| `1` | `Disponible` |


---

## 2. El punto y coma asesino

Un `;` justo detrás del `if` **cierra el `if`** con una instrucción vacía. Lo que
viene después entre llaves ya no depende de nada.

### Guiado · G2 · el aviso que no debería salir

**Paso 1.** Teclea esto tal cual, con el `;`:

```java
void main() {
    int bateria = 30;
    if (bateria <= 0);
    {
        IO.println("Sin bateria. Aviso al taller.");
    }
    IO.println("Bateria actual: " + bateria);
}
```

**Antes de ejecutarlo: ¿cuántas líneas va a escribir?** La batería vale 30, así que
la condición es falsa y parece que solo debería salir la última.

**Paso 2.** Ejecútalo. Sale esto:

```
Sin bateria. Aviso al taller.
Bateria actual: 30
```

El aviso sale con la batería a 30. Compila, no da ningún aviso del compilador, y es
de los errores más difíciles de encontrar leyendo el código.

**Paso 3 · repararlo.** Quita el `;` y junta la llave al `if`:

```java
    if (bateria <= 0) {
        IO.println("Sin bateria. Aviso al taller.");
    }
```

Vuelve a ejecutarlo. Ahora escribe solo:

```
Bateria actual: 30
```

> Cuando algo se ejecute que no debería, lo primero que se mira es si hay un `;`
> suelto detrás de un `if`.

### Ahora tú · AT-error · la alerta de temperatura

Te doy este programa. **Está roto**: avisa siempre.

```java
void main() {
    int temperatura = Integer.parseInt(IO.readln("Temperatura: "));
    if (temperatura > 30);
    {
        IO.println("Alerta");
    }
}
```

Repáralo. Cuando esté bien:

| Temperatura | Tiene que escribir |
|---|---|
| `30` | nada |
| `31` | `Alerta` |

Comprueba los dos. Que con `31` salga `Alerta` no demuestra nada por sí solo: el
programa roto también lo hacía.

---

## 3. Encadenar: `else if` y los umbrales

```java
String nivel;
if (carga <= 0) {
    nivel = "vacia";
} else if (carga < 25) {
    nivel = "baja";
} else if (carga < 50) {
    nivel = "media";
} else {
    nivel = "alta";
}
```

Java evalúa las condiciones **en orden, de arriba abajo**, y en cuanto una se
cumple ejecuta su bloque y **se salta todas las demás**.

Por eso en la segunda rama basta con `carga < 25`: si estamos ahí, la primera ya ha
fallado, así que la carga es mayor que 0. No hace falta escribir
`carga > 0 && carga < 25`.

### Guiado · G3 · los niveles de carga

**Paso 1.** Monta solo las dos primeras ramas y ejecútalo con `0` y con `10`.

**Paso 2.** Añade las otras dos. El programa completo:

```java
void main() {
    int carga = Integer.parseInt(IO.readln("Carga: "));
    String nivel;
    if (carga <= 0) {
        nivel = "vacia";
    } else if (carga < 25) {
        nivel = "baja";
    } else if (carga < 50) {
        nivel = "media";
    } else {
        nivel = "alta";
    }
    IO.println("Carga " + nivel);
}
```

**Antes de ejecutar, predice los cinco.** Son los cinco que importan, porque son las
fronteras:

| Carga | Escribe |
|---|---|
| `0` | `Carga vacia` |
| `24` | `Carga baja` |
| `25` | `Carga media` |
| `49` | `Carga media` |
| `50` | `Carga alta` |

**Paso 3 · el error provocado.** Pon la rama más amplia primero:

```java
    if (carga < 50) {
        nivel = "media";
    } else if (carga < 25) {
        nivel = "baja";
    } else if (carga <= 0) {
        nivel = "vacia";
    } else {
        nivel = "alta";
    }
```

Ejecuta los mismos cinco valores. Sale esto:

| Carga | Escribe | Debería |
|---|---|---|
| `0` | `Carga media` | `Carga vacia` |
| `24` | `Carga media` | `Carga baja` |
| `25` | `Carga media` | `Carga media` |
| `49` | `Carga media` | `Carga media` |
| `50` | `Carga alta` | `Carga alta` |

Con `25` y con `49` acierta, así que **probando solo esos dos parecería correcto**.
Las ramas `baja` y `vacia` no se alcanzan nunca, para ningún valor.

> **Regla:** de lo más específico a lo más general. Las condiciones más estrictas,
> primero. Y prueba siempre las fronteras, no un valor cómodo del medio.

### Cuando el umbral no es un número fijo

En G3 los umbrales son 25 y 50 porque la carga va de 0 a 100. Si el máximo lo decide
el usuario, el cuarto y la mitad hay que **calcularlos**, y ahí aparece la trampa de
PR2 §5:

```java
maxima / 4        // division ENTERA: con maxima = 5 da 1, no 1,25
maxima / 4.0      // division decimal: da 1.25
```

Con `maxima = 5`, el cuarto son 1,25. Si comparas contra `maxima / 4` estás
comparando contra 1, y una vida de 1 se te va a la rama equivocada. **En cuanto el
máximo pueda ser impar, la división tiene que ser decimal.** Eso es exactamente lo
que pide el ejercicio siguiente.

### Ahora tú · E3.1 · el estado de la entidad

**Fichero:** `E31Estado.java`

Lee la vida actual y la vida máxima y escribe el estado. Cinco estados, y antes una
comprobación de que los datos tienen sentido.

**Primero valida, después clasifica:**

| Condición | Resultado |
|---|---|
| `maxima` ≤ 0, o `vida` mayor que `maxima` | `Datos invalidos` |
| vida ≤ 0 (con máxima válida) | `derrotado` |
| menos del cuarto de la máxima | `agonizante` |
| menos de la mitad de la máxima | `malherido` |
| menos que la máxima | `tocado` |
| igual a la máxima | `intacto` |

Escribe el resultado con el prefijo `Estado: `, así: `Estado: malherido`.

**Los casos que tiene que pasar.** Los cuatro últimos son los que separan:

| Vida / máxima | Tiene que escribir |
|---|---|
| `0` / `100` | `Estado: derrotado` |
| `5` / `100` | `Estado: agonizante` |
| `25` / `100` | `Estado: malherido` |
| `50` / `100` | `Estado: tocado` |
| `100` / `100` | `Estado: intacto` |
| `1` / `5` | `Estado: agonizante` |
| `2` / `5` | `Estado: malherido` |
| `101` / `100` | `Estado: Datos invalidos` |
| `0` / `0` | `Estado: Datos invalidos` |

Los dos de máxima `5` son los que cazan la división entera. Si te salen
`malherido` y `tocado`, tienes `maxima / 4` donde va `maxima / 4.0`.

El de `0 / 0` es el que caza el orden: si validas **después** de preguntar por la
vida, un `0 / 0` te sale `derrotado` en vez de `Datos invalidos`.

---

## 4. Comparar textos

Esto va **antes** del `switch` a propósito: sin normalizar la entrada, el `switch`
del apartado siguiente falla por motivos que no tienen nada que ver con el `switch`.

```java
if (accion == "atacar") { ... }        // NO funciona
if (accion.equals("atacar")) { ... }   // SI
```

El `==` con textos compara si son **el mismo objeto en memoria**, no si dicen lo
mismo. Por qué es así se explica del todo en PR5; de momento, la regla:

> **Textos con `.equals()`. Números con `==`.**

### Limpiar antes de comparar

El usuario escribe con espacios y con mayúsculas a su aire. Antes de comparar:

```java
String limpia = accion.trim().toLowerCase();
```

`trim` quita los espacios de los extremos y `toLowerCase` pasa todo a minúsculas.
Así `"  AtAcAr  "` se convierte en `"atacar"` y se compara sin sorpresas.

### Guiado · G4 · el menú de la luz

**Paso 1.** Lee la orden y escríbela entre corchetes, para **ver** los espacios:

```java
void main() {
    String orden = IO.readln("Orden (encender/apagar): ");
    IO.println("He leido: [" + orden + "]");
}
```

Ejecútalo y teclea `  ENCENDER  ` con espacios delante y detrás. Sale
`He leido: [  ENCENDER  ]`. Los espacios están ahí, aunque no se vean al teclear.

**Paso 2.** Añade `.trim().toLowerCase()` y vuelve a ejecutar lo mismo. Ahora sale
`He leido: [encender]`.

**Paso 3.** El programa completo:

```java
void main() {
    String orden = IO.readln("Orden (encender/apagar): ").trim().toLowerCase();
    String mensaje;
    if (orden.equals("encender")) {
        mensaje = "Luz encendida.";
    } else if (orden.equals("apagar")) {
        mensaje = "Luz apagada.";
    } else {
        mensaje = "Orden desconocida.";
    }
    IO.println(mensaje);
}
```

| Orden | Escribe |
|---|---|
| `encender` | `Luz encendida.` |
| `apagar` | `Luz apagada.` |
| `  ENCENDER  ` | `Luz encendida.` |
| `bailar` | `Orden desconocida.` |
| (Enter sin escribir nada) | `Orden desconocida.` |

**Paso 4 · el error provocado.** Añade estas dos líneas al final y ejecuta
tecleando `encender`:

```java
    IO.println("Con == da ....: " + (orden == "encender"));
    IO.println("Con equals da : " + orden.equals("encender"));
```

Sale:

```
Con == da ....: false
Con equals da : true
```

**La misma palabra, y `==` dice que no.** Predice qué pasaría si en vez de leerla
la escribieras tú en el código, y pruébalo: cambia el resultado, y esa es la parte
que se explica en PR5. La regla práctica no cambia: para comparar contenido,
`equals`.

### Ahora tú · E3.2 · el menú de acciones

**Fichero:** `E32Menu.java`

Un menú de cuatro acciones con una cadena de `else if`. Normaliza la entrada.

| Acción | Tiene que escribir |
|---|---|
| `atacar` | `Golpeas por 6.` |
| `defender` | `Te cubres.` |
| `pocion` | `Bebes una pocion.` |
| `huir` | `Sales corriendo.` |
| cualquier otra cosa, o nada | `Orden desconocida.` |

Pruébalo además con `  ATACAR  `, con `Defender` y con ` huir`: los tres tienen que
funcionar como los de la tabla. Si no, te falta la normalización.

---

## 5. El `switch` como expresión

Cuando comparas **la misma variable** contra **valores concretos**, el `switch` se
lee mejor que la cadena de `else if`:

```java
String mensaje = switch (orden) {
    case "encender" -> "Luz encendida.";
    case "apagar"   -> "Luz apagada.";
    default         -> "Orden desconocida.";
};
```

Cosas a fijarse:

- La flecha `->`. Es la forma que usamos; si ves `switch` con `case ... :` y `break`
  en código de otros, es la antigua.
- `default` es el «cualquier otra cosa».
- Aquí el `switch` **devuelve un valor** y se guarda en una variable. Fíjate en el
  **punto y coma del final**: hace falta porque toda la construcción es una
  asignación.

### Cuándo cada uno

| Encaja mejor `switch` si… | Encaja mejor `else if` si… |
|---|---|
| Comparas una sola variable | Cada rama mira cosas distintas |
| Contra valores concretos (`"atacar"`, `3`) | Comparas rangos (`vida < 10`) |
| Hay bastantes casos | Hay dos o tres |

**El clasificador de carga del apartado 3 no se escribe con el `switch` que
acabamos de ver**, porque sus ramas son rangos y el `case` que hemos aprendido
compara contra un valor concreto: no existe un `case carga < 25`. Aquí los rangos
se resuelven con `if`. Dicho con precisión: lo que no llega es **esta** forma del
`switch`; el lenguaje tiene construcciones más nuevas para casos así, pero no se dan
en este curso y no hacen falta.

### Guiado · G5 · el mismo menú, con `switch`

**Paso 1.** Copia tu G4 en un fichero nuevo. Vas a transformarlo **conservando las
salidas**: las cinco líneas de la tabla de G4 tienen que seguir saliendo iguales.

**Paso 2.** Sustituye la cadena de `else if` por el `switch`:

```java
void main() {
    String orden = IO.readln("Orden (encender/apagar): ").trim().toLowerCase();
    String mensaje = switch (orden) {
        case "encender" -> "Luz encendida.";
        case "apagar"   -> "Luz apagada.";
        default         -> "Orden desconocida.";
    };
    IO.println(mensaje);
}
```

Ejecuta las cinco entradas de la tabla de G4 y compara. **Si una sola difiere, la
transformación está mal.** La normalización sigue haciendo falta: el `switch`
compara valores concretos, así que `  ENCENDER  ` sin normalizar se va a `default`.

**Paso 3 · el error provocado.** Borra el `;` que cierra la asignación, el que va
después de la llave del `switch`. Intenta ejecutarlo. No llega a arrancar:

```
error: ';' expected
    }
     ^
1 error
```

Este error sí lo caza el compilador, y merece la pena verlo una vez: cuando un
`switch` «no compila» y no entiendes por qué, casi siempre es este `;`.

### Ahora tú · E3.3 · el mismo menú, con `switch`

**Fichero:** `E33Menu.java`

Transforma tu E3.2 a `switch` como expresión. **Mismas entradas y mismas salidas**
que E3.2, incluidas las de espacios y mayúsculas: lo que se compara son dos formas
de escribir lo mismo, no dos programas distintos.

Después escribe **dos líneas** en un comentario al final del fichero: cuál de las
dos versiones se lee mejor y por qué.

Comprueba las dos versiones con las mismas entradas, una al lado de la otra. Si
alguna salida difiere, no has acabado.

---

## 6. Condiciones compuestas, cortocircuito y aplanamiento

Los operadores `&&`, `||` y `!` son de PR2 §4. Aquí se usan para tres cosas nuevas:
agrupar bien, protegerse de un error y deshacer un anidamiento.

### Agrupar con paréntesis

«Pase **o** visita autorizada, **y** nunca bloqueado» se escribe así:

```java
boolean puedePasar = (tienePase || visitaAutorizada) && !bloqueado;
```

Los paréntesis no son decoración. Sin ellos, Java agrupa el `&&` antes que el `||`
(PR2 §4) y la condición significa otra cosa.

### Guiado · G6a · el caso que delata los paréntesis

**Paso 1.** Monta el programa con las dos versiones, la buena y la mala, una al lado
de la otra:

```java
void main() {
    boolean tienePase        = IO.readln("Tiene pase (si/no): ").equals("si");
    boolean visitaAutorizada = IO.readln("Visita autorizada (si/no): ").equals("si");
    boolean bloqueado        = IO.readln("Bloqueado (si/no): ").equals("si");

    boolean bien = (tienePase || visitaAutorizada) && !bloqueado;
    boolean mal  =  tienePase || visitaAutorizada  && !bloqueado;

    IO.println("Con parentesis .: " + (bien ? "pasa" : "no pasa"));
    IO.println("Sin parentesis .: " + (mal  ? "pasa" : "no pasa"));
}
```

**Paso 2.** Pruébalo con `no` / `si` / `no`. Las dos dicen `pasa`. Con este caso **no
se nota la diferencia**, y es justo el problema: la mayoría de los casos no la notan.

**Paso 3.** Ahora `si` / `no` / `si`: tiene pase, pero está bloqueado.

```
Con parentesis .: no pasa
Sin parentesis .: pasa
```

**Antes de ejecutarlo, predice cuál de las dos está mal y por qué.** Sin paréntesis,
`tienePase` por sí solo abre la puerta, y la prohibición de bloqueado se queda
colgando del `||`. Este es el caso que hay que buscar siempre: el que **discrimina**
entre la versión correcta y la incorrecta.

### El cortocircuito

En `a && b`, si `a` es `false`, Java **ni siquiera mira `b`**: ya sabe que el
resultado es `false`. Y en `a || b`, si `a` es `true`, tampoco mira `b`.

Eso permite poner delante una comprobación que **protege** a la de detrás.

### Guiado · G6b · la división protegida

**Paso 1.** El programa:

```java
void main() {
    int divisor = Integer.parseInt(IO.readln("Divisor: "));
    if (divisor != 0 && 12 / divisor > 2) {
        IO.println("12 entre " + divisor + " pasa de 2");
    } else {
        IO.println("No pasa de 2, o el divisor es 0");
    }
}
```

**Antes de ejecutar, predice los tres.** Después pruébalos:

| Divisor | Escribe |
|---|---|
| `0` | `No pasa de 2, o el divisor es 0` |
| `3` | `12 entre 3 pasa de 2` |
| `6` | `No pasa de 2, o el divisor es 0` |

El `6` es interesante: 12 entre 6 son 2, y 2 no «pasa de» 2.

**Paso 2 · el error provocado.** Invierte el orden de las dos partes:

```java
    if (12 / divisor > 2 && divisor != 0) {
```

Vuelve a ejecutar con `0`. El programa **revienta**:

```
Exception in thread "main" java.lang.ArithmeticException: / by zero
```

La comprobación que protege estaba después, y para cuando Java llega a ella ya ha
hecho la división. Con `3` y con `6` sigue funcionando igual, así que probando solo
esos dos no lo verías.

> **La comprobación protectora va siempre la primera.**

### Aplanar: quitar `if` de dentro de `if`

Un `if` dentro de otro dentro de otro funciona, pero no hay quien lo lea. Se aplana
así, y es un procedimiento, no una inspiración:

1. **Dibuja los caminos.** Uno por cada combinación de las condiciones. Anota qué
   sale al final de cada camino.
2. **Escribe una rama por resultado**, con la condición completa de ese camino
   (unida con `&&` si hace falta).
3. **Pon las guardas primero**: el camino que corta antes va arriba.
4. **Prueba las dos versiones** con todas las combinaciones y compara.

### Guiado · G6c · el control de acceso

**Paso 1.** La versión anidada. Dos condiciones, cuatro combinaciones, **tres**
resultados distintos:

```java
void main() {
    boolean bloqueado = IO.readln("Bloqueado (si/no): ").equals("si");
    boolean tienePase = IO.readln("Tiene pase (si/no): ").equals("si");

    if (!bloqueado) {
        if (tienePase) {
            IO.println("Adelante.");
        } else {
            IO.println("Pasa por recepcion.");
        }
    } else {
        IO.println("Acceso bloqueado.");
    }
}
```

**Paso 2 · dibuja los caminos** antes de tocar nada:

| bloqueado | tienePase | Camino | Sale |
|---|---|---|---|
| `no` | `si` | primera rama, dentro | `Adelante.` |
| `no` | `no` | primera rama, dentro el `else` | `Pasa por recepcion.` |
| `si` | `si` | el `else` de fuera | `Acceso bloqueado.` |
| `si` | `no` | el `else` de fuera | `Acceso bloqueado.` |

Dos combinaciones dan el mismo resultado: cuando está bloqueado, el pase da igual.
Eso es lo que permite que la versión plana tenga **tres** ramas y no cuatro.

**Paso 3.** La versión plana, con la guarda primero:

```java
    if (bloqueado) {
        IO.println("Acceso bloqueado.");
    } else if (tienePase) {
        IO.println("Adelante.");
    } else {
        IO.println("Pasa por recepcion.");
    }
```

**Paso 4 · compruébalo.** Ejecuta las dos versiones con las cuatro combinaciones y
compara una por una. Las cuatro tienen que coincidir. Las de arriba coinciden: está
ejecutado.

### Ahora tú · AT-cond · la entrada al recinto

Se entra con **carné o invitación**, pero **nunca** si está sancionado. Escribe el
programa que lo decida y escriba `Puede entrar.` o `No puede entrar.`

| Carné | Invitación | Sancionado | Tiene que escribir |
|---|---|---|---|
| `si` | `no` | `no` | `Puede entrar.` |
| `no` | `si` | `no` | `Puede entrar.` |
| `no` | `no` | `no` | `No puede entrar.` |
| `si` | `no` | `si` | `No puede entrar.` |

El último es el que delata los paréntesis, igual que en G6a. Si te sale
`Puede entrar.`, te faltan.

### Ahora tú · E3.5 · aplanar el laberinto

**Ficheros:** `E35Anidado.java` (te lo doy) y `E35Aplanado.java` (lo escribes tú)

En `recursos/PR3/E35Anidado.java` tienes un programa con `if` dentro de `if` dentro
de `if`. Funciona, pero no hay quien lo lea.

**Escríbelo aplanado en un fichero aparte**, `E35Aplanado.java`, con una cadena de
`else if`, de forma que haga exactamente lo mismo. **No modifiques el original**:
lo necesitas para comparar.

Sigue los cuatro pasos del procedimiento de arriba. Y después, el procedimiento de
comprobación, en este orden:

1. **Predice** la salida de cada caso de la tabla, mirando el original.
2. **Ejecuta el original** y apunta lo que sale de verdad.
3. **Ejecuta tu versión** con el mismo caso.
4. **Registra si coinciden.** Las tres columnas: lo que predijiste, lo que dio el
   original y lo que dio la tuya.

| Vida | Poción | Las dos versiones escriben |
|---|---|---|
| `0` | `no` | `Estas muerto.` |
| `1` | `si` | `Bebe la pocion ya.` |
| `1` | `no` | `Huye, no aguantas otro golpe.` |
| `9` | `si` | `Bebe la pocion ya.` |
| `9` | `no` | `Huye, no aguantas otro golpe.` |
| `10` | `no` | `Con cuidado.` |
| `24` | `si` | `Con cuidado.` |
| `25` | `no` | `Adelante.` |

**Si una sola difiere, no está bien.** «Me parece que hace lo mismo» no es una
comprobación: la comprobación es la tabla rellenada.

Fíjate en `9/si` y `9/no`: son el mismo número de vida y dan resultados distintos.
Esa es la rama que hay que unir con `&&`, y tiene que ir **antes** que la general.

---

## 7. El operador ternario

Para elegir entre dos valores en una sola línea:

```java
int tarifa = abonado ? 2 : 5;
```

Se lee: «¿`abonado`? Entonces `2`, si no `5`».

Es cómodo para asignaciones cortas. **No lo anides**: un ternario dentro de otro es
ilegible y no hay excusa para hacerlo.

### Guiado · G7 · la tarifa

**Paso 1.** Las dos formas, juntas, para ver que hacen lo mismo:

```java
void main() {
    boolean abonado = IO.readln("Abonado (si/no): ").equals("si");

    int conTernario = abonado ? 2 : 5;

    int conIf;
    if (abonado) {
        conIf = 2;
    } else {
        conIf = 5;
    }

    IO.println("Ternario : " + conTernario);
    IO.println("if/else  : " + conIf);
}
```

**Paso 2.** Predice y ejecuta con `si` y con `no`. Las dos líneas tienen que dar el
mismo número siempre:

| Abonado | Ternario | if/else |
|---|---|---|
| `si` | `2` | `2` |
| `no` | `5` | `5` |

**Paso 3 · el error provocado.** Intenta usar el ternario para escribir dos líneas
en vez de para dar un valor:

```java
    abonado ? IO.println("Abonado") : IO.println("Normal");
```

No compila. El ternario **da un valor**, no ejecuta acciones: para eso está el
`if`. Si lo que quieres es hacer dos cosas distintas, usa `if`; si lo que quieres es
elegir entre dos valores, usa el ternario.

### Ahora tú · AT-ternario · las plazas

Lee el número de plazas y escribe `Disponible` si hay más de 0 y `Completo` en
cualquier otro caso. **Con un ternario**, no con `if`.

| Plazas | Tiene que escribir |
|---|---|
| `0` | `Completo` |
| `1` | `Disponible` |

---

## 8. La entrada inesperada, y todo junto

**Tu programa va a recibir cosas que no has previsto.** No es una posibilidad: es
una certeza. El usuario escribe `bailar`, o pulsa Enter sin escribir nada.

### Cuándo hace falta una rama final, y cuándo no

Esto depende de lo que haga el programa, y conviene tenerlo claro:

| Si el programa… | Entonces… |
|---|---|
| Es un **menú que tiene que responder a toda orden** | **Siempre una rama final.** Sin ella se queda mudo y el usuario no sabe si le has entendido o si se ha colgado |
| Solo **avisa cuando pasa algo** (la alerta de temperatura de AT-error) | **No hace falta `else`.** Que no haya alerta es la respuesta correcta cuando no hay nada que avisar |

La pregunta que decide es: *¿hay algo que decir cuando la condición es falsa?* En un
menú, sí: «no te he entendido». En un aviso, no: callar es lo correcto.

### Guiado · G8a · el menú mínimo

```java
void main() {
    String orden = IO.readln("Orden (ayuda/salir): ").trim().toLowerCase();
    String respuesta;
    if (orden.equals("ayuda")) {
        respuesta = "Ordenes: ayuda, salir.";
    } else if (orden.equals("salir")) {
        respuesta = "Hasta luego.";
    } else {
        respuesta = "Orden desconocida.";
    }
    IO.println(respuesta);
}
```

Predice y ejecuta los cinco. El cuarto y el quinto son los que justifican la rama
final:

| Orden | Escribe |
|---|---|
| `ayuda` | `Ordenes: ayuda, salir.` |
| `salir` | `Hasta luego.` |
| `  SALIR ` | `Hasta luego.` |
| `bailar` | `Orden desconocida.` |
| (Enter sin escribir nada) | `Orden desconocida.` |

**El error provocado:** borra el `else` y deja `respuesta` sin valor inicial. No
compila: `variable respuesta might not have been initialized`. Java te obliga a
cubrir todos los caminos cuando el valor se usa después. Esa es otra razón para la
rama final, además de la de cortesía.

### Ahora tú · AT-invalida · el menú de consulta

Un menú de dos órdenes que responda también a lo que no conoce.

| Orden | Tiene que escribir |
|---|---|
| `consultar` | `Consulta` |
| `salir` | `Fin` |
| `bailar` | `Orden desconocida` |
| (Enter sin escribir nada) | `Orden desconocida` |

### Leer y escribir un contrato de salida

Hasta ahora los programas escribían frases. A partir de aquí, algunos escriben un
**contrato de salida**: unas líneas finales con un formato fijo, siempre las mismas
y siempre en el mismo orden, para que se puedan leer sin interpretarlas.

G8 escribe un contrato de tres líneas:

```
Energia ..: 17
Distancia : 3
Estado ...: en marcha
```

Tres cosas que hacen que eso sea un contrato y no una frase:

- **Siempre salen las tres**, pase lo que pase. También cuando la energía es 0.
- **Siempre en el mismo orden.**
- **Siempre con la misma forma**: nombre, separador, valor.

Leer un contrato es sencillo: te dicen las tres líneas, y tú sabes qué valor va en
cada una. Producirlo es lo que cuesta, porque hay que escribirlas **al final**, una
sola vez, en lugar de ir escribiendo mensajes por el camino. El E3.4 pide exactamente
eso, con otras tres líneas.

### Guiado · G8 · el turno del robot

**Fichero de referencia:** `recursos/PR3/Pr3Turno.java`

Un robot con energía y una distancia que recorrer. Es el programa más largo de la
unidad y se monta **en cuatro fases, ejecutando después de cada una**.

**Las reglas:**

- Energía 20, máximo 30. Distancia 8.
- `avanzar` resta 5 de distancia.
- `recargar` suma 8 de energía, sin pasar de 30.
- `reposo` no cambia la distancia.
- Si la distancia queda en 0 o por debajo, **se fija en 0 y no hay desgaste**.
- En cualquier otro caso se gasta energía: **3**, o **1** si la acción es `reposo`.
- Una orden desconocida **no hace nada, pero gasta energía igual**.
- La energía nunca baja de 0.

**Fase 1 · la acción.** Lee la orden, normalízala y aplica solo el cambio de
`avanzar` y de `recargar`. Escribe energía y distancia al final y ejecuta con
`avanzar`: tiene que salir distancia 3 y energía 20, porque todavía no hay desgaste.

**Fase 2 · el objetivo.** Añade el `if (distancia <= 0) { distancia = 0; }`. Ejecuta
con `avanzar`: nada cambia todavía, porque 3 no es ≤ 0. **Predice qué pasaría si la
distancia inicial fuera 5.**

**Fase 3 · el desgaste.** Mete el gasto de energía en el `else` del paso anterior, y
el tope inferior de 0. Ejecuta las cuatro órdenes.

**Fase 4 · el contrato.** Añade el estado con un ternario y las tres líneas finales.

El programa completo:

```java
void main() {
    int energia   = 20;
    int maxima    = 30;
    int distancia = 8;

    String accion = IO.readln("Accion (avanzar/recargar/reposo): ").trim().toLowerCase();

    // Fase 1: la accion.
    if (accion.equals("avanzar")) {
        distancia = distancia - 5;
    } else if (accion.equals("recargar")) {
        energia = energia + 8;
        if (energia > maxima) {
            energia = maxima;
        }
    }

    // Fase 2: el objetivo. Si se ha alcanzado, el turno no desgasta.
    if (distancia <= 0) {
        distancia = 0;
    } else {
        // Fase 3: el desgaste.
        int desgaste = accion.equals("reposo") ? 1 : 3;
        energia = energia - desgaste;
        if (energia < 0) {
            energia = 0;
        }
    }

    // Fase 4: el parte del turno.
    String estado = distancia == 0 ? "objetivo" : "en marcha";
    IO.println("Energia ..: " + energia);
    IO.println("Distancia : " + distancia);
    IO.println("Estado ...: " + estado);
}
```

**Predice las cuatro antes de ejecutarlas:**

| Acción | Energía | Distancia | Estado |
|---|---|---|---|
| `avanzar` | `17` | `3` | `en marcha` |
| `recargar` | `25` | `8` | `en marcha` |
| `reposo` | `19` | `8` | `en marcha` |
| `bailar` | `17` | `8` | `en marcha` |

Fíjate en `bailar`: **gasta los 3 de energía igual que `avanzar`**, aunque no haga
nada. Está así a propósito.

**El error provocado · desgaste después del objetivo.** Cambia la distancia inicial
a `5` y ejecuta `avanzar`:

| Arranque | Acción | Energía | Distancia | Estado |
|---|---|---|---|---|
| energía 20, distancia 5 | `avanzar` | `20` | `0` | `objetivo` |

La energía **no baja**: ha llegado al objetivo y el turno no desgasta. Ahora saca el
gasto de energía del `else` y ponlo suelto, después del `if`. Vuelve a ejecutar: sale
energía `17`. Ese es el fallo, y es de los que no se ven leyendo, solo ejecutando.

**El otro arranque que hay que probar.** Energía inicial `2`, distancia 8:

| Arranque | Acción | Energía | Distancia | Estado |
|---|---|---|---|---|
| energía 2, distancia 8 | `avanzar` | `0` | `3` | `en marcha` |
| energía 2, distancia 8 | `reposo` | `1` | `8` | `en marcha` |

Con `avanzar`, 2 − 3 daría −1. El tope inferior lo deja en `0`. Sin ese tope saldría
energía negativa, que no significa nada.

### Ahora tú · AT-turno · el mismo turno, otro arranque

Coge tu G8 y cambia solo el arranque: **energía 12, distancia 4**. Todas las reglas
siguen igual.

| Acción | Energía | Distancia | Estado |
|---|---|---|---|
| `avanzar` | `12` | `0` | `objetivo` |
| `recargar` | `17` | `4` | `en marcha` |
| `reposo` | `11` | `4` | `en marcha` |
| `bailar` | `9` | `4` | `en marcha` |

Los dos que hay que entender antes de seguir:

- `avanzar` deja la energía en **12**, sin tocar: 4 − 5 da −1, se fija en 0, y el
  objetivo alcanzado se salta el desgaste.
- `recargar` deja **17** y no 20: suma 8 y después gasta los 3 del desgaste, porque
  la distancia sigue siendo 4.

---

## Errores típicos

| Lo que ves | Qué pasa |
|---|---|
| Se ejecuta algo que no debería | Un `;` detrás del `if` |
| Una rama no se alcanza nunca | Las condiciones están en mal orden: de lo general a lo específico |
| `if (x = 5)` | Es una asignación, no una comparación |
| Comparar textos no funciona | `==` en vez de `.equals()` |
| El menú calla ante una entrada rara | Falta la rama final |
| `variable might not have been initialized` | Hay un camino que no le da valor: suele faltar el `else` |
| `/ by zero` en una condición | La comprobación protectora no va la primera |
| La clasificación miente con máximos impares | División entera donde va decimal (PR2 §5) |
| El `switch` no compila | Falta el `;` que cierra la asignación |

---

## Resumen en una página

```java
if (condicion) {
    ...
} else if (otra) {
    ...
} else {
    ...
}

String x = switch (valor) {
    case "a" -> "resultado A";
    default  -> "cualquier otro";
};

String y = condicion ? "si" : "no";
```

| Quiero… | Escribo |
|---|---|
| Comparar textos | `a.equals(b)` |
| Limpiar antes de comparar | `a.trim().toLowerCase()` |
| Que se cumplan las dos | `a && b` |
| Que se cumpla alguna | `a \|\| b` |
| Lo contrario | `!a` |
| Agrupar bien | `(a \|\| b) && !c` |
| Protegerme de un error | `divisor != 0 && 12 / divisor > 2` |
| Dividir sin perder decimales | `maxima / 4.0` |

**Las cinco reglas de oro**

1. **Llaves siempre**, aunque el bloque sea de una línea.
2. **Nunca un `;` detrás del `if`.**
3. De lo más específico a lo más general: **el orden de las ramas importa**, y se
   comprueba con las fronteras.
4. **Un menú siempre tiene rama final.** Un aviso puede no tenerla.
5. Textos con `.equals()`, números con `==`. Y la comprobación protectora, primera.
