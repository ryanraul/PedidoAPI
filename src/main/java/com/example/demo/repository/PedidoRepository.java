package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.demo.models.Pedido;

import org.springframework.stereotype.Component;

@Component
public class PedidoRepository {
    public List<Pedido> pedidos;
    int codigoPedidos;

    @PostConstruct
    public void initRepository(){
        Pedido p1 = new Pedido(1, 250.00, "Placa de video", "Raul", new Date(System.currentTimeMillis()));
        Pedido p2 = new Pedido(2, 550.00, "Placa-mae", "Ryan", new Date(System.currentTimeMillis()));
        Pedido p3 = new Pedido(3, 300.00, "Fonte 500W", "Raul", new Date(System.currentTimeMillis()));

        pedidos = new ArrayList<Pedido>();
        pedidos.add(p1);
        pedidos.add(p2);
        pedidos.add(p3);
        codigoPedidos = pedidos.size();
    }

    public List<Pedido> getAllPedidos(){
        if(pedidos.size()>0){
            return pedidos;
        }
        return null;
    }

    public Pedido getPedidosById(int codigo){
        Pedido pedidoRequisitado = buscaPedidos(codigo);
        return pedidoRequisitado != null ? pedidoRequisitado : null;
    }

    public Pedido savePedido(Pedido pedido){
        if(pedido.Validar()){
            codigoPedidos++;
            pedido.setCodigo(codigoPedidos);
            pedidos.add(pedido);
            return pedido;
        }
        return null;
    }

    public Pedido editPedido(Pedido pedidoAlterado, int codigo){
        Pedido pedidoRequisitado = buscaPedidos(codigo);
        
        if(pedidoRequisitado != null && pedidoAlterado.Validar()){
            int posicaoNaLista = pedidos.indexOf(pedidoRequisitado);
            pedidoRequisitado = pedidoAlterado;
            // pedidoRequisitado.setValor(pedidoAlterado.getValor());
            // pedidoRequisitado.setDescricao(pedidoAlterado.getDescricao());
            // pedidoRequisitado.setCliente(pedidoAlterado.getCliente());
            // pedidoRequisitado.setDataPedido(pedidoAlterado.getDataPedido());
            
            pedidos.set(posicaoNaLista, pedidoRequisitado);
            return pedidoRequisitado;
        }
        return null;
    }

	public Pedido deletePedidoById(int codigo) {
        Pedido pedidoRequisitado = buscaPedidos(codigo);
        if(pedidoRequisitado != null){
            pedidos.remove(pedidoRequisitado);
            return pedidoRequisitado;
        }
        return null;
    }
    
    public Pedido buscaPedidos(int codigo){
        for(Pedido pedido : pedidos){
            if(pedido.getCodigo() == codigo){
                return pedido;
            }
        }
        return null;
    }
}
