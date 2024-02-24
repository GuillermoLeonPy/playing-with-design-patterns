package py.com.patterns.api.compositepattern.organizational.structure.application;

import org.apache.commons.lang3.StringUtils;

import py.com.patterns.api.compositepattern.organizational.structure.CollaboratingEntity;
import py.com.patterns.api.compositepattern.organizational.structure.EntityType;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollaboratingEntity directorsBoard = new CollaboratingEntity("Directors board", EntityType.DEPARTMENT);
		CollaboratingEntity accountingManagement = new CollaboratingEntity("Accounting management", EntityType.DEPARTMENT);
		CollaboratingEntity accountingManager = new CollaboratingEntity("Accounting Manager", EntityType.INDIVIDUAL);
		accountingManager.addDependantEntity(new CollaboratingEntity("Secretary", EntityType.INDIVIDUAL));		
		accountingManagement.addDependantEntity(accountingManager);
		accountingManagement.addDependantEntity(new CollaboratingEntity("Budgeting office", EntityType.DEPARTMENT));
		accountingManagement.addDependantEntity(new CollaboratingEntity("Incomes management office", EntityType.DEPARTMENT));
		accountingManagement.addDependantEntity(new CollaboratingEntity("Outcomes management office", EntityType.DEPARTMENT));
		CollaboratingEntity informationTechnologyManagement = new CollaboratingEntity("Information technology management", EntityType.DEPARTMENT);
		informationTechnologyManagement.addDependantEntity(new CollaboratingEntity("Develompment Operations office", EntityType.DEPARTMENT));
		informationTechnologyManagement.addDependantEntity(new CollaboratingEntity("Research office", EntityType.DEPARTMENT));
		informationTechnologyManagement.addDependantEntity(new CollaboratingEntity("Cloud Infraestructure office", EntityType.DEPARTMENT));
		
		directorsBoard.addDependantEntity(accountingManagement);
		directorsBoard.addDependantEntity(informationTechnologyManagement);
		
		printOrganizationalStructure(directorsBoard, (byte)0);
	}
	
	private static void printOrganizationalStructure(CollaboratingEntity entity, byte level) {
		
		System.out.println(StringUtils.leftPad(" ", level * 10) + entity.getName());
		entity.getDependantEntities().forEach(de -> printOrganizationalStructure(de, (byte) (level + 1)));
	}
	

}
