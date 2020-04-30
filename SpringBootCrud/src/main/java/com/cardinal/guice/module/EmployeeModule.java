package com.cardinal.guice.module;

import com.cardinal.guice.service.IEmployees;
import com.cardinal.guice.service.impl.EmployeesImpl;
import com.google.inject.Scopes;

public class EmployeeModule extends  com.google.inject.AbstractModule {
	@Override
	protected void configure() {
		/**
		 * PART 1:  SQUARE {singleton,custom annotation,sub-class-binding}
		 **/
		bind(IEmployees.class).to(EmployeesImpl.class).in(Scopes.SINGLETON);
	//	bind(RequestDrawSquare.class).in(Scopes.SINGLETON);
//		bind(String.class).annotatedWith(ColorValue.class).toInstance("red");
//		bind(Integer.class).annotatedWith(EdgeValue.class).toInstance(60);
	//	bind(RequestDrawSquare.class).to(RequestDrawSquareSubClass.class);
		/**************************************************************/
		
		
		/**
		 * PART 2:  CIRCLE  {Implicit Filed Injection @ImplementedBy(DrawCircleImpl.class) in  interface IDrawCircle }
		 **/
		//bind(IDrawCircle.class).to(DrawCircleImpl.class).in(Scopes.SINGLETON);
		/**************************************************************/
		
		
		/**
		 * PART 3:  RECTANGLE  {using provider}
		 **/
	//	bind(IDrawRectangle.class).toProvider(ProviderExplicitDrawRectangle.class);
		/**************************************************************/
		
		
		/**
		 * PART 4:  POLYGON {Late Instantiation and Eager Instantiation in RequestDrawPolygon }
		 * @ProvidedBy(ProviderExplicitDrawPolygon.class)} on IDrawPolygon
		 **/
		//bind(IDrawPolygon.class).toProvider(ProviderExplicitDrawPolygon.class);
		/**************************************************************/
	
		
		/**
		 * PART 5:  MAPBINDER {conditional random runtime binding in ProviderExplicitDrawPolygon }
		 **/
//		MapBinder <Integer, IDrawPolygon> mb= MapBinder.newMapBinder(binder(), Integer.class, IDrawPolygon.class);
//		mb.addBinding(0).to(DrawPolygonImpl.class);
//		mb.addBinding(1).to(DrawHexagonImpl.class);
		//bind(IDrawPolygon.class).toProvider(ProviderExplicitDrawPolygon.class); //@ProvidedBy(ProviderExplicitDrawPolygon.class) 
		/**************************************************************/
		
		
		/**
		 * PART 6:  MAPBINDER {conditional runtime binding using enum and custom Factory}
		 **/
//		MapBinder <DesignOption, IDrawPolygon> mb2= MapBinder.newMapBinder(binder(), DesignOption.class, IDrawPolygon.class);
//		mb2.addBinding(Rectangle).to(DrawRectangleImpl.class);
		//mb2.addBinding(Square).to(DrawSquareImpl.class);
		//mb2.addBinding(Circle).to(DrawCircleImpl.class);
		//bind(IDrawPolygon.class).toProvider(ProviderExplicitDrawPolygon.class); //@ProvidedBy(ProviderExplicitDrawPolygon.class) 
		/**************************************************************/
		
	}
	
	public enum DesignOption{
		Rectangle,Square,Circle;
	}
	
	
	/**
	 *PART 7:   @Provides If want all the logic in Module class instead of provider class
	 **/
//	private boolean isTimeOver(int hr) {
//		return (hr >= 14 && hr <= 18);
//	}
//	@Provides
//	public IDrawPolygon get() {
//		return this.isTimeOver(LocalTime.now().getHour()) ?  new DrawPolygonImpl() : new DrawHexagonImpl();
//	}
	/**************************************************************/
	
	/**PART 8:  
	 * @ProvidedBy if want direct implementation without using Module class  
	 * @ProvidedBy(ProviderExplicitDrawPolygon.class) in interface IDrawPolygon 
	 **/
	
	/**************************************************************/
	

}
