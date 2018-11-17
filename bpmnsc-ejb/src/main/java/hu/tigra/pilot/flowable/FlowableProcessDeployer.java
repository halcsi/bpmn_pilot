package hu.tigra.pilot.flowable;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.ProcessEngines;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;

@Stateless
public class FlowableProcessDeployer implements Serializable {

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void deploy() {

		ProcessEngine processEngine = createProcessEngine();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		Deployment deployment = repositoryService.createDeployment().addClasspathResource("MainFlow_1.bpmn")
				.deploy();
	}

	private ProcessEngine createProcessEngine() {
		ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
				.setDataSourceJndiName("java:jboss/datasources/JbpmDS")
				.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

		return cfg.buildProcessEngine();
	}
}
