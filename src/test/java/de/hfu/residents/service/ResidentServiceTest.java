package de.hfu.residents.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static org.easymock.EasyMock.*; 
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;

public class ResidentServiceTest {
	/**
     * Tested ResidentService
	 * @throws ResidentServiceException 
     */
    @Test
    public void testResidentService() throws ResidentServiceException
    {
    	ResidentRepositoryStub rrs = new ResidentRepositoryStub();
    	BaseResidentService brs = new BaseResidentService();
    	brs.setResidentRepository(rrs);
    	
    	List<Resident> residentList = rrs.getResidents();
    	Resident resident1 = residentList.get(0); //("Martin", "Molke", "Teststraße 1a", "Furtwangen", new Date(99, 04, 20));
    	Resident resident2 = residentList.get(1); //("Martini", "Lore", "Heißstraße 2b", "Villingen", new Date(101, 02, 15));
    	Resident resident3 = residentList.get(2); //("David", "Lore", "Heißstraße 2b", "Villingen", new Date(94, 07, 23));
    	Resident resident4 = residentList.get(3); //("Klemens", "Molsi", "Teststraße 2b", "Furtwangen", new Date(92, 02, 25));
    	
    	Resident residentFilter1 = new Resident("Mart*", "*", "*", "*", null);
    	Resident residentFilter2 = new Resident("*", "*", "*2b", "*", null);
    	Resident residentFilter3 = new Resident("*", "Lore", "*", "*", null);
    	Resident residentFilter4 = new Resident("David", "Lore", "Heißstraße 2b", "Villingen", new Date(94, 07, 23));
    	Resident residentFilter5 = new Resident("Martini", "Lore", "Heißstraße 2b", "Villingen", new Date(101, 02, 15));
    	Resident residentFilter6 = new Resident("Klemens", "Molsi", "Teststraße 2b", "Furtwangen", new Date(92, 02, 25));
    	
    	List<Resident> residents1 = new ArrayList<>();
    	residents1.add(resident1);
    	residents1.add(resident2);
    	
    	List<Resident> residents2 = new ArrayList<>();
    	residents2.add(resident2);
    	residents2.add(resident3);
    	residents2.add(resident4);
    	
    	List<Resident> residents3 = new ArrayList<>();
    	residents3.add(resident2);
    	residents3.add(resident3);

    	List<Resident> residents;
    	residents = brs.getFilteredResidentsList(residentFilter1);
    	assertEquals(residents, residents1);
    	residents = brs.getFilteredResidentsList(residentFilter2);
    	assertEquals(residents, residents2);
    	residents = brs.getFilteredResidentsList(residentFilter3);
    	assertEquals(residents, residents3);
    	
    	Resident resident;
		resident = brs.getUniqueResident(residentFilter4);
		assertEquals(resident, resident3);

		resident = brs.getUniqueResident(residentFilter5);
		assertEquals(resident, resident2);

		resident = brs.getUniqueResident(residentFilter6);
		assertEquals(resident, resident4);
    }
    
    /**
     * Tested ResidentService
	 * @throws ResidentServiceException 
     */
    @Test
    public void testResidentServiceMock() throws ResidentServiceException
    {
    	Resident resident1 = new Resident("Martin", "Molke", "Teststraße 1a", "Furtwangen", new Date(99, 04, 20));
    	Resident resident2 = new Resident("Martini", "Lore", "Heißstraße 2b", "Villingen", new Date(101, 02, 15));
    	List<Resident> residents = new ArrayList<>();
    	residents.add(resident1);
    	residents.add(resident2);
    	
    	
    	
    	Resident residentFilter1 = new Resident("Mart*", "*", "*", "*", null);
    	
    	ResidentRepository residentRepositoryMock = createMock(ResidentRepository.class);
    	BaseResidentService brs = new BaseResidentService();
    	brs.setResidentRepository(residentRepositoryMock);
    	expect(residentRepositoryMock.getResidents()).andStubReturn(residents);
    	
    	replay(residentRepositoryMock);
    	BaseResidentService service = new BaseResidentService();
    	service.setResidentRepository(residentRepositoryMock);
    	List<Resident> residentsFiltered = service.getFilteredResidentsList(residentFilter1);
    	Resident residentFiltered = service.getUniqueResident(resident2);
    	verify(residentRepositoryMock);
    	
    	assertThat(residents, equalTo(residentsFiltered));
    	assertThat(resident2, equalTo(residentFiltered));
    }
}
