package _host.chapter04.weblog;

public class NameGenerator
{
	public static void main(String[] args)
	{
		new NameGenerator().generateStarWarsName("Mary", "Carlson", "Smith", "Colorado");
	}

	public String generateStarWarsName(String firstName, String lastName, String maiden, String birthCity)
	{
		return String.format("%s %s",
				capitalize(lastName.substring(0, 3)) + capitalize(firstName.substring(0, 2)),
				capitalize(maiden.substring(0, 2) + birthCity.substring(0, 3)));
	}

	public String capitalize(String string)
	{
		return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
	}
}
