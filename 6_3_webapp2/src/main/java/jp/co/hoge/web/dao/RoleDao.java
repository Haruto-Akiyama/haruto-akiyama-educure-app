package jp.co.hoge.web.dao;

import java.util.List;

import jp.co.hoge.web.entity.Role;

public interface RoleDao {
    List<Role> findAllRoles();
}