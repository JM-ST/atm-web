package th.ac.ku.atmweb.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import th.ac.ku.atmweb.Model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

//    private JdbcTemplate jdbcTemplate;
//
//    public CustomerRepository(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Customer> findAll() {
//        String query = "select * from customer";
//        List<Customer> customerList = jdbcTemplate.query(query, new CustomerRowMapper());
//        return customerList;
//    }
//
//    public Customer findById(int id) {
//        String query = "select * from customer where id="+id;
//        Customer customer = jdbcTemplate.queryForObject(query, new CustomerRowMapper());
//        return  customer;
//    }
//
//    public void save(Customer customer){
//        String query = "insert into customer (id,name,pin) values (?,?,?);";
//        Object[] data = new Object[] {customer.getId(), customer.getName(), customer.getPin()};
//        jdbcTemplate.update(query,data);
//
//    }
//
//    public void deleteById(int id){
//        String query = "delete from customer where id="+id ;
//        jdbcTemplate.update(query);
//    }
//
//    class CustomerRowMapper implements RowMapper<Customer> {
//
//        @Override
//        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
//            int id = resultSet.getInt("id");
//            String name = resultSet.getString("name");
//            String pin = resultSet.getString("pin");
//
//            Customer customer = new Customer(id, name, pin);
//            return customer;
//        }
//    }

}