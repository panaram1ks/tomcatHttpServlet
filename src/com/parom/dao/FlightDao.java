package com.parom.dao;

import com.parom.entity.Flight;
import com.parom.entity.FlightStatuse;
import com.parom.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Long, Flight> {

    private final static FlightDao INSTANCE = new FlightDao();

    private FlightDao() {
    }

    private static final String FIND_ALL = """
            select *
            from flight
            """;

    @Override
    public List<Flight> findAll() {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Flight> flights = new ArrayList<>();
            while (resultSet.next()) {
                flights.add(buildFlight(resultSet));
            }
            return flights;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Optional<Flight> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Flight entity) {

    }

    @Override
    public Flight save(Flight entity) {
        return null;
    }

    public static FlightDao getInstance() {
        return INSTANCE;
    }

    private Flight buildFlight(ResultSet resultSet) throws SQLException {
        return new Flight(
          resultSet.getObject("id", Long.class),
          resultSet.getObject("flight_no", String.class),
          resultSet.getObject("departure_date", Date.class),
          resultSet.getObject("departure_airport_code", String.class),
//          resultSet.getObject("arrival_date", Date.class),
//          resultSet.getObject("arrival_airport_code", String.class),
          resultSet.getObject("aircraft_id", Long.class),
          FlightStatuse.valueOf(resultSet.getObject("status", String.class))
          );
    }


}
