package contacts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public List<Contact> findAll() {
        return jdbc.query("select id, firstName, lastName, phoneNumber, emailAddress"
                + " from contacts order by lastName",
                new RowMapper<Contact>() {

                    @Override
                    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {

                        Contact contact = new Contact();
                        contact.setId(rs.getLong(1));
                        contact.setFirstName(rs.getString(2));
                        contact.setLastName(rs.getString(3));
                        contact.setPhoneNumber(rs.getString(4));
                        contact.setEmailAddress(rs.getString(5));
                        return contact;
                    }
                });
    }

    public void save(Contact contact) {
        jdbc.update("insert into contacts (firstName, lastName, phoneNumber, emailAddress)"
                + " values (?, ?, ?, ?)",
                contact.getFirstName(), 
                contact.getLastName(), 
                contact.getPhoneNumber(), 
                contact.getEmailAddress());
    }
}
