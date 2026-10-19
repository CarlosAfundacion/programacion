# PR3 · Desafíos para aprender a decidir

**Programación · 1.º DAM · Práctica autónoma de refuerzo**  
**Contenidos:** `if`, `else if`, `else`, comparación y normalización de textos, `switch` como expresión, condiciones compuestas, cortocircuito y operador ternario.

## Cómo trabajar

1. Antes de programar, escribe qué datos entran, qué resultados pueden salir y en qué orden comprobarás las condiciones.
2. Predice el resultado de los casos de prueba sin ejecutar el programa.
3. Programa y compara la salida real con la esperada.
4. Si algo falla, anota qué condición era incorrecta y cómo la has cambiado.

Puedes consultar los apuntes. Si recibes una pista, vuelve a resolver esa parte sin mirarla y explica por qué funciona.

### Reglas comunes

- Usa el estilo de Java visto en clase: `void main()`, `IO.readln` e `IO.println`.
- Cada programa resuelve **un único caso por ejecución**. No uses bucles, arrays, clases propias ni `try/catch`.
- Puedes suponer que, cuando se pide un número, el usuario escribe un entero que cabe en `int`. Sí debes comprobar los rangos que indique cada ejercicio.
- Los datos decimales de estos problemas se calculan; no es necesario pedírselos al usuario.
- Normaliza las entradas de texto con `.trim().toLowerCase()`. Compara textos con `.equals()`, no con `==`.
- En las tablas, `""` significa pulsar Intro sin escribir nada. Los textos entre comillas muestran los espacios que también debes probar.
- Usa llaves en los bloques. No añadas un punto y coma inmediatamente después de un `if`.
- Los mensajes para pedir datos son libres; las líneas de resultado deben respetar el formato indicado. Los códigos de salida no llevan tildes para facilitar la comparación.
- Las recomendaciones de estructura de cada ejercicio forman parte del desafío.

---

## 1. ¿Cabe la descarga?

**Fichero:** `E01Descarga.java`  
**Practicas:** `if/else`, igualdad en el límite y diferencia entre dos valores.

Un dispositivo tiene una cantidad de espacio libre y quiere descargar un fichero.

**Entrada:** espacio libre en MB y tamaño del fichero en MB. En este ejercicio ambos están garantizados como enteros entre 0 y 10000.

**Reglas:**

- Si el fichero cabe, muestra `CABE` y `LIBRE=n`, con el espacio que quedará.
- Si no cabe, muestra `NO_CABE` y `FALTAN=n`, con los MB adicionales necesarios.
- Un fichero que ocupa exactamente todo el espacio **sí cabe**.

Usa un `if/else`.

| Espacio | Fichero | Salida esperada, líneas separadas por `/` |
|---:|---:|---|
| 1000 | 250 | `CABE / LIBRE=750` |
| 250 | 250 | `CABE / LIBRE=0` |
| 249 | 250 | `NO_CABE / FALTAN=1` |
| 0 | 0 | `CABE / LIBRE=0` |


## 2. El sensor de la nevera

**Fichero:** `E02Sensor.java`  
**Practicas:** cadenas de `else if`, intervalos y prioridad de la validación.

**Entrada:** temperatura entera.

**Reglas, en este orden:**

1. Si la temperatura es menor que −30 o mayor que 50: `SENSOR_INVALIDO`. Los valores −30 y 50 sí son válidos.
2. Dentro del intervalo válido, menos de 0: `CONGELACION`.
3. De 0 a 5, ambos incluidos: `CORRECTA`.
4. Más de 5 y hasta 10 incluido: `AVISO`.
5. Más de 10: `ALARMA`.

Muestra exactamente un resultado. Resuelve con una cadena `if / else if / else`.

| Entrada | Resultado |
|---:|---|
| −31 | `SENSOR_INVALIDO` |
| −30 | `CONGELACION` |
| 0 | `CORRECTA` |
| 5 | `CORRECTA` |
| 6 | `AVISO` |
| 10 | `AVISO` |
| 11 | `ALARMA` |
| 51 | `SENSOR_INVALIDO` |

## 3. La consigna de la estación

**Fichero:** `E03Consigna.java`  
**Practicas:** `switch` como expresión, valor por defecto y validación combinada.

Una consigna cobra por tamaño y día completo contratado.

**Entrada:** tamaño (`pequena`, `mediana` o `grande`) y días, de 1 a 7. Escribe `pequena` sin ñ como código de entrada.

- Precio diario: pequeña, 3 €; mediana, 5 €; grande, 8 €.
- Normaliza el tamaño y usa un **`switch` como expresión** para obtener el precio diario. Para un tamaño desconocido, obtén un valor marcador de `-1`.
- Si el tamaño es desconocido o los días están fuera de rango, muestra solo `DATOS_INVALIDOS`.
- En los demás casos muestra `TOTAL=n`, en euros enteros.

