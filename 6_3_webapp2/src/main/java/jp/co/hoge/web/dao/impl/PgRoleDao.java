package jp.co.hoge.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.hoge.web.dao.RoleDao;
import jp.co.hoge.web.entity.Role;

@Repository
public class PgRoleDao implements RoleDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Role> findAllRoles() {
        String sql = "SELECT * FROM role";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Role.class));
    }
}
