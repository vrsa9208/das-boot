package com.vrsa9208;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vrsa9208.model.Shipwreck;
import com.vrsa9208.repository.ShipwreckRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ShipwreckRepositoryIntegrationTest {

	@Autowired
	private ShipwreckRepository shipwreckRepository;
	
	@Test
	public void testFindAll() {
		List<Shipwreck> shipwrecks = shipwreckRepository.findAll();
		assertThat(shipwrecks.size()).isGreaterThanOrEqualTo(0);
	}
}
