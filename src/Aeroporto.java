import java.util.ArrayList;
import java.util.Objects;

public class Aeroporto {
    private String aeroportoCodigo;
    private String aeroportoNome;
    private Boolean isInternacional;
    private ArrayList<Aeroporto> aeroportoArrayList;
    private ArrayList<Aeronave> aeronavesPresentesList;
    private ArrayList<Aeroporto> aeroportoRotas;
    private Cidade cidade;
    private ArrayList<Voôs> voôsArrayList;


    public Aeroporto(String aeroportoCodigo, String aeroportoNome, Cidade cidade) {
        this.aeroportoCodigo = aeroportoCodigo;
        this.aeroportoNome = aeroportoNome;
        this.cidade = cidade;
        this.voôsArrayList = new ArrayList<>();
        this.aeronavesPresentesList = new ArrayList<>();
        this.aeroportoRotas = new ArrayList<>();
    }

    public Aeroporto() {
        this.aeroportoArrayList = new ArrayList<>();
    }

    public ArrayList<Voôs> getVoôsArrayList() {
        return voôsArrayList;
    }

    public void addAeroportoArrayList(Aeroporto aeroporto) {
        getAeroportoArrayList().add(aeroporto);
    }

    public void setAeroportoArrayList(ArrayList<Aeroporto> aeroportoArrayList) {
        this.aeroportoArrayList = aeroportoArrayList;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public ArrayList<Aeroporto> getAeroportoRotas() {
        return aeroportoRotas;
    }

    public void addAeroportoRotas(Aeroporto aeroporto) {
        if (aeroporto.getAeroportoRotas().size() <= 100
                && getAeroportoRotas().size() <= 100) {
            getAeroportoRotas().add(aeroporto);
        }else new Exception().printStackTrace();
    }

    public void setAeroportoRotas(ArrayList<Aeroporto> aeroportoRotas) {
        this.aeroportoRotas = aeroportoRotas;
    }

    public void addAeronavesPresentesList(Aeronave aeronave) {
        if (getAeronavesPresentesList().size() <= 100) {
            getAeronavesPresentesList().add(aeronave);
        }
    }

    public ArrayList<Aeronave> getAeronavesPresentesList() {
        return aeronavesPresentesList;
    }

    public void setAeronavesPresentesList(ArrayList<Aeronave> aeronavesPresentesList) {
        this.aeronavesPresentesList = aeronavesPresentesList;
    }

    public Boolean getInternacional() {
        return isInternacional;
    }

    public void setInternacional(Boolean internacional) {
        isInternacional = internacional;
    }

    public ArrayList<Aeroporto> getAeroportoArrayList() {
        return aeroportoArrayList;
    }

    public String getAeroportoCodigo() {
        return aeroportoCodigo;
    }

    public void setAeroportoCodigo(String aeroportoCodigo) {
        this.aeroportoCodigo = aeroportoCodigo;
    }

    public String getAeroportoNome() {
        return aeroportoNome;
    }

    public void setAeroportoNome(String aeroportoNome) {
        this.aeroportoNome = aeroportoNome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aeroporto)) return false;
        Aeroporto aeroporto = (Aeroporto) o;
        return getAeroportoCodigo().equals(aeroporto.getAeroportoCodigo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAeroportoCodigo());
    }

    public boolean isAeronaveHere(String aeronavePrefixo) {
        boolean achou = false;
        for (Aeronave aeronave1 : getAeronavesPresentesList()) {
            if (aeronave1.getPrefixo().equals(aeronavePrefixo)) {
                achou = true;
            }
        }
        return achou;
    }

    public boolean possuiRota(Aeroporto aeroporto) {
        boolean isDisponivel = false;
        for (Aeroporto aeroporto1 : getAeroportoRotas()) {
            if (aeroporto1 == aeroporto) {
                isDisponivel = true;
            }
        }
        if (!isDisponivel) {
            isDisponivel = checkOutraRota(aeroporto);
        }
        return isDisponivel;
    }

    public boolean checkOutraRota(Aeroporto aeroporto) {
        boolean isDisponivel = false;
        for (Aeroporto aeroporto1 : getAeroportoRotas()) {
            for (Aeroporto aeroporto2 : aeroporto1.getAeroportoRotas()) {
                if (aeroporto2 == aeroporto) {
                    isDisponivel = true;
                }
            }
        }

        return isDisponivel;
    }

    public String showNome(String aeroportoCodigo) {
        String s = null;
        for (Aeroporto aeroporto : getAeroportoArrayList()) {
            if (aeroporto.getAeroportoCodigo().equals(aeroportoCodigo)) {
                s = aeroporto.getAeroportoNome();
            }
        }
        return s;
    }
}


