/// E3.5 - Este codigo funciona pero es ilegible. Aplanalo sin cambiar lo que hace.
///
/// Ejercicio "Ahora tu" del apartado 6 de los apuntes. No se entrega y no tiene
/// nota: se comprueba con la tabla de ocho casos que viene en los apuntes.
/// Escribe tu version en un fichero aparte llamado E35Aplanado.java y compara
/// las dos salidas caso por caso.
void main() {
    int vida = Integer.parseInt(IO.readln("Vida: "));
    boolean tienePocion = IO.readln("Tienes pocion (si/no): ").equals("si");

    if (vida > 0) {
        if (vida < 10) {
            if (tienePocion) {
                IO.println("Bebe la pocion ya.");
            } else {
                IO.println("Huye, no aguantas otro golpe.");
            }
        } else {
            if (vida < 25) {
                IO.println("Con cuidado.");
            } else {
                IO.println("Adelante.");
            }
        }
    } else {
        IO.println("Estas muerto.");
    }
}
