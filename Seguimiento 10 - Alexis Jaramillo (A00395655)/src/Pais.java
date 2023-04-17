public class Pais implements Comparable<Pais> {

    private final String nombre;
    private final int oro;
    private final int plata;
    private final int bronce;

    public Pais(String nombre, int oro, int plata, int bronce) {
        this.nombre = nombre;
        this.oro = oro;
        this.plata = plata;
        this.bronce = bronce;
    }

    public String getNombre() {
        return nombre;
    }
    public int getTotalMedallas() {
        return oro + plata + bronce;
    }

    @Override
    public int compareTo(Pais otro) {
        if (oro != otro.oro) {
            return otro.oro - oro;
        } else if (plata != otro.plata) {
            return otro.plata - plata;
        } else if (bronce != otro.bronce) {
            return otro.bronce - bronce;
        } else {
            return nombre.compareTo(otro.nombre);
        }
    }

    @Override
    public String toString() {
        return nombre + ": " + oro + " oro(s), " + plata + " plata(s), " + bronce + " bronce(s)";
    }


}
