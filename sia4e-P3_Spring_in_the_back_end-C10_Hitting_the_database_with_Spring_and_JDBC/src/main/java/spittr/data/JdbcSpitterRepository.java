package spittr.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Repository;

import spittr.Spitter;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {

    private static final String SQL_INSERT_SPITTER = "insert into spitter (username, password, firstname, lastname) values (?, ?, ?, ?)";

    private static final String SQL_SELECT_SPITTER = "select id, username, password, firstname, lastname from spitter where username = ?";

    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public void addSpitter(Spitter spitter) {
        
        PasswordEncoder encoder = new Pbkdf2PasswordEncoder("53cr3t");
        
        String encodedPassword = encoder.encode(spitter.getPassword());
        
        jdbcOperations.update(SQL_INSERT_SPITTER, spitter.getUsername(), encodedPassword, spitter.getFirstName(),
                spitter.getLastName());

    }

    @Override
    public Spitter findByUsername(String username) {

        return jdbcOperations.queryForObject(SQL_SELECT_SPITTER, new RowMapper<Spitter>() {

            @Override
            public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {

                return new Spitter(rs.getLong("id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("firstname"), rs.getString("lastname"));
            }

        }, username);
    }
    
    

    // 使用NamedParameterJdbcTemplate
    // private static final String SQL_INSERT_SPITTER_NAMED_PARAMETER =
    // "insert into spitter (username, password, firstname, lastname)"
    // + " values "
    // + "(:username, :password, :firstname, :lastname)";
    //
    // @Autowired
    // private NamedParameterJdbcOperations jdbcOperations;
    //
    // @Override
    // public void addSpitter(Spitter spitter) {
    // Map<String, Object> paramMap = new HashMap<>();
    //
    // // 绑定参数
    // paramMap.put("username", spitter.getUsername());
    // paramMap.put("password", spitter.getPassword());
    // paramMap.put("firstname", spitter.getFirstName());
    // paramMap.put("lastname", spitter.getLastName());
    //
    // // 执行数据插入
    // jdbcOperations.update(SQL_INSERT_SPITTER_NAMED_PARAMETER, paramMap);
    // }
    //
    // @Override
    // public Spitter findByUsername(String username) {
    // // TODO Auto-generated method stub
    // return null;
    // }

}
