# Protocolo de uso profesional de IA · 1º DAM

**Programación (MP0485) y Contornos de desenvolvemento (MP0487)**



La IA se puede usar como ayuda. **No sustituye la comprobación ni la
responsabilidad de quien entrega.** Un resultado que parece correcto no es una
evidencia: hay que entenderlo, ejecutarlo y tratar de demostrar que es falso.

---

## Esta semana · la versión de arranque

**El ciclo completo de abajo usa herramientas que todavía no se han visto** —`diff`,
commits, dependencias—. Git llega en CO4. Así que **en PR1 y CO1 se aplica esta
versión reducida**, y nadie tiene que inventarse un commit ni una prueba que no sabe
hacer.

Cuatro palabras, primero:

| | |
|---|---|
| **Prompt** | Lo que le escribes a la herramienta. Tu pregunta, con su contexto |
| **Resultado esperado** | Lo que tendría que salir si la respuesta es buena. Se escribe **antes** de preguntar |
| **Dato personal** | Cualquier cosa que identifique a alguien: nombres reales, correos, teléfonos, matrícula, notas |
| **Credencial** | Una contraseña, una clave o un código de acceso. Nunca se pega en ningún sitio |

Y el ciclo de esta semana, entero:

1. **Antes de preguntar**, escribe una línea: qué quieres que haga tu programa y qué
   tendría que salir por pantalla.
2. **Pregunta sin pegar nada privado**: ni datos personales tuyos o de otros, ni el
   enunciado completo de una práctica, ni nada que te haya dado el profesor marcado
   como material de clase. Con las tres o cuatro líneas de tu programa y el mensaje
   de error, basta.
3. **Guarda tu versión antes de cambiar nada.** Copia tu fichero a otro con otro
   nombre —`E13Ficha_antes.java`— y trabaja sobre el original. Comparar **el de
   antes y el de después**, abiertos uno al lado del otro, es la versión de esta
   semana de «revisar el `diff`».
4. **Ejecútalo**, con el caso que escribiste en el punto 1.
5. **Anótalo en `BITACORA_PROMPTS.md`.**

Un ejemplo completo, con el E1.3 de PR1:

```markdown
## E1.3 · 16/09

**Qué quería:** que preguntase nombre, clase y arma y luego los escribiera
en tres líneas. Esperaba ver las tres preguntas primero y las tres líneas después.

**Qué pasaba:** salía la primera pregunta y luego "Personaje: null".

**Qué pregunté:** pegué mis 6 líneas y el mensaje. Pregunté por qué salía null.
No pegué mi nombre ni el enunciado de la hoja.

**Qué me dijo:** que no estaba guardando lo que devuelve IO.readln en una caja.

**Qué hice:** lo comparé con mi E13Ficha_antes.java. Acepté el cambio en las
tres líneas y no toqué el resto, que ya iba bien.

**Qué ejecuté:** java E13Ficha.java, con "Nel / mago / bastón".
Salieron las tres preguntas y luego las tres líneas. Correcto.

**Qué no entiendo todavía:** por qué ponía "null" y no una línea vacía.
```

---

### Contraejemplo: E1.3 mal hecho

Este es el mismo ejercicio, pero sin seguir el protocolo. Mira qué falla en cada paso:

```markdown
## E1.3 · 16/09

**Qué pregunté:** Pegué el enunciado completo de la hoja de PR1, mi nombre (Nel García),
mi clase (1º DAM A) y el código entero de mi fichero. Pregunté: «¿Por qué no funciona?»

**Qué me dijo:** Me propuso reescribir las tres líneas de input usando variables locales.

**Qué hice:** Copié y pegué la solución tal cual. Parecía que sabía lo que hacía.

**Resultado:** Entregué sin probar. Supongo que ahora funciona.

**Lo que falta:** No escribí qué esperaba ver. No comparé antes y después. No lo ejecuté.
Y pegué datos personales (mi nombre, mi clase) y el enunciado completo (que es privado).
```

**¿Qué pasó mal aquí?**

1. ❌ **No escribió el resultado esperado antes.** No hay línea 1 del ciclo.
2. ❌ **Pegó todo:** el enunciado privado, datos personales (nombre y clase), código completo.
3. ❌ **No comparó antes y después.** Aceptó la sugerencia sin revisarla.
4. ❌ **No ejecutó.** «Supongo que ahora funciona» no es una prueba.
5. ❌ **La bitácora está vacía.** No declaró el proceso.

