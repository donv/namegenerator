package net.enusquest.namegenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class NameFileReader {
	private String combinationName;

	public NameFileReader(String initialCombinationName) {
		combinationName = initialCombinationName;
	}

	public Set getNames() {
		Set names = new HashSet();
		InputStream is = NameFileReader.class.getResourceAsStream(
				combinationName + ".org");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		try {
			String name = reader.readLine();

			while (name != null) {
				names.add(name);
				name = reader.readLine();
			}
		} catch (IOException ioex) {
			System.err.println("error");
		}

		return names;
	}

}