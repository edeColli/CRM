package com.ultimaschool.java.repository;

import com.ultimaschool.java.domain.Client;

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

    public List<Client> findAll() throws SQLException {
        ArrayList<Client> clients = new ArrayList<>();
        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("Select * from cliente");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Client client = new Client();
            client.setId(resultSet.getInt("id"));
            client.setFirstName(resultSet.getString("first_name"));
            client.setLastName(resultSet.getString("last_name"));
            client.setCpf(resultSet.getString("cpf"));
            client.setEmail(resultSet.getString("email"));
            client.setAge(resultSet.getInt("age"));
        }
        return clients;
    }

    public Client findById(int id) throws SQLException {
        Client client = null;

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("Select * from cliente where id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            client = new Client();
            client.setId(resultSet.getInt("id"));
            client.setFirstName(resultSet.getString("first_name"));
            client.setLastName(resultSet.getString("last_name"));
            client.setCpf(resultSet.getString("cpf"));
            client.setEmail(resultSet.getString("email"));
            client.setAge(resultSet.getInt("age"));
        }

        return client;
    }

    public boolean insert(Client client) throws SQLException {
        boolean inserted = false;

        String insertSQL = "INSERT INTO CLIENTE (first_name, last_name, email, cpf, age) values (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(insertSQL);
        preparedStatement.setString(1, client.getFirstName());
        preparedStatement.setString(2, client.getLastName());
        preparedStatement.setString(3, client.getEmail());
        preparedStatement.setString(4, client.getCpf());
        preparedStatement.setInt(5, client.getAge());

        inserted = preparedStatement.execute();
        return  inserted;
    }

    public boolean update(Client client) throws SQLException {
        boolean updated = false;

        if (client.getId() <= 0){
            return false;
        }

        String updateSQL = "UPDATE CLIENTE set first_name = ?, last_name = ?, email = ?, cpf = ?, age = ? where id =  ?";

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(updateSQL);
        preparedStatement.setString(1, client.getFirstName());
        preparedStatement.setString(2, client.getLastName());
        preparedStatement.setString(3, client.getEmail());
        preparedStatement.setString(4, client.getCpf());
        preparedStatement.setInt(5, client.getAge());
        preparedStatement.setInt(6, client.getId());

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
