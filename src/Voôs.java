import java.util.ArrayList;

public class Voôs {
    private String numero;
    private String dataPartida;
    private String horaPartida;
    private String horaChegada;
    private String vagas;
    private Aeroporto aeroportoDestino;
    private Aeroporto aeroportoOrigem;
    private Aeronave aeronave;
    private ArrayList<Voôs> allVoosList;
    private ArrayList<Voôs> voosDoDia;

    public Voôs(String numero, String dataPartida, String horaPartida, String horaChegada, String vagas,
                Aeroporto aeroportoDestino, Aeroporto aeroportoOrigem, Aeronave aeronave) {
        this.numero = numero;
        this.dataPartida = dataPartida;
        this.horaPartida = horaPartida;
        this.horaChegada = horaChegada;
        this.vagas = vagas;
        this.aeroportoDestino = aeroportoDestino;
        this.aeroportoOrigem = aeroportoOrigem;
        this.aeronave = aeronave;
    }

    public Voôs() {
        allVoosList = new ArrayList<>();
        voosDoDia = new ArrayList<>();
    }

    public String showDadosDoVoo(String numeroVoo) {
        String s = null;
        for (Voôs voôs : getAllVoosList()) {
            if (voôs.getNumero().equals(numeroVoo)) {
                s = voôs.toString();
            }
        }
        return s;
    }

    @Override
    public String toString() {
        return "Vagas: " + getVagas() + "\n" +
                "Data partida: " + getDataPartida() + "\n" +
                "Horario partida: " + getHoraPartida() + "\n" +
                "Horario chegada: " + getHoraChegada() + "\n" +
                "Origem: " + getAeroportoOrigem().getAeroportoCodigo() + "\n" +
                "Destino: " + getAeroportoDestino().getAeroportoCodigo();
    }

    public void editVoosFromVoosList(Voôs voôs) {
        setNumero(voôs.getNumero());
        setDataPartida(voôs.getDataPartida());
        setHoraPartida(voôs.getHoraPartida());
        setHoraChegada(voôs.getHoraChegada());
        setVagas(voôs.getVagas());
        setAeroportoDestino(voôs.getAeroportoDestino());
        setAeroportoOrigem(voôs.getAeroportoOrigem());
        setAeronave(voôs.getAeronave());
    }

    public boolean removeVoosFromVoosList(Voôs voôs) {
        try {
            getAllVoosList().remove(voôs);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addVoosToList(Voôs voo) {
        try {
            getAllVoosList().add(voo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isAviaoAvoado(Aeronave aeronave) {
        boolean isVoosDeAviao = false;
        for (Voôs voôs : getVoosDoDia()) {
            if (voôs.getAeronave() == aeronave) {
                isVoosDeAviao = true;
            }
        }
        return isVoosDeAviao;
    }

    public ArrayList<Voôs> getVoosDoDia() {
        return voosDoDia;
    }

    public void setVoosDoDia(ArrayList<Voôs> voosDoDia) {
        this.voosDoDia = voosDoDia;
    }

    public ArrayList<Voôs> getAllVoosList() {
        return allVoosList;
    }

    public void setAllVoosList(ArrayList<Voôs> voôs) {
        this.allVoosList = voôs;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public Aeroporto getAeroportoOrigem() {
        return aeroportoOrigem;
    }

    public void setAeroportoOrigem(Aeroporto aeroportoOrigem) {
        this.aeroportoOrigem = aeroportoOrigem;
    }

    public Aeroporto getAeroportoDestino() {
        return aeroportoDestino;
    }

    public void setAeroportoDestino(Aeroporto aeroportoDestino) {
        this.aeroportoDestino = aeroportoDestino;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(String dataPartida) {
        this.dataPartida = dataPartida;
    }

    public String getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(String horaPartida) {
        this.horaPartida = horaPartida;
    }

    public String getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(String horaChegada) {
        this.horaChegada = horaChegada;
    }

    public String getVagas() {
        return vagas;
    }

    public void setVagas(String vagas) {
        this.vagas = vagas;
    }
}
