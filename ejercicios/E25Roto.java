/// E2.5 - Este programa compila y se ejecuta, pero da tres resultados mal.
/// Encuentra los tres fallos de conversion de tipos y arreglalos.
void main() {
    int vidaMaxima = 100;
    int vidaActual = 45;
    int pociones   = 7;
    int heroes     = 2;

    int porcentaje = vidaActual / vidaMaxima * 100;
    IO.println("Vida restante: " + porcentaje + " %");

    int mediaPociones = pociones / heroes;
    IO.println("Pociones por heroe, con decimales: " + mediaPociones);

    double precio = 7 / 2;
    IO.println("Precio con decimales de la pocion: " + precio);
}
