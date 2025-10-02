public class Auto extends Vehiculo {
    private final int cantidadPuertas;

    public Auto(String marca, String modelo, int cantidadPuertas) {
        super(marca, modelo);
        this.cantidadPuertas = cantidadPuertas;
    }

    @Override
    public String mostrarInfo() {
        return "Auto { marca='" + getMarca() + "', modelo='" + getModelo() +
                "', puertas=" + cantidadPuertas + " }";
    }
}