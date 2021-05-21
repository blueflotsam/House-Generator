package fixtures;

public abstract class Fixture {
	public Fixture(String name, String shortDescription, String longDescription) {
		Fixture.name=name;
		Fixture.shortDescription=shortDescription;
		Fixture.longDescription=longDescription;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Fixture.name = name;
	}
	public static String getShortDescription() {
		return shortDescription;
	}
	public static void setShortDescription(String shortDescription) {
		Fixture.shortDescription = shortDescription;
	}
	public static String getLongDescription() {
		return longDescription;
	}
	public static void setLongDescription(String longDescription) {
		Fixture.longDescription = longDescription;
	}
	static String name;
	static String shortDescription;
	static String longDescription;
	
}
