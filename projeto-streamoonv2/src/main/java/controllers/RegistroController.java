package controllers;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
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

    public void inserirCPU() {
        Double cpu = Double.valueOf(processador.getUso());

        for (ComponenteModel model : componenteModel.pegarComponentePorNome("CPU")) {
            componenteModel.setIdComponenteServidor(model.getIdComponenteServidor());
        }

        Integer fkComponent = componenteModel.getIdComponenteServidor();

        registroModel.inserirCPU(cpu, fkComponent);

    }

    public void inserirRAM() {
        Double ram = Double.valueOf((memoria.getEmUso()*100/memoria.getTotal()));

        for (ComponenteModel model : componenteModel.pegarComponentePorNome("Memoria")) {
            componenteModel.setIdComponenteServidor(model.getIdComponenteServidor());
        }

        Integer fkComponent = componenteModel.getIdComponenteServidor();

        registroModel.inserirRAM(ram, fkComponent);

    }

    public void inserirDisco() {

        List<Disco> discos = grupoDeDiscos.getDiscos();

        for (ComponenteModel model : componenteModel.pegarComponentePorNome("Disco")) {
            componenteModel.setIdComponenteServidor(model.getIdComponenteServidor());
        }

        Integer fkComponent = componenteModel.getIdComponenteServidor();

        for (Disco discoAtual : discos) {
            registroModel.inserirDisco(discoAtual.getLeituras().doubleValue(), fkComponent);
        }

    }

    public void inserirUpload() {
        RedeInterface redeEscolhida = rede.getGrupoDeInterfaces().getInterfaces().get(0);

        Double upload = Double.valueOf(redeEscolhida.getBytesRecebidos()/1024000);

        for (ComponenteModel model : componenteModel.pegarComponentePorNome("Upload")) {
            componenteModel.setIdComponenteServidor(model.getIdComponenteServidor());
        }

        Integer fkComponent = componenteModel.getIdComponenteServidor();

        registroModel.inserirUpload(upload,fkComponent);
    }

    public void inserirDownload() {
        RedeInterface redeEscolhida = rede.getGrupoDeInterfaces().getInterfaces().get(1);

        Double download = Double.valueOf(redeEscolhida.getBytesEnviados()/1024000);

        for (ComponenteModel model : componenteModel.pegarComponentePorNome("Download")) {
            componenteModel.setIdComponenteServidor(model.getIdComponenteServidor());
        }

        Integer fkComponent = componenteModel.getIdComponenteServidor();

        registroModel.inserirDownload(download,fkComponent);

    }

    public String getDados(Boolean cpu,Boolean ram, Boolean disco, Boolean upload, Boolean download){
        String conjuntoDados = "";

        if(cpu){
            inserirCPU();
            conjuntoDados+= "CPU: "+ registroModel.selectComponente("CPU")+"%\n";
        }

        if(ram){
            inserirRAM();
            conjuntoDados+="RAM: "+ registroModel.selectComponente("Memoria")+"%\n";
        }

        if(disco){
            inserirDisco();
            conjuntoDados+="Disco: "+ registroModel.selectComponente("Disco")+"%\n";
        }

        if(upload){
            inserirUpload();
            conjuntoDados+="Upload: "+registroModel.selectComponente("Upload")+"Mbps\n";
        }

        if(download){
            inserirDownload();
            conjuntoDados+="Download: "+registroModel.selectComponente("Download")+"Mbps\n";
        }

        return conjuntoDados;

    }
}