| Tamaño | Días | Resultado |
|---|---:|---|
| `pequena` | 1 | `TOTAL=3` |
| `" MEDIANA "` | 3 | `TOTAL=15` |
| `grande` | 7 | `TOTAL=56` |
| `grande` | 0 | `DATOS_INVALIDOS` |
| `enorme` | 2 | `DATOS_INVALIDOS` |
| `pequena` | 8 | `DATOS_INVALIDOS` |

## 4. La puerta del laboratorio

**Fichero:** `E04Acceso.java`  
**Practicas:** `&&`, `||`, paréntesis y prioridad entre motivos de denegación.

**Entrada:** cuatro textos, todos garantizados como `si` o `no` tras normalizar: tiene tarjeta, tiene autorización temporal, va acompañado y está bloqueado.

**Reglas:**

- Una persona bloqueada recibe siempre `ACCESO_BLOQUEADO`.
- Si no está bloqueada, puede entrar si tiene tarjeta **o** si tiene autorización temporal **y** va acompañada.
- Si cumple la condición anterior: `ACCESO_PERMITIDO`; si no: `ACCESO_DENEGADO`.

Construye una condición compuesta para el permiso. No enumeres todas las combinaciones posibles.

| Tarjeta | Autorización | Acompañado | Bloqueado | Resultado |
|---|---|---|---|---|
| si | no | no | no | `ACCESO_PERMITIDO` |
| no | si | si | no | `ACCESO_PERMITIDO` |
| no | si | no | no | `ACCESO_DENEGADO` |
| no | no | si | no | `ACCESO_DENEGADO` |
| si | si | si | si | `ACCESO_BLOQUEADO` |


## 5. La batería no siempre tiene capacidad 100

**Fichero:** `E05Bateria.java`  
**Practicas:** umbrales calculados, división decimal y ternario simple.

**Entrada:** carga actual y capacidad máxima, enteros de 0 a 10000. Además de ese rango, valida que la capacidad sea mayor que cero y la carga no la supere.

- Si los datos no son válidos, muestra solo `DATOS_INVALIDOS`.
- Calcula el porcentaje conservando los decimales.
- Menos del 20 %: `ESTADO=CRITICA`.
- Desde el 20 % y por debajo del 50 %: `ESTADO=BAJA`.
- Desde el 50 % hasta el 100 %: `ESTADO=SUFICIENTE`.
- En una segunda línea, usa un **ternario simple** para mostrar `CARGAR=SI` si la carga no está completa o `CARGAR=NO` si lo está.

No redondees el porcentaje antes de clasificar.

| Carga | Capacidad | Resultado |
|---:|---:|---|
| 0 | 5 | `ESTADO=CRITICA / CARGAR=SI` |
| 1 | 5 | `ESTADO=BAJA / CARGAR=SI` |
| 2 | 5 | `ESTADO=BAJA / CARGAR=SI` |
| 3 | 5 | `ESTADO=SUFICIENTE / CARGAR=SI` |
| 5 | 5 | `ESTADO=SUFICIENTE / CARGAR=NO` |
| 1 | 0 | `DATOS_INVALIDOS` |
| 6 | 5 | `DATOS_INVALIDOS` |

## 6. ¿Qué descuento se aplica?

**Fichero:** `E06Descuentos.java`  
**Practicas:** decisiones sucesivas, descuentos excluyentes y orden de los cálculos.

**Entrada:** importe entero de la compra, entre 1 y 1000 euros; si es socio (`si`/`no`, garantizado); y cupón (texto libre).

**Reglas:**

- Importe fuera de rango: muestra solo `DATOS_INVALIDOS`.
- Ser socio da derecho al 10 % de descuento.
- El cupón normalizado `ahorro15` da derecho al 15 %, pero solo para compras de al menos 100 € **antes de descuentos**. Otro texto o texto vacío no da descuento por cupón.
- Los descuentos **no se suman**: se aplica el mayor de los disponibles. Sin ninguno, 0 %.
- El envío cuesta 5 €, salvo que el importe **después del descuento** sea al menos 80 €; en ese caso es gratuito.
- Muestra `DESCUENTO=n`, `ENVIO=n` y `TOTAL=n.nn`, este último con dos decimales. Se admite coma o punto decimal según la configuración.

| Compra | Socio | Cupón | Descuento | Envío | Total |
|---:|---|---|---:|---:|---:|
| 100 | si | ahorro15 | 15 | 0 | 85,00 |
| 100 | si | otro | 10 | 0 | 90,00 |
| 80 | si | `""` | 10 | 5 | 77,00 |
| 80 | no | `""` | 0 | 0 | 80,00 |
| 99 | no | ahorro15 | 0 | 0 | 99,00 |
| 0 | si | ahorro15 | — | — | `DATOS_INVALIDOS` |

## Comprobación final del aprendizaje

Al acabar, elige tres programas e intenta:

- Explicar el orden de las condiciones sin leer los apuntes.
- Predecir una salida nueva antes de ejecutar.
- Cambiar un umbral o una regla e identificar qué pruebas deben cambiar.
- Mostrar un caso que detectaría una solución aparentemente correcta pero equivocada.

El objetivo no es completar los ficheros rápidamente: es poder justificar por qué cada entrada sigue un camino concreto en el programa.
