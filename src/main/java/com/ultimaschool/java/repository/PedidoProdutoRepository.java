package com.ultimaschool.java.repository;

import com.ultimaschool.java.domain.PedidoProduto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoProdutoRepository {

    private DatabaseConnection connection;

    public PedidoProdutoRepository(){
        this.connection = DatabaseConnection.getInstance();
    }

    public List<PedidoProduto> findAll() throws SQLException {
        ArrayList<PedidoProduto> pedidoProdutos = new ArrayList<>();
        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("Select * from pedido_produto");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            PedidoProduto pedidoProduto = new PedidoProduto();
            pedidoProduto.setId(resultSet.getInt("id"));
            pedidoProduto.setProduto_id(resultSet.getInt("produto_id"));
            pedidoProduto.setPedido_id(resultSet.getInt("pedido_id"));
            pedidoProduto.setQuantidade(resultSet.getInt("quantidade"));
        }
        return pedidoProdutos;
    }

    public PedidoProduto findById(int id) throws SQLException {
        PedidoProduto pedidoProduto = null;

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("Select * from pedido_produto where id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            pedidoProduto = new PedidoProduto();
            pedidoProduto.setId(resultSet.getInt("id"));
            pedidoProduto.setProduto_id(resultSet.getInt("produto_id"));
            pedidoProduto.setPedido_id(resultSet.getInt("pedido_id"));
            pedidoProduto.setQuantidade(resultSet.getInt("quantidade"));
        }

        return pedidoProduto;
    }

    public boolean insert(PedidoProduto pedidoProduto) throws SQLException {
        boolean inserted = false;

        String insertSQL = "INSERT INTO PEDIDO_PRODUTO (produto_id, pedido_id, quantidade) values (?, ?, ?)";

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(insertSQL);
        preparedStatement.setInt(1, pedidoProduto.getProduto_id());
        preparedStatement.setInt(2, pedidoProduto.getProduto_id());
        preparedStatement.setInt(3, pedidoProduto.getQuantidade());

        inserted = preparedStatement.execute();
        return  inserted;
    }

    public boolean update(PedidoProduto pedidoProduto) throws SQLException {
        boolean updated = false;

        if (pedidoProduto.getId() <= 0){
            return false;
        }

        String updateSQL = "UPDATE PEDIDO_PRODUTO set produto_id = ?, pedido_id = ?, quantidade = ?  where id =  ?";

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(updateSQL);
        preparedStatement.setInt(1, pedidoProduto.getProduto_id());
        preparedStatement.setInt(2, pedidoProduto.getPedido_id());
        preparedStatement.setInt(3, pedidoProduto.getQuantidade());
        preparedStatement.setInt(4, pedidoProduto.getId());

        updated = preparedStatement.execute();
        return  updated;
    }

    public boolean delete(int id) throws SQLException {
        boolean deleted = false;

        if (id <= 0){
            return false;
        }

        String updateSQL = "DELETE FROM PEDIDO_PRODUTO WHERE id =  ?";

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(updateSQL);
        preparedStatement.setInt(1, id);

        deleted = preparedStatement.execute();
        return  deleted;
    }
}
