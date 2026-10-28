class SistemaLegado {
    public void registrarEmCentavos(int centavos) {
        System.out.println("Legado registrou: " + centavos + " centavos");
    }
}

interface RegistradorPagamento {
    void registrar(double reais);
}

class AdaptadorPagamento implements RegistradorPagamento {
    private final SistemaLegado legado;

    public AdaptadorPagamento(SistemaLegado legado) {
        this.legado = legado;
    }

    public void registrar(double reais) {
        legado.registrarEmCentavos((int) Math.round(reais * 100));
    }
}