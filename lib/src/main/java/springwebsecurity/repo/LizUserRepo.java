package springwebsecurity.repo;

import springwebsecurity.entity.User;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public class LizUserRepo extends SimpleJpaRepository<User,Integer>{
	
	private final Class<User>  domainClass;
	private final EntityManager em;
	
	@Autowired
public LizUserRepo(Class<User> domainClass, EntityManager em) {
		super(domainClass, em);
		this.domainClass=domainClass;
		this.em=em;
	}

	//,JpaSpecificationExecutor<User>{
	public User findUserByUsername(String username,Class<User> claz) {
		return null;
	}
}
