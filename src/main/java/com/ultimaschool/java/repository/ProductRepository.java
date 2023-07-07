package com.ultimaschool.java.repository;

import com.ultimaschool.java.domain.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private DatabaseConnection connection;

    public ProductRepository(){
        this.connection = DatabaseConnection.getInstance();
    }

    public List<Product> findAll() throws SQLException {
        ArrayList<Product> products = new ArrayList<>();
        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("Select * from produto");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setNome(resultSet.getString("nome"));
                product.setPreco(resultSet.getDouble("preco"));
        }
        return products;
    }

    public Product findById(int id) throws SQLException {
        Product product = null;

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("Select * from produto where id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setNome(resultSet.getString("nome"));
            product.setPreco(resultSet.getDouble("preco"));

        }

        return product;
    }

    public boolean insert(Product product) throws SQLException {
        boolean inserted = false;

        String insertSQL = "INSERT INTO PRODUTO (nome, preco) values (?, ?)";

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(insertSQL);
        preparedStatement.setString(1, product.getNome());
        preparedStatement.setDouble(2, product.getPreco());

        inserted = preparedStatement.execute();
        return  inserted;
    }

    public boolean update(Product product) throws SQLException {
        boolean updated = false;

        if (product.getId() <= 0){
            return false;
        }

        String updateSQL = "UPDATE PRODUTO set nome = ?, preco = ? where id =  ?";

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(updateSQL);
        preparedStatement.setString(1, product.getNome());
        preparedStatement.setDouble(2, product.getPreco());
        preparedStatement.setInt(3, product.getId());

        updated = preparedStatement.execute();
        return  updated;
    }

    public boolean delete(int id) throws SQLException {
        boolean deleted = false;

        if (id <= 0){
            return false;
        }

        String updateSQL = "DELETE FROM PRODUTO WHERE id =  ?";

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(updateSQL);
        preparedStatement.setInt(1, id);

        deleted = preparedStatement.execute();
        return  deleted;
    }

}
