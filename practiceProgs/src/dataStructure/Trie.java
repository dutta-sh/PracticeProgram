package dataStructure;

import java.util.HashMap;
import java.util.Map;

class TrieNode{
	Character character;
	Map<TrieNode, TrieNode> childNodes = new HashMap<>();
	
	TrieNode(Character character) {
		this.character = character;	
	}
	
	@Override
	public int hashCode() {
		return character == null ? 31 : 31 * character.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof TrieNode))
			return false;
		TrieNode other = (TrieNode) obj;
		if (character == null && other.character != null)
			return false;
		if (character != null && other.character == null)
			return false;
		if (!character.equals(other.character))
			return false;
		return true;
	}
}

public class Trie {
	private static final char END_CHAR = '#';
	
	private TrieNode root = new TrieNode(' ');
	
	public Trie addSentence(String sentence) {
		final String[] words = sentence.split(" ");
		for(String word : words) {
			addWord(word);
		}
		return this;
	}
	
	public Trie addWord(String word) {
		char[] tokens = (word + END_CHAR).toCharArray();

		TrieNode tmpNode = root;
		for(char token : tokens) {
			TrieNode tokenNode = new TrieNode(token);
			if(tmpNode.childNodes.containsKey(tokenNode)) {
				tokenNode = tmpNode.childNodes.get(tokenNode);
			} else {
				tmpNode.childNodes.put(tokenNode, tokenNode);
			}
			tmpNode = tokenNode;
		}
		return this;
	}
	
	public boolean containsWord(String word) {
		final char[] tokens = (word + END_CHAR).toCharArray();
		
		TrieNode tmpNode = root;
		for(char token : tokens) {
			final TrieNode tokenNode = new TrieNode(token);
			if(tmpNode.childNodes.containsKey(tokenNode)) {
				tmpNode = tmpNode.childNodes.get(tokenNode);
			} else {
				return false;
			}
		}
		return true;
	}
		
	public static void main(String args[]) {
		Trie javaTrie = new Trie();
		javaTrie.addWord("Welcome").addWord("To").addWord("All").addWord("Programming").addWord("Tutorials");
		System.out.println(javaTrie.containsWord("Programming"));
		System.out.println(javaTrie.containsWord("Tutorial"));
		
		Trie javaTrie1 = new Trie();
		javaTrie1.addSentence("Welcome to All Programming Tutorials");
		javaTrie1.addSentence("Welcome to dataStructure.Trie Data Structure Tutorial");
		javaTrie1.addSentence("dataStructure.Trie Data Structure Implementation in Java");
		
		System.out.println(javaTrie1.containsWord("Programming"));
		System.out.println(javaTrie1.containsWord("Tutorial"));
	}
}