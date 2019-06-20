import javax.naming.SizeLimitExceededException;
import java.util.ArrayList;
import java.util.Objects;

public class Cidade {
    String nome;
    String dimensao;
    ArrayList<Cidade> cidadesFronteiraList;
    ArrayList<Aeroporto> aeroportoArrayList;

    public Cidade(String nome, String dimensao) {
        this.nome = nome;
        this.dimensao = dimensao;
        this.cidadesFronteiraList = new ArrayList<>();
        this.aeroportoArrayList = new ArrayList<>();
    }

    public int voosData(String data){
        int count = 0;
        for (Aeroporto aeroporto : getAeroportoArrayList()){
            for (Voôs voôs : aeroporto.getVoôsArrayList()){
                if (voôs.getDataPartida().equals(data)){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isFronteira(Cidade cidade) {
        return cidadesFronteiraList.contains(cidade);
    }

    public ArrayList<Cidade> showFronteirasEmComum(Cidade cidade) throws SizeLimitExceededException {
        ArrayList<Cidade> arrayList = new ArrayList<>();
        for (Cidade cidadeF : getCidadesFronteiraList()) {
            if (cidade.getCidadesFronteiraList().contains(cidadeF)) {
                if (arrayList.size() <= 40) {
                    arrayList.add(cidadeF);
                }else throw new SizeLimitExceededException();
            }
        }
        return arrayList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cidade)) return false;
        Cidade cidade = (Cidade) o;
        return getNome().equals(cidade.getNome())
                && getDimensao().equals(cidade.getDimensao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getDimensao());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDimensao() {
        return dimensao;
    }

    public void setDimensao(String dimensao) {
        this.dimensao = dimensao;
    }

    public ArrayList<Cidade> getCidadesFronteiraList() {
        return cidadesFronteiraList;
    }

    public ArrayList<Aeroporto> getAeroportoArrayList() {
        return aeroportoArrayList;
    }
}
