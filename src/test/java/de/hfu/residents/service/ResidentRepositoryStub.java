package de.hfu.residents.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;

public class ResidentRepositoryStub implements ResidentRepository {
	
	private Resident resident1 = new Resident("Martin", "Molke", "Teststraße 1a", "Furtwangen", new Date(99, 04, 20));
	private Resident resident2 = new Resident("Martini", "Lore", "Heißstraße 2b", "Villingen", new Date(101, 02, 15));
	private Resident resident3 = new Resident("David", "Lore", "Heißstraße 2b", "Villingen", new Date(94, 07, 23));
	private Resident resident4 = new Resident("Klemens", "Molsi", "Teststraße 2b", "Furtwangen", new Date(92, 02, 25));
	
	public List<Resident> getResidents(){
		List<Resident> residents = new ArrayList<>();
		residents.add(resident1);
		residents.add(resident2);
		residents.add(resident3);
		residents.add(resident4);
		return residents;
	}
}
