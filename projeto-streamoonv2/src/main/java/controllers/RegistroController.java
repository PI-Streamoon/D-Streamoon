package controllers;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import models.ComponenteModel;
import models.RegistroModel;

import java.util.List;

public class RegistroController {

    // Atributos para captura dos valores
    private Looca looca = new Looca();
    private final Sistema sistema;
    private final Memoria memoria;
    private final Processador processador;
    private final Temperatura temperatura;
    private final DiscoGrupo grupoDeDiscos;
    private final Rede rede;
    private ComponenteModel componenteModel;
    private RegistroModel registroModel;
    // Fim dos atributos de captura de valores

    public RegistroController() {
        this.sistema = looca.getSistema();
        this.memoria = looca.getMemoria();
        this.processador = looca.getProcessador();
        this.temperatura = looca.getTemperatura();
        this.grupoDeDiscos = looca.getGrupoDeDiscos();
        this.rede = looca.getRede();
        this.registroModel = new RegistroModel();
        this.componenteModel = new ComponenteModel();
    }

    public Long getRamEmUso(){
        return memoria.getEmUso();
    }

    public void inserirDados() {
        RedeInterface redeEscolhida = rede.getGrupoDeInterfaces().getInterfaces().get(1);

        Double download = Double.valueOf(redeEscolhida.getBytesEnviados());

        for (ComponenteModel model : componenteModel.pegarComponentePorNome("Download")) {
            componenteModel.setIdComponenteServidor(model.getIdComponenteServidor());
        }
        Integer fkComponent = componenteModel.getIdComponenteServidor();

        registroModel.inserirDownload(download,fkComponent);

//        componenteModel.pegarComponentePorNome("Download");
        System.out.println(componenteModel.getIdComponenteServidor());
        System.out.println("Teste");
        System.out.println("-----------------------------------------");

    }

    public void exibirDados(){
        RedeInterface redeEscolhida = rede.getGrupoDeInterfaces().getInterfaces().get(1);

        List<RedeInterface> redes = rede.getGrupoDeInterfaces().getInterfaces();

        for (RedeInterface redeInterface : redes) {
            System.out.println(redeInterface);
        }


        System.out.println(redeEscolhida.getBytesEnviados());
        System.out.println(redeEscolhida.getBytesRecebidos());

        System.out.println(redeEscolhida);


    }


    public String getDados(Boolean cpu,Boolean ram, Boolean disco, Boolean upload, Boolean download){
        String conjuntoDados = "";

        if(cpu){
            conjuntoDados+="CPU: 52%%\n";
        }

        if(ram){
            conjuntoDados+="RAM: 78%%\n";
        }

        if(disco){
            conjuntoDados+="Disco: 67%%\n";
        }

        if(upload){
            conjuntoDados+="Upload: 280MHz\n";
        }

        if(download){
            conjuntoDados+="Download: 340MHz\n";
        }

        return conjuntoDados;

    }
}
