package com.ultimaschool.java.enums;

public enum Status_entrega {

    RECEBIDO("RECEBIDO"),
    RECUSADO("RECUSADO"),
    EXTRAVIADO("EXTRAVIADO"),
    NINGUEM_PRA_RECEBER("NINGUEM_PRA_RECEBER"),
    MUDOU_ENDERECO("MUDOU_ENDERECO"),
    EM_ROTA_DE_ENTREGA("EM_ROTA_DE_ENTREGA");

    public final String label;

    private Status_entrega(String label) {
        this.label = label;
    }

}
