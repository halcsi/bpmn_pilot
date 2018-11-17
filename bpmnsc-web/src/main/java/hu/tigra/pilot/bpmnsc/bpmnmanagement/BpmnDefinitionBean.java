package hu.tigra.pilot.bpmnsc.bpmnmanagement;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import hu.tigra.pilot.flowable.FlowableProcessDeployer;

@Named
@RequestScoped
public class BpmnDefinitionBean {
	
	@Inject
	private FlowableProcessDeployer flowableProcessDeployer;
	
	public String deploy() {
		flowableProcessDeployer.deploy();
		return "";
	}
}
