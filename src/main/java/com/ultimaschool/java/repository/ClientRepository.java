package com.ultimaschool.java.repository;

import com.ultimaschool.java.clientes.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    private DatabaseConnection connection;

    public ClientRepository(){
        this.connection = DatabaseConnection.getInstance();
    }

    public List<Cliente> findAll() throws SQLException {
        ArrayList<Cliente> clients = new ArrayList<>();
        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("Select * from cliente");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Cliente client = new Cliente();
            client.setId(resultSet.getInt("id"));
            client.setFirst_Name(resultSet.getString("first_name"));
            client.setMiddle_Name(resultSet.getString("middle_name"));
            client.setLast_Name(resultSet.getString("last_name"));
            client.setFull_Name(resultSet.getString("full_name"));
            client.setCpf(resultSet.getString("cpf"));
            client.setEmail(resultSet.getString("email"));
            client.setGenero(resultSet.getString("genero"));
            client.setEndereco(resultSet.getString("endereco"));
            client.setTelefone(resultSet.getString("telefone"));
            client.setAge(resultSet.getInt("age"));
            client.setDataDeNascimento(resultSet.getString("dataDeNascimento"));
        }
        return clients;
    }

    public Cliente findById(int id) throws SQLException {
        Cliente client = null;

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("Select * from cliente where id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            client = new Cliente();
            client.setId(resultSet.getInt("id"));
            client.setFirst_Name(resultSet.getString("first_name"));
            client.setMiddle_Name(resultSet.getString("middle_name"));
            client.setLast_Name(resultSet.getString("last_name"));
            client.setFull_Name(resultSet.getString("full_name"));
            client.setCpf(resultSet.getString("cpf"));
            client.setEmail(resultSet.getString("email"));
            client.setGenero(resultSet.getString("genero"));
            client.setEndereco(resultSet.getString("endereco"));
            client.setTelefone(resultSet.getString("telefone"));
            client.setAge(resultSet.getInt("age"));
            client.setDataDeNascimento(resultSet.getString("dataDeNascimento"));
        }

        return client;
    }

    public boolean insert(Cliente client) throws SQLException {
        boolean inserted = false;

        String insertSQL = "INSERT INTO CLIENTE (first_name, middle_Name, last_name, full_Name, email, cpf, age, genero, " +
                "telefone,  dataDeNascimento) values (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(insertSQL);
        preparedStatement.setString(1, client.getFirst_Name());
        preparedStatement.setString(2, client.getMiddle_Name());
        preparedStatement.setString(3, client.getLast_Name());
        preparedStatement.setString(4, client.getFull_Name());
        preparedStatement.setString(5, client.getEmail());
        preparedStatement.setString(6, client.getCpf());
        preparedStatement.setInt(7, client.getAge());
        preparedStatement.setString(8, client.getGenero());
        preparedStatement.setString(9, client.getTelefone());
        preparedStatement.setString(10, client.getDataDeNascimento());

        inserted = preparedStatement.execute();
        return  inserted;
    }

    public boolean update(Cliente client) throws SQLException {
        boolean updated = false;

        if (client.getId() <= 0){
            return false;
        }

        String updateSQL = "UPDATE CLIENTE set first_name = ?, middle_Name = ?, last_name = ?, full_Name = ?, email = ?, " +
                "cpf = ?, age = ?, genero = ?, telefone = ?, dataDeNascimento = ? where id =  ?";

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(updateSQL);
        preparedStatement.setString(1, client.getFirst_Name());
        preparedStatement.setString(2, client.getMiddle_Name());
        preparedStatement.setString(3, client.getLast_Name());
        preparedStatement.setString(4, client.getFull_Name());
        preparedStatement.setString(5, client.getEmail());
        preparedStatement.setString(6, client.getCpf());
        preparedStatement.setInt(7, client.getAge());
        preparedStatement.setString(8, client.getGenero());
        preparedStatement.setString(9, client.getTelefone());
        preparedStatement.setString(10, client.getDataDeNascimento());
        preparedStatement.setInt(11, client.getId());

        updated = preparedStatement.execute();
        return  updated;
    }

    public boolean delete(int id) throws SQLException {
        boolean deleted = false;

        if (id <= 0){
            return false;
        }

        String updateSQL = "DELETE FROM CLIENTE WHERE id =  ?";

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(updateSQL);
        preparedStatement.setInt(1, id);

        deleted = preparedStatement.execute();
        return  deleted;
    }
}
