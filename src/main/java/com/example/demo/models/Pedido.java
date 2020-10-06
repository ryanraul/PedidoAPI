package com.example.demo.models;

import java.util.Date;

public class Pedido {
    private int codigo;
    private double valor;
    private String descricao;
    private String cliente;
    private Date dataPedido;

    public Pedido(int codigo, double valor, String descricao, String cliente, Date dataPedido) {
        this.codigo = codigo;
        this.valor = valor;
        this.descricao = descricao;
        this.cliente = cliente;
        this.dataPedido = dataPedido;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

	public boolean Validar() {
		if( valor >= 0 && !cliente.isEmpty()){
            return true;
        }
        return false;
	}

}