**Esta entrega no se acepta.** El protocolo requiere los cinco pasos. Si una vez hayas
hecho esto bien, otros ejercicios del mismo tipo van más rápido; si lo haces así, no
aprendes a verificar y el siguiente ejercicio vuelve a ser sorpresa.

---

**Si no has usado IA**, la entrada es una línea: *«No he usado IA en esta entrega.»*
Eso vale y no resta nada. **No hace falta tener cuenta en ninguna herramienta**: lo
que se pide es declarar el proceso, no usar una.

Lo que se evalúa aquí es **haber escrito el resultado esperado antes y haberlo
ejecutado después**, no la longitud del prompt.

---

## El ciclo completo · a partir de CO4

A partir de que haya repositorio, la versión de arranque se sustituye por esta.

### 1 · Define antes de preguntar

Escribe, como mínimo:

- qué debería ocurrir;
- un ejemplo que debería funcionar;
- un ejemplo que debería rechazarse o fallar.

Si hay un error, copia el mensaje completo y anota cómo se reproduce. «No
funciona» no describe un problema que otra persona pueda comprobar.

### 2 · Comparte solo el contexto necesario

Nunca pegues:

- contraseñas, tokens, claves, ficheros `.env` o datos personales;
- enunciados privados, correctores, soluciones o material de examen;
- un repositorio entero si bastan diez líneas y el mensaje de error.

Sustituye cualquier dato real por uno ficticio. Indica la versión y el entorno:
en estos módulos, **Java 25**, IntelliJ y las restricciones concretas de la tarea.

### 3 · Pide ayuda concreta

Es mejor pedir una explicación, alternativas, un contraejemplo o casos de prueba
que pedir «hazme el ejercicio». Una respuesta útil debe poder comprobarse.

### 4 · Revisa lo que propone

Lee el cambio línea por línea y mira el `diff`. No instales una dependencia ni
ejecutes una orden que no entiendas. Si la respuesta afirma algo sobre Java, una
API o una versión, compruébalo en la documentación correspondiente o con un
programa mínimo.

### 5 · Decide y prueba

Acepta, modifica o rechaza la propuesta y explica por qué. Ejecuta el caso que
definiste al principio y, al menos, un caso que debería fallar. Que compile o que
una prueba salga verde **no demuestra que el programa sea correcto**.

### 6 · Guarda solo lo comprobado

Haz commit únicamente del cambio que entiendes y que has ejecutado. La bitácora
referencia el fichero, el `diff` o el commit y las pruebas reales. Una salida
inventada o no ejecutada no cuenta como evidencia.

---

## Qué se anota en `BITACORA_PROMPTS.md`

Por cada consulta relevante, o grupo de repreguntas sobre el mismo problema:

1. objetivo y resultado esperado;
2. contexto compartido y qué se dejó fuera;
3. petición exacta y resumen de la respuesta;
4. qué se aceptó, modificó o rechazó, y por qué;
5. fichero, `diff` o commit revisado;
6. prueba ejecutada y resultado real;
7. qué parte sigue sin entenderse.

Si no se usó IA, se escribe «No he usado IA en esta entrega». La obligación es
declarar el proceso, no usar una herramienta concreta.

---

## Puntos de control durante el curso

| Momento | Qué se practica |
|---|---|
| **PR1 · inicio** | La versión de arranque: resultado esperado, qué no se comparte, comparar antes y después, ejecutar y anotar |
| **CO4 · Git** | Leer un `diff` antes de aceptar cambios y hacer commit solo de lo comprobado |
| **CO5 · depuración** | Reproducir el fallo, fijar el resultado esperado y contrastar una hipótesis |
| **CO7 · pruebas** | Diseñar casos que puedan desmentir una respuesta aparentemente correcta |
| **CO8 · refactorización** | Separar el cambio propuesto en pasos pequeños y aceptar, modificar o rechazar cada uno |
| **PR12 a PR16 · datos y persistencia** | Contexto mínimo, datos ficticios, versiones y comprobación documental |

No son tareas nuevas ni tienen un porcentaje propio. Se practican dentro de las
actividades que ya existen. Se evalúa la evidencia de verificación, no la longitud
del prompt ni el hecho de haber usado IA.

---

## La prueba final

Hay una pregunta que resuelve casi todas las dudas:

> **¿Podrías defender este cambio, señalar cómo lo comprobaste y modificarlo sin
> volver a preguntar?**

Si la respuesta es no, todavía no está listo para entregarse.
