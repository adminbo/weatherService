package com.zjkj.wxy.core.realm;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.zjkj.wxy.core.dao.SystemAuthDao;
import com.zjkj.wxy.core.dao.UserDao;
import com.zjkj.wxy.core.domain.Authority;
import com.zjkj.wxy.core.domain.Role;
import com.zjkj.wxy.core.domain.User;


public class WxyRealm extends AuthorizingRealm{
	@Resource
	private UserDao userDao;
	@Resource
	private SystemAuthDao authDao;
	
	
/**
 * 授权
 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//授权信息对象
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//根据当前登录用户查询数据库，获得其对应的权限
		User user = (User) principals.getPrimaryPrincipal();
		
		if(1==user.getType()){
			//超级管理员，查询所有权限
			List<Authority> list = authDao.findAll();
			//加入授权信息
			for (Authority auth : list) {
				info.addStringPermission(auth.getKeyWord());
			}
		}else{
			//其他用户，根据用户查询对应的权限
			List<Authority> list = authDao.findAuthByUserId(user.getId());
			for (Authority authority : list) {
				info.addStringPermission(authority.getKeyWord());				
			}			
		}
		return info;
	}
/**
 * 认证
 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken Mytoken = (UsernamePasswordToken) token;
		String username = Mytoken.getUsername();
		char[] password = Mytoken.getPassword();
		//根据用户名查询用户对象
		User user =userDao.getByUsername(username);
		//为空，说明认证失败
		if(user== null){
			return null;
		}
		//认证成功，返回认证信息
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPwd(), this.getClass().getName());
		return info;
	}
    /**
      * 初始化方法
     */
	@Resource
	CustomCredentialsMatcher customCredentialsMatcher;
     public void initCredentialsMatcher(){
         this.setCredentialsMatcher(customCredentialsMatcher);
     }

	
}
