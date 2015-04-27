package factory


abstract class AbstractFactory {


    public static AbstractFactory getFactory(FactoryType type) {
        switch (type) {
            case FactoryType.XML_FACTORY:
                return new XMLFactory() as XMLFactory
                break
            default:
                return new TextFactory() as TextFactory
        }
    }
}
