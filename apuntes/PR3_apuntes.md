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
