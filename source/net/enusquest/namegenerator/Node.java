package net.enusquest.namegenerator;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class Node {
	private String sequence;
	private SortedMap transitions = new TreeMap();

	public Node(String newSequence) {
		sequence = newSequence;
	}

	public void addTransition(Character nextCharacter, Node nextNode) {
		if (transitions.containsKey(nextCharacter)) {
			Transition existingTransition = (Transition) transitions.get(
					nextCharacter);

			existingTransition.addWeight();
		} else {
			transitions.put(nextCharacter, new Transition(1, nextNode));
		}
	}

	public Character pickNextCharacter() {
		int total = 0;
		long index;
		Iterator transitionIterator = transitions.values().iterator();
		Character nextCharacter;

		while (transitionIterator.hasNext()) {
			total += ((Transition) transitionIterator.next()).getWeight();
		}

		index = Math.round(Math.random() * total);
		transitionIterator = transitions.keySet().iterator();

		do {
			nextCharacter = (Character) transitionIterator.next();
			index -= ((Transition) transitions.get(nextCharacter)).getWeight();
		} while (index > 0);

		return nextCharacter;
	}

	public Node getNextNode(Character nextCharacter) {
		Node node = ((Transition) transitions.get(nextCharacter)).getNextNode();
		return node;
	}

	public String getSequence() {
		return sequence;
	}

}