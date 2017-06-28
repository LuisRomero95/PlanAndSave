package pe.edu.utp.planandsave.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ernesto Chira on 16/06/2017.
 */
public class Subscription {
    private int id;
    private String name;
    private float price;

    public int getId() {
        return id;
    }

    public String getIdAsString(){
        return String.valueOf(getId());
    }

    public Subscription setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getNameAsValue(){
        return "'" + getName() + "'";
    }

    public Subscription setName(String name) {
        this.name = name;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public String getPriceAsString(){
        return String.valueOf(getPrice());
    }

    public Subscription setPrice(float price) {
        this.price = price;
        return this;
    }

    public static Subscription build(ResultSet resultSet){
        try {
            return (new Subscription())
                    .setId(resultSet.getInt("id"))
                    .setName(resultSet.getString("name"))
                    .setPrice(resultSet.getFloat("price"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}