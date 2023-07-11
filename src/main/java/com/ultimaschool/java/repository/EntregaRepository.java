package com.ultimaschool.java.repository;

import com.ultimaschool.java.domain.Entrega;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntregaRepository {

    private DatabaseConnection connection;

    public EntregaRepository(){
        this.connection = DatabaseConnection.getInstance();
    }

    public List<Entrega> findAll() throws SQLException {
        ArrayList<Entrega> entregas = new ArrayList<>();
        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("Select * from entrega");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Entrega entrega = new Entrega();
            entrega.setId(resultSet.getInt("id"));
            entrega.setId_pedido(resultSet.getInt("id_pedido"));
            entrega.setNome_entregador(resultSet.getString("nome_entregador"));
            entrega.setNome_receptor(resultSet.getString("nome_receptor"));
            entrega.setQtd_tentativas_entrega(resultSet.getInt("qtd_tentativas_entrega"));
            entrega.setData_entrega(resultSet.getDate("data_entrega"));
//            entrega.setStatus_entrega(resultSet.getInt("status_entrega"));
        }
        return entregas;
    }

    public Entrega findById(int id) throws SQLException {
        Entrega entrega = null;

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("Select * from entrega where id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            entrega = new Entrega();
            entrega.setId(resultSet.getInt("id"));
            entrega.setId_pedido(resultSet.getInt("id_pedido"));
            entrega.setNome_entregador(resultSet.getString("nome_entregador"));
            entrega.setNome_receptor(resultSet.getString("nome_receptor"));
            entrega.setQtd_tentativas_entrega(resultSet.getInt("qtd_tentativas_entrega"));
            entrega.setData_entrega(resultSet.getDate("data_entrega"));
//            entrega.setStatus_entrega(resultSet.getInt("status_entrega"));
        }

        return entrega;
    }

    public boolean insert(Entrega entrega) throws SQLException {
        boolean inserted = false;

        String insertSQL = "INSERT INTO ENTREGA (id_pedido, nome_entregador, nome_receptor, status_entrega, qtd_tentativas_entrega, data_entrega) values (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(insertSQL);
        preparedStatement.setInt(1, entrega.getId_pedido());
        preparedStatement.setString(2, entrega.getNome_entregador());
        preparedStatement.setString(3, entrega.getNome_receptor());
//        preparedStatement.setInt(4, entrega.getStatus_entrega());
        preparedStatement.setInt(5, entrega.getQtd_tentativas_entrega());
//        preparedStatement.setInt(6, entrega.getData_entrega());

        inserted = preparedStatement.execute();
        return  inserted;
    }

    public boolean update(Entrega entrega) throws SQLException {
        boolean updated = false;

        if (entrega.getId() <= 0){
            return false;
        }

        String updateSQL = "UPDATE ENTREGA set id_pedido = ?, nome_entregador = ?, nome_receptor = ?, status_entrega = ?, qtd_tentativas_entrega = ? data_entrega = ?  where id =  ?";

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(updateSQL);
        preparedStatement.setInt(1, entrega.getId_pedido());
        preparedStatement.setString(2, entrega.getNome_entregador());
        preparedStatement.setString(3, entrega.getNome_receptor());
//        preparedStatement.setInt(4, entrega.getStatus_Entrega());
        preparedStatement.setInt(5, entrega.getQtd_tentativas_entrega());
//        preparedStatement.setDate(5, entrega.getData_entrega());
        preparedStatement.setInt(4, entrega.getId());

        updated = preparedStatement.execute();
        return  updated;
    }

    public boolean delete(int id) throws SQLException {
        boolean deleted = false;

        if (id <= 0){
            return false;
        }

        String updateSQL = "DELETE FROM ENTREGA WHERE id =  ?";

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(updateSQL);
        preparedStatement.setInt(1, id);

        deleted = preparedStatement.execute();
        return  deleted;
    }
}
