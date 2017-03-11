package marketplace.controllers;

import static org.mockito.Mockito.mock;

import marketplace.core.IMarketPlace;

public class MockMarketPlaceFactory {
	static public IMarketPlace marketPlace = null;
	
	public static IMarketPlace getInstance()
	{
		marketPlace = mock(IMarketPlace.class);
		return marketPlace;
	}
	
}
