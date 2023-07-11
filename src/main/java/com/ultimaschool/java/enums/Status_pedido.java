package com.ultimaschool.java.enums;

public enum Status_pedido {

    CRIADO("CRIADO"),
    AGUARDANDO_PAGAMENTO("AGUARDANDO_PAGAMENTO"),
    ERRO_PAGAMENTO("ERRO_PAGAMENTO"),
    PAGO("PAGO"),
    PREPARANDO_ENTREGA("PREPARANDO_ENTREGA"),
    ENVIADO("ENVIADO"),
    CANCELADO("CANCELADO"),
    ENTREGUE("ENTREGUE");
    public final String label;

    private Status_pedido(String label) {
        this.label = label;
    }
}
