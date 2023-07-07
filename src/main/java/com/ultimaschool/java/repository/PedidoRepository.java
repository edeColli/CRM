package com.ultimaschool.java.repository;

import com.ultimaschool.java.domain.Pedido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {

    private DatabaseConnection connection;

    public PedidoRepository(){
        this.connection = DatabaseConnection.getInstance();
    }

    public List<Pedido> findAll() throws SQLException {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("Select * from pedido");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Pedido pedido = new Pedido();
            pedido.setId(resultSet.getInt("id"));
            pedido.setCliente_id(resultSet.getInt("cliente_id"));
            pedido.setDatahora_criacao(resultSet.getDate("datahora_criacao"));
            pedido.setDatahora_entrega(resultSet.getDate("datahora_entrega"));
            pedido.setValor_pedido(resultSet.getDouble("valor_pedido"));
//            pedido.setStatusPedido(resultSet.getInt("status_pedido"));
        }
        return pedidos;
    }

    public Pedido findById(int id) throws SQLException {
        Pedido pedido = null;

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("Select * from pedido where id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            pedido = new Pedido();
            pedido.setId(resultSet.getInt("id"));
            pedido.setCliente_id(resultSet.getInt("cliente_id"));
            pedido.setDatahora_entrega(resultSet.getDate("datahora_entrega"));
            pedido.setDatahora_criacao(resultSet.getDate("datahora_criacao"));
            pedido.setValor_pedido(resultSet.getDouble("valor_pedido"));
//            pedido.setStatus(resultSet.getInt("status_pedido"));
        }

        return pedido;
    }

    public boolean insert(Pedido pedido) throws SQLException {
        boolean inserted = false;

        String insertSQL = "INSERT INTO PEDIDO (cliente_id, datahora_criacao, datahora_entrega, valor_pedido, status_pedido) values (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(insertSQL);
        preparedStatement.setInt(1, pedido.getCliente_id());
//        preparedStatement.setDate(2, pedido.getDatahora_criacao());
//        preparedStatement.setDate(3, pedido.getDatahora_entrega());
        preparedStatement.setDouble(4, pedido.getValor_pedido());
//        preparedStatement.setInt(5, pedido.getStatus());

        inserted = preparedStatement.execute();
        return  inserted;
    }

    public boolean update(Pedido pedido) throws SQLException {
        boolean updated = false;

        if (pedido.getId() <= 0){
            return false;
        }

        String updateSQL = "UPDATE PEDIDO set cliente_id = ?, datahora_craicao = ?, datahora_entrega = ?, valor_pedido = ?, status_peddio = ? where id =  ?";

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(updateSQL);
        preparedStatement.setInt(1, pedido.getCliente_id());
//        preparedStatement.setDate(2, pedido.getDatahora_criacao());
//        preparedStatement.setDate(3, pedido.getDatahora_entrega());
        preparedStatement.setDouble(4, pedido.getValor_pedido());
//        preparedStatement.setInt(5, pedido.getStatus());
        preparedStatement.setInt(6, pedido.getId());

        updated = preparedStatement.execute();
        return  updated;
    }

    public boolean delete(int id) throws SQLException {
        boolean deleted = false;

        if (id <= 0){
            return false;
        }

        String updateSQL = "DELETE FROM PEDIDO WHERE id =  ?";

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(updateSQL);
        preparedStatement.setInt(1, id);

        deleted = preparedStatement.execute();
        return  deleted;
    }
}
