import java.util.ArrayList;

public abstract class Aeronave {
    private String prefixo;
    private String modelNome;
    private String fabricanteNome;
    private ArrayList<Voôs> voôs;

    public Aeronave(String prefixo, String modelNome, String fabricanteNome) {
        this.prefixo = prefixo;
        this.modelNome = modelNome;
        this.fabricanteNome = fabricanteNome;
        this.voôs = new ArrayList<>();
    }

    public ArrayList<Voôs> getVoôs() {
        return voôs;
    }

    public void setVoôs(ArrayList<Voôs> voôs) {
        this.voôs = voôs;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public String getModelNome() {
        return modelNome;
    }

    public void setModelNome(String modelNome) {
        this.modelNome = modelNome;
    }

    public String getFabricanteNome() {
        return fabricanteNome;
    }

    public void setFabricanteNome(String fabricanteNome) {
        this.fabricanteNome = fabricanteNome;
    }

    public void showPrefixo() {
        System.out.println("Prefíxo da aeronave: " + getPrefixo());
    }

    @Override
    public String toString() {
        return "Prefixo: " + getPrefixo() + "\n" +
                "Modelo: " + getModelNome() + "\n" +
                "Fabricante:" + getFabricanteNome();
    }
}
