package klaarhq.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;

import klaarhq.base.BaseLoggedInTest;

@TestMethodOrder(OrderAnnotation.class)
public class WorkSpaceSettingsTests extends BaseLoggedInTest {
	
	@BeforeAll
	public void navigate()
	{
		
	}
}
