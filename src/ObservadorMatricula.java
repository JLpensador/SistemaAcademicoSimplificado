public interface ObservadorMatricula {
    void atualizar(String mensagem);
}

class AvisoEmail implements ObservadorMatricula {
    public void atualizar(String mensagem) {
        System.out.println("E-mail: " + mensagem);
    }
}

class Auditoria implements ObservadorMatricula {
    public void atualizar(String mensagem) {
        System.out.println("Auditoria: " + mensagem);
    }
}