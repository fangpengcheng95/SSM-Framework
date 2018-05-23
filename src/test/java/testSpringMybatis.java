
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fpc.Entity.User;
import com.fpc.Service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-mybatis.xml"})
public class testSpringMybatis {
	private static Logger logger = Logger.getLogger(testSpringMybatis.class);
	
	@Resource
	private IUserService userService = null;
	
	@Test
	public void test1() {
		User user = userService.getUserById(1);
		String message = user.getId() + " ----- " + user.getName() + " ----- " + user.getAge();
		logger.info(message);
	}
}
