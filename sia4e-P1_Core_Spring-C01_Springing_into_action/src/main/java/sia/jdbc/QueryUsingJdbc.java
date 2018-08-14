package sia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sia.jdbc.beans.Employee;
import sia.jdbc.util.DBManager;

public class QueryUsingJdbc {

    private DBManager dbManager;

    public void setDbManager(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public Employee getEmployeeById(long id, String sql) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = dbManager.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            Employee employee = null;
            if (rs.next()) {
                employee = new Employee();
                employee.setId(rs.getLong("id"));
                employee.setFirstname(rs.getString("firstname"));
                employee.setLastname(rs.getString("lastname"));
                employee.setSalary(rs.getBigDecimal("salary"));
            }
            return employee;
        } catch (SQLException e) {
            // ...
        } finally {
            dbManager.closeResource(conn, stmt, rs);
        }
        return null;
    }
}
