# PR2 · Práctica de refuerzo (no puntúa)

---

## R1 — El turno que le toca

En un combate por turnos participan 4 personajes, numerados del 0 al 3. El
turno avanza de uno en uno y, al llegar al final, vuelve a empezar por el 0.

Calcula qué personaje juega el turno que solicites por teclado y si ese
personaje es el número 0. Imprime los dos resultados.

## R2 — El botín repartido

Un grupo de 5 aventureros encuentra un número de monedas de oro solicitado por teclado. Se reparten a partes
iguales; las monedas que sobran se las queda el líder como propina.

Calcula cuántas monedas le tocan a cada uno, cuántas se queda el líder de
propina, y si el reparto fue exacto (sin propina, como valor `boolean`).

## R3 — ¿Está en peligro?

De un personaje, se recogen de teclado sus puntos de vida sobre un máximo de 400, y no lleva
escudo. Se considera «en peligro» cuando le queda menos de la cuarta parte de
la vida máxima **y además** no lleva escudo.

Calcula el umbral de peligro (la cuarta parte de la vida máxima) y el
resultado de «está en peligro» como `boolean`, combinando la comparación con
el operador lógico que toque.

## R4 — Vueltas al circuito

Un corredor da vueltas a un circuito de 350 metros. Introduce el total de metros en total que lleva acumulados, por teclado.

Calcula cuántas vueltas completas ha dado, cuántos metros lleva recorridos de
la vuelta actual (la que todavía no ha terminado), y si en este momento pisa
exactamente la línea de salida (`boolean`).

## R5 — El coste oculto

Subir de nivel cuesta 100 puntos de experiencia por nivel. Introduce por teclado el numero de puntos de experiencia del persoanje.

Escribe el programa: variables con el
tipo adecuado, la constante que hayas decidido, y calcula cuántos niveles
completos puede subir con esos puntos y cuántos puntos le faltan para el
siguiente nivel.


## R6 - Usar char como entero
¿Cómo harías para escribir la palabra `programa` usando sólo los códigos numéricos de char?
Sólo puedes mirar el código de una de las letras que componen la palabra, el resto tienes que deducirlas.
Puedes usar lo siguiente para mostrar cada letra:

```java
char letra = (char) 97;
IO.print(letra);
```
---

## Cómo se entrega

No se entrega. Es práctica de aula, sin commit ni bitácora de prompts.
