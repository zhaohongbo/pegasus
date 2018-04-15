package net.eric.service;

import net.eric.ApiApplication;
import org.activiti.engine.ManagementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Eric Zhao
 * @date 2018/4/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
//@EnableAutoConfiguration
public class BpmnServiceTest {

    @Autowired
    ManagementService managementService;

    @Test
    public void createDatabase() {
        managementService.executeCommand(commandContext ->
                commandContext.getDbSqlSession().dbSchemaUpdate()
        );
    }

    @Test
    public void dropDatabase() {
        managementService.executeCommand(commandContext -> {
            commandContext.getDbSqlSession().dbSchemaDrop();
            return null;
        });
    }

}
