package net.enusquest.namegenerator;

import java.util.Map;
import java.util.TreeMap;

public class GraphBuilder {
	private int predictability;
	private Map nodes = new TreeMap();

	public GraphBuilder(int newPredictability) {
		predictability = newPredictability;
	}

	public void addSequence(Node startNode, String name) {
		Node node = startNode;
		Character nextCharacter;
		String nextSequence = "";
		Node nextNode;

		nodes.put("", startNode);

		for (int i = 0; i < name.length(); i++) {
			nextCharacter = new Character(name.charAt(i));
			if (predictability > 0) {
				nextSequence = (node.getSequence().length() >= predictability
						? node.getSequence().substring(1)
						: node.getSequence())
						+ nextCharacter;
			}
			nextNode = (Node) nodes.get(nextSequence);

			if (nextNode == null) {
				nextNode = new Node(nextSequence);
				nodes.put(nextSequence, nextNode);
			}
			node.addTransition(nextCharacter, nextNode);
			node = nextNode;
		}

		node.addTransition(new Character('\0'), null);
	}

}