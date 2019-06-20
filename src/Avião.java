public class Avião extends Aeronave {
    private int numeroAssentos;
    private String empresaNome;

    public Avião(String prefixo, String modelNome, String fabricanteNome, int numeroAssentos,
                 String empresaNome) {
        super(prefixo, modelNome, fabricanteNome);
        this.numeroAssentos = numeroAssentos;
        this.empresaNome = empresaNome;
    }

    public int getNumeroAssentos() {
        return numeroAssentos;
    }

    public void setNumeroAssentos(int numeroAssentos) {
        this.numeroAssentos = numeroAssentos;
    }

    public String getEmpresaNome() {
        return empresaNome;
    }

    public void setEmpresaNome(String empresaNome) {
        this.empresaNome = empresaNome;
    }
}
