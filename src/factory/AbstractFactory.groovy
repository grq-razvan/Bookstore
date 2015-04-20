package factory

import models.AbstractReport

abstract class AbstractFactory {

	abstract protected AbstractReport build();
	
}
