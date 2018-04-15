package net.eric.controller;

import net.eric.aspect.AuthInterceptor;
import net.eric.protocol.BasicResponse;
import net.eric.protocol.ErrorResponse;
import net.eric.protocol.WorkflowDefinitionListResponse;
import net.eric.service.BpmnService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Eric Zhao
 * @date 2018/4/15
 */
@RestController
@RequestMapping(path = "/workflow")
public class WorkflowController {
    private BpmnService bpmnService;

    @Autowired
    public WorkflowController(BpmnService bpmnService) {
        this.bpmnService = bpmnService;
    }

    @RequestMapping(path = "/definition/list", method = RequestMethod.GET)
    public WorkflowDefinitionListResponse getDefinitionList () {
        List<ProcessDefinition> definitions = bpmnService.queryProcessDefinitionList();
        ProcessDefinition firstProcessDefinition = definitions.get(0);
        List<FormProperty> formProperties = bpmnService.queryStartFormData(firstProcessDefinition.getId());
        WorkflowDefinitionListResponse response = new WorkflowDefinitionListResponse();
        for (ProcessDefinition definition:definitions) {
            response.addWorkflowDefinition(definition.getId(), definition.getName());
        }
        response.setFirstWorkflowDefinition(firstProcessDefinition.getId(), formProperties);
        return response;
    }

    @RequestMapping(path = "/create/{processDefinitionId}", method = RequestMethod.POST)
    public BasicResponse createProcess(@PathVariable("processDefinitionId") String processDefinitionId,
                                       @RequestAttribute(AuthInterceptor.AUTH_USER_ID) int id,
                                       @RequestBody Map<String, String> formValue) {
        bpmnService.createProcess(Integer.toString(id),  processDefinitionId, formValue);
        return new BasicResponse();
    }

}
