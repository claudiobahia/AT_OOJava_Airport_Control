public class Helicopter extends Aeronave {
    private TipoHelicoptero helicopterTipo;

    public Helicopter(String prefixo, String modelNome, String fabricanteNome, TipoHelicoptero helicopterTipo) {
        super(prefixo, modelNome, fabricanteNome);
        this.helicopterTipo = helicopterTipo;
    }

    public TipoHelicoptero getHelicopterTipo() {
        return helicopterTipo;
    }

    public void setHelicopterTipo(TipoHelicoptero helicopterTipo) {
        this.helicopterTipo = helicopterTipo;
    }
}
