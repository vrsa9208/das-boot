package com.vrsa9208;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.vrsa9208.controller.ShipwreckController;
import com.vrsa9208.model.Shipwreck;
import com.vrsa9208.repository.ShipwreckRepository;

public class ShipwreckControllerTest {
	
	@InjectMocks
	private ShipwreckController sc;
	
	@Mock
	private ShipwreckRepository shipwreckRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipwreckGet() {
		Shipwreck sw = new Shipwreck();
		sw.setId(1L);
		
		when(shipwreckRepository.findById(1L)).thenReturn(Optional.of(sw));
		
		Shipwreck wreck = sc.get(1L);
		
		verify(shipwreckRepository).findById(1L);
		//assertEquals(1L, wreck.getId().longValue());
		assertThat(wreck.getId()).isEqualTo(1L);
	}
	
	@Test
	public void testShipwreckGetAll() {
		List<Shipwreck> shipwrecks = new ArrayList<>();
		shipwrecks.add(new Shipwreck());
		shipwrecks.add(new Shipwreck());
		
		when(shipwreckRepository.findAll()).thenReturn(shipwrecks);
		
		//assertEquals(2, sc.list().size());
		assertThat(sc.list().size()).isGreaterThan(0);
		assertThat(sc.list().size()).isEqualTo(2);
	}
}
