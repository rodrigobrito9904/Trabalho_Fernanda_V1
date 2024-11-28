public enum FrequenciaSemanal {
    TRES_DIAS(3),
    QUATRO_DIAS(4),
    CINCO_DIAS(5);

    private final int dias;

    FrequenciaSemanal(int dias) {
        this.dias = dias;
    }

    public int getDias() {
        return dias;
    }
}