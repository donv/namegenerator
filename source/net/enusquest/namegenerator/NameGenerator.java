package net.enusquest.namegenerator;

import java.util.Iterator;
import java.util.Set;

public class NameGenerator {
	private Node startNode = new Node("");

	public NameGenerator(Set names, int predictability) {
		Iterator nameIterator = names.iterator();
		GraphBuilder graphBuilder = new GraphBuilder(predictability);

		while (nameIterator.hasNext()) {
			String name = (String) nameIterator.next();

			graphBuilder.addSequence(startNode, name);
		}
	}

	public String generate() {
		String name = "";
		Node node = startNode;

		while (node != null) {
			Character nextCharacter = node.pickNextCharacter();

			node = node.getNextNode(nextCharacter);

			if (node != null) {
				name += nextCharacter.charValue();
			}
		}

		return name;
	}

}