package com.example.taskwebappanimals.dao;

import com.example.taskwebappanimals.database.ConnectDataBase;
import com.example.taskwebappanimals.entity.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalsDao extends AbstractDao<Pet> {
    @Override
    public List<Pet> select() {

        List<Pet> pets = new ArrayList<>();
        try (Connection connection = ConnectDataBase.getDBConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM pets");
            while (rs.next()) {
                int id = rs.getInt(1);
                String typePet = rs.getString(2);
                String name = rs.getString(3);
                int age = rs.getInt(4);
                String color = rs.getString(5);
                boolean ownerStatus = rs.getBoolean(6);
                Pet pet = new Pet(id, typePet, name, age, color, ownerStatus);
                pets.add(pet);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return pets;
    }

    @Override
    public Pet selectOne(int id) {

        Pet pet = null;
        try (Connection connection = ConnectDataBase.getDBConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM pets WHERE id=?")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                String typePet = rs.getString(2);
                String name = rs.getString(3);
                int age = rs.getInt(4);
                String color = rs.getString(5);
                boolean ownerStatus = rs.getBoolean(6);
                pet = new Pet(id, typePet, name, age, color, ownerStatus);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return pet;
    }

    @Override
    public int insert(Pet entity) {

        try (Connection connection = ConnectDataBase.getDBConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO pets (typePet, name, age, color, ownerStatus) VALUES ( ?, ?, ?, ?, ?)")) {
            statement.setString(1, entity.getTypePet());
            statement.setString(2, entity.getName());
            statement.setInt(3, entity.getAge());
            statement.setString(4, entity.getColor());
            statement.setBoolean(5, entity.isOwnerStatus());
            statement.executeUpdate();
            return statement.executeUpdate();
//            ResultSet rs = statement.getGeneratedKeys();
//            rs.next();


        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return 0;
    }

    @Override
    public int update(Pet entity) {
        try (Connection connection = ConnectDataBase.getDBConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE pets SET typePet = ?, name = ?, age = ?, color =?,ownerStatus =? WHERE id = ?")) {
            statement.setString(1, entity.getTypePet());
            statement.setString(2, entity.getName());
            statement.setInt(3, entity.getAge());
            statement.setString(4, entity.getColor());
            statement.setBoolean(5, entity.isOwnerStatus());
            statement.setInt(6, entity.getId());
           return statement.executeUpdate();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public boolean delete(int id) {

        boolean result = true;
        try (Connection connection = ConnectDataBase.getDBConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM pets WHERE id = ?")) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            result = false;
        }
        return result;


    }
}

