package jp.co.hoge.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.hoge.web.dao.RoleDao;
import jp.co.hoge.web.entity.Role;
import jp.co.hoge.web.service.RoleService;

@Service
public class PgRoleService implements RoleService{

	@Autowired
	private RoleDao roleDao;
	 @Override
	public List<Role> findAllRoles(){
		return roleDao.findAllRoles();
	}
}

