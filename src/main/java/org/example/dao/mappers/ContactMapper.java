package org.example.dao.mappers;

import org.example.api.Contact;
import org.jdbi.v3.core.mapper.ColumnMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactMapper implements ColumnMapper<Contact> {

    public Contact map( ResultSet r,int index, StatementContext ctx) throws SQLException {
        return new Contact(r.getInt("id"),r.getString("firstName"),r.getString("lastName"),r.getString("phone"));
    }
}
