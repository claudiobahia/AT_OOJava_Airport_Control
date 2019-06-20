public class Main {
    public static void main(String[] args) {
        Aeronave aviOne = new Avião("PR-GGR", "733", "OINGO", 150, "GOLD");
        Aeronave Hellcopter = new Helicopter("AB - CD", "H177", "OINGO", TipoHelicoptero.TaxiAereo);
        Aeronave aviTwo = new Avião("PT-130", "AP-2040", "AIRBUS", 800, "RUBY-BERRY");

        Cidade SP = new Cidade("São Paulo", "4450 Km²");
        Cidade RJ = new Cidade("Rio de Janeiro", "2140 Km²");
        RJ.getCidadesFronteiraList().add(SP);
        SP.getCidadesFronteiraList().add(RJ);

        Aeroporto a = new Aeroporto();
        Aeroporto ConGon = new Aeroporto("CGU", "Congonhas", RJ);
        Aeroporto CaNoaS = new Aeroporto("CDF", "Salgado Filho", SP);
        Aeroporto DisFedAero = new Aeroporto("GDF", "Aeroporto Federal", RJ);
        a.addAeroportoArrayList(ConGon);
        a.addAeroportoArrayList(CaNoaS);
        a.addAeroportoArrayList(DisFedAero);
        ConGon.addAeronavesPresentesList(aviOne);
        ConGon.setInternacional(true);
        CaNoaS.setInternacional(false);
        DisFedAero.setInternacional(false);
        RJ.getAeroportoArrayList().add(ConGon);
        RJ.getAeroportoArrayList().add(DisFedAero);
        SP.getAeroportoArrayList().add(CaNoaS);

        Voôs voo1 = new Voôs("764", "15/06/2019", "08:50:10", "15:43:40", "321", ConGon, CaNoaS, aviOne);
        Voôs voo2 = new Voôs("765", "20/05/2017", "00:37:13", "06:25:07", "725", DisFedAero, CaNoaS, aviTwo);
        Voôs voo3 = new Voôs("770", "TODAY", "06:25:13", "07:29:49", "100", CaNoaS, ConGon, Hellcopter);
        Voôs voôs = new Voôs();
        voôs.addVoosToList(voo1);
        voôs.addVoosToList(voo2);
        voôs.addVoosToList(voo3);
        voôs.getVoosDoDia().add(voo3);
        ConGon.getVoôsArrayList().add(voo1);
        CaNoaS.getVoôsArrayList().add(voo2);
        DisFedAero.getVoôsArrayList().add(voo3);

        System.out.println("Congonhas é Internacional: " + ConGon.getInternacional());
        System.out.println("Salgado Filho é Internacional: " + CaNoaS.getInternacional());

        System.out.println("\nCongonhas é igual a Congonhas? " + ConGon.equals(ConGon));
        System.out.println("Congonhas é igual a Salgado Filho? " + ConGon.equals(CaNoaS));

        System.out.println("\nO aviOne está presente no aeroporno de Congonhas? " + ConGon.isAeronaveHere(aviOne.getPrefixo()));
        System.out.println("O aviTwo está presente no aeroporno de Congonhas? " + ConGon.isAeronaveHere(aviTwo.getPrefixo()));

        ConGon.addAeroportoRotas(CaNoaS);
        System.out.println("\nCongonhas possui rota para Aeroporto Salgado Filho? " + ConGon.possuiRota(CaNoaS));
        System.out.println("Congonhas possui rota para Aeroporto Federal? " + ConGon.possuiRota(DisFedAero));

        System.out.println("\nNome do aeroporto pelo Prefixo: " + a.showNome(CaNoaS.getAeroportoCodigo()));
        System.out.println("Nome do aeroporto pelo Prefixo: " + a.showNome(ConGon.getAeroportoCodigo()));
        System.out.println("Nome do aeroporto pelo Prefixo: " + a.showNome(DisFedAero.getAeroportoCodigo()));

        System.out.println("\nRio de Janeiro na data de 15/06/2019 teve " + RJ.voosData("15/06/2019") + " vôos.");
        System.out.println("São Paulo na data de 20/05/2017 teve " + SP.voosData("20/05/2017") + " vôos.");

        System.out.println("\nRio de Janeiro é igual a São Paulo? " + RJ.equals(SP));
        System.out.println("Rio de Janeiro é igual a Rio de Janeiro? " + RJ.equals(RJ));

        System.out.println("\nRio de Janeiro faz fronteira com São Paulo? " + RJ.isFronteira(SP));
        RJ.getCidadesFronteiraList().remove(SP);
        System.out.println("Rio de Janeiro faz fronteira com São Paulo? " + RJ.isFronteira(SP));

        System.out.println("\nDimensão de SP: " + RJ.getDimensao());
        System.out.println("Dimensão de RJ: " + SP.getDimensao());

        System.out.println("\nDados do voo1: " + voôs.showDadosDoVoo("764"));
        System.out.println("\nDados do voo2: " + voôs.showDadosDoVoo("765"));

        voo1.editVoosFromVoosList(voo2);
        System.out.println("\nEditar Voo1 para igual voo2: " + voo1.toString());

        System.out.println("\nVoo 3 existe? " + voôs.getAllVoosList().contains(voo3));
        voôs.removeVoosFromVoosList(voo3);
        System.out.println("Remove // Voo 3 existe? " + voôs.getAllVoosList().contains(voo3));

        System.out.println("\nO helicoptero está voando no momento: " + voôs.isAviaoAvoado(Hellcopter));
        voôs.getVoosDoDia().remove(voo3);
        System.out.println("Remove // O helicoptero está voando no momento: " + voôs.isAviaoAvoado(Hellcopter));
    }
}
