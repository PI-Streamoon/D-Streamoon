package controllers;

import views.Login;

public class RegistroController {

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
