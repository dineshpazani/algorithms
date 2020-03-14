package com.ds;

public class HashtableApp {

	public static void main(String[] args) {

		HashTable hashTable = new HashTable();

		hashTable.put(1, 10);
		hashTable.put(2, 100);
		hashTable.put(3, 1000);
		hashTable.put(4, 10000);
		hashTable.put(5, 100000);

		System.out.println(hashTable.get(1));
		System.out.println(hashTable.get(2));
		System.out.println(hashTable.get(3));
		System.out.println(hashTable.get(4));
		System.out.println(hashTable.get(5));
		System.out.println(hashTable.get(6));

	}

}

class HashTable {

	private HashItem[] hashTable;

	HashTable() {
		hashTable = new HashItem[Constants.TABLE_SIZE];
	}

	public int get(int key) {

		int generatedArrayIndex = hash(key);

		if (hashTable[generatedArrayIndex] == null) {
			return -1;
		} else {

			HashItem hashItem = hashTable[generatedArrayIndex];

			while (hashItem != null && hashItem.key != key) {
				hashItem = hashItem.nextHashItem;
			}

			if (hashItem == null) {
				return -1;
			} else {
				return hashItem.value;
			}

		}
	}

	public void put(int key, int value) {

		int hashArrayIndex = hash(key);

		if (hashTable[hashArrayIndex] == null) {
			hashTable[hashArrayIndex] = new HashItem(key, value);
		} else {
			HashItem hashItem = hashTable[hashArrayIndex];

			while (hashItem.nextHashItem != null) {
				hashItem = hashItem.nextHashItem;
			}

			hashItem.nextHashItem = new HashItem(key, value);
		}
	}

	private int hash(int key) {
		return key % Constants.TABLE_SIZE;
	}

}

class Constants {

	public static final int TABLE_SIZE = 10;

}

class HashItem {

	public int key;
	public int value;
	public HashItem nextHashItem;

	public HashItem(int key, int value) {
		this.key = key;
		this.value = value;
	}

}
